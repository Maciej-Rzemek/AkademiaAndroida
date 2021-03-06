package com.example.akademiaandroida.features.character.presentation

import androidx.lifecycle.Observer
import androidx.lifecycle.viewModelScope
import com.example.akademiaandroida.core.base.UiState
import com.example.akademiaandroida.core.exeption.ErrorMapper
import com.example.akademiaandroida.features.character.all.presentation.CharacterViewModel
import com.example.akademiaandroida.features.character.all.presentation.model.CharacterDisplayable
import com.example.akademiaandroida.features.character.domain.GetCharactersUseCase
import com.example.akademiaandroida.features.character.domain.model.Character
import com.example.akademiaandroida.features.character.navigation.CharacterNavigator
import com.example.akademiaandroida.mock.mock
import com.example.akademiaandroida.utils.ViewModelTest
import com.example.akademiaandroida.utils.getOrAwaitValue
import com.example.akademiaandroida.utils.observeForTesting
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import org.amshove.kluent.shouldBe
import org.junit.jupiter.api.Test

internal class CharacterViewModelTest : ViewModelTest() {

    @Test
    fun `WHEN episode is clicked THEN open episode details screen`() {
        //given
        val errorMapper = mockk<ErrorMapper>(relaxed = true)
        val useCase = mockk<GetCharactersUseCase>(relaxed = true)
        val characterNavigator = mockk<CharacterNavigator>(relaxed = true)
        val viewModel =
            CharacterViewModel(
                useCase,
                characterNavigator,
                errorMapper
            )
        val character = CharacterDisplayable.mock()

        //when
        viewModel.onCharacterClick(character)

        //then
        verify { characterNavigator.openCharacterDetailsScreen(character) }
    }

    @Test
    fun `WHEN characters liveData is observed THEN set pending state`() {

        //given
        val errorMapper = mockk<ErrorMapper>(relaxed = true)
        val useCase = mockk<GetCharactersUseCase>(relaxed = true)
        val characterNavigator = mockk<CharacterNavigator>(relaxed = true)
        val viewModel =
            CharacterViewModel(
                useCase,
                characterNavigator,
                errorMapper
            )

        //when
        viewModel.characters.observeForTesting()

        // then
        viewModel.uiState.getOrAwaitValue() shouldBe UiState.Pending
    }

    @Test
    fun `WHEN characters liveData is observed THEN invoke use case to get characters`() {
        //given
        val errorMapper = mockk<ErrorMapper>(relaxed = true)
        val useCase = mockk<GetCharactersUseCase>(relaxed = true)
        val characterNavigator = mockk<CharacterNavigator>(relaxed = true)

        val viewModel =
            CharacterViewModel(
                useCase,
                characterNavigator,
                errorMapper
            )

        //when
        viewModel.characters.observeForTesting()

        //then
        verify { useCase(Unit, viewModel.viewModelScope, any(), any()) }
    }

    @Test
    fun `GIVEN use case result is success WHEN characters liveData is observed THEN set idle state AND set result in liveData`() {

        //given
        val errorMapper = mockk<ErrorMapper>(relaxed = true)
        val characterNavigator = mockk<CharacterNavigator>(relaxed = true)
        val characters = listOf(Character.mock(), Character.mock(), Character.mock())
        val useCase = mockk<GetCharactersUseCase> {
            every { this@mockk(any(), any(), any(), any()) } answers {
                lastArg<(Result<List<Character>>) -> Unit>()(Result.success(characters))
            }
        }
        val viewModel =
            CharacterViewModel(
                useCase,
                characterNavigator,
                errorMapper
            )

        //when
        viewModel.characters.observeForTesting()

        //then
        viewModel.uiState.getOrAwaitValue() shouldBe UiState.Idle
        viewModel.characters.getOrAwaitValue().forEachIndexed { index, characterDisplayable ->
            val character = characters[index]
            characterDisplayable.name shouldBe character.name
            characterDisplayable.image shouldBe character.image
            characterDisplayable.species shouldBe character.species
            characterDisplayable.type shouldBe character.type
        }
    }

    @Test
    fun `GIVEN use case result is failure WHEN characters live data is observed THEN set idle state AND set error message in live data`() {
        //given

        val throwable = Throwable("Oops... Something went wrong")
        val useCase = mockk<GetCharactersUseCase> {
            every { this@mockk(any(), any(), any(), any()) } answers {
                lastArg<(Result<List<Character>>) -> Unit>()(Result.failure(throwable))
            }
        }
        val characterNavigator = mockk<CharacterNavigator>(relaxed = true)
        val errorMapper = mockk<ErrorMapper> {
            every { map(any()) } returns throwable.message!!
        }
        val observer = mockk<Observer<String>>(relaxed = true)
        val viewModel =
            CharacterViewModel(
                useCase,
                characterNavigator,
                errorMapper
            )

        //when
        viewModel.message.observeForever(observer)
        viewModel.characters.observeForTesting()

        // then
        viewModel.uiState.getOrAwaitValue() shouldBe UiState.Idle
        verify { observer.onChanged(throwable.message) }
    }
}