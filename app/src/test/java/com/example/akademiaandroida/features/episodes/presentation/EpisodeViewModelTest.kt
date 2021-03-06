package com.example.akademiaandroida.features.episodes.presentation

import androidx.lifecycle.Observer
import androidx.lifecycle.viewModelScope
import com.example.akademiaandroida.core.base.UiState
import com.example.akademiaandroida.core.exeption.ErrorMapper
import com.example.akademiaandroida.features.episodes.all.presentation.EpisodeViewModel
import com.example.akademiaandroida.features.episodes.all.presentation.model.EpisodeDisplayable
import com.example.akademiaandroida.features.episodes.domain.GetEpisodesUseCase
import com.example.akademiaandroida.features.episodes.domain.model.Episode
import com.example.akademiaandroida.features.episodes.navigation.EpisodeNavigator
import com.example.akademiaandroida.mock.mock
import com.example.akademiaandroida.utils.ViewModelTest
import com.example.akademiaandroida.utils.getOrAwaitValue
import com.example.akademiaandroida.utils.observeForTesting
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import org.amshove.kluent.shouldBe
import org.junit.jupiter.api.Test

internal class EpisodeViewModelTest : ViewModelTest() {

    @Test
    fun `WHEN episode is clicked THEN open episode details screen`() {

        //given
        val errorMapper = mockk<ErrorMapper>(relaxed = true)
        val useCase = mockk<GetEpisodesUseCase>(relaxed = true)
        val episodeNavigator = mockk<EpisodeNavigator>(relaxed = true)
        val viewModel =
            EpisodeViewModel(
                useCase,
                episodeNavigator,
                errorMapper
            )
        val episode = EpisodeDisplayable.mock()

        //when
        viewModel.onEpisodeClick(episode)

        //then
        verify { episodeNavigator.openEpisodeDetailsScreen(episode) }
    }

    @Test
    fun `WHEN episode liveData is observed THEN set pending state`() {

        //given
        val errorMapper = mockk<ErrorMapper>(relaxed = true)
        val useCase = mockk<GetEpisodesUseCase>(relaxed = true)
        val episodeNavigator = mockk<EpisodeNavigator>(relaxed = true)
        val viewModel =
            EpisodeViewModel(
                useCase,
                episodeNavigator,
                errorMapper
            )

        //when
        viewModel.episodes.observeForTesting()

        //then
        viewModel.uiState.getOrAwaitValue() shouldBe UiState.Pending
    }

    @Test
    fun `WHEN episode liveData is observed THEN invoke use case to get episodes`() {
        //given
        val errorMapper = mockk<ErrorMapper>(relaxed = true)
        val useCase = mockk<GetEpisodesUseCase>(relaxed = true)
        val episodeNavigator = mockk<EpisodeNavigator>(relaxed = true)
        val viewModel =
            EpisodeViewModel(
                useCase,
                episodeNavigator,
                errorMapper
            )

        //when
        viewModel.episodes.observeForTesting()

        //then
        verify { useCase(Unit, viewModel.viewModelScope, any(), any()) }
    }

    @Test
    fun `GIVEN use case result is success WHEN episode liveData is observed THEN set idle state AND set result in liveData`() {
        //given
        val errorMapper = mockk<ErrorMapper>(relaxed = true)
        val episodes = listOf(Episode.mock(), Episode.mock(), Episode.mock())
        val episodeNavigator = mockk<EpisodeNavigator>(relaxed = true)
        val useCase = mockk<GetEpisodesUseCase> {
            every { this@mockk(any(), any(), any(), any()) } answers {
                lastArg<(Result<List<Episode>>) -> Unit>()(Result.success(episodes))
            }
        }
        val viewModel =
            EpisodeViewModel(
                useCase,
                episodeNavigator,
                errorMapper
            )

        //when
        viewModel.episodes.observeForTesting()

        //then
        viewModel.uiState.getOrAwaitValue() shouldBe UiState.Idle
        viewModel.episodes.getOrAwaitValue().forEachIndexed { index, episodeDisplayable ->
            val episode = episodes[index]
            episodeDisplayable.name shouldBe episode.name
            episodeDisplayable.airDate shouldBe episode.airDate
            episodeDisplayable.code shouldBe episode.code
        }
    }

    @Test
    fun `GIVEN use case result is success WHEN episode liveData is observed THEN set idle state AND set error message in liveData`() {
        //given

        val throwable = Throwable("Oops... Something went wrong")
        val useCase = mockk<GetEpisodesUseCase> {
            every { this@mockk(any(), any(), any(), any()) } answers {
                lastArg<(Result<List<Episode>>) -> Unit>()(Result.failure(throwable))
            }
        }
        val episodeNavigator = mockk<EpisodeNavigator>(relaxed = true)
        val errorMapper = mockk<ErrorMapper> {
            every { map(any()) } returns throwable.message!!
        }
        val observer = mockk<Observer<String>>(relaxed = true)
        val viewModel =
            EpisodeViewModel(
                useCase,
                episodeNavigator,
                errorMapper
            )

        //when
        viewModel.message.observeForever(observer)
        viewModel.episodes.observeForTesting()

        //then
        viewModel.uiState.getOrAwaitValue() shouldBe UiState.Idle
        verify { observer.onChanged(throwable.message) }
    }
}
