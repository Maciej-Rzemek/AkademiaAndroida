package com.example.akademiaandroida.features.episodes.domain

import com.example.akademiaandroida.features.episodes.EpisodesRepository
import io.mockk.coVerify
import io.mockk.mockk
import kotlinx.coroutines.GlobalScope
import org.junit.jupiter.api.Test

internal class GetEpisodesUseCaseTest {

    @Test
    fun `when use case is invoked then execute getEpisodes method from repository`() {
        // given
        val repository = mockk<EpisodesRepository>(relaxed = true)
        val useCase = GetEpisodesUseCase(repository)

        //when
        useCase(
            params = Unit,
            scope = GlobalScope
        )

        //then
        coVerify {
            repository.getEpisodes()
        }
    }
}