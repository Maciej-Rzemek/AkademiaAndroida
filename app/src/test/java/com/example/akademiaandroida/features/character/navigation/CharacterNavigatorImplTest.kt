package com.example.akademiaandroida.features.character.navigation

import com.example.akademiaandroida.R
import com.example.akademiaandroida.core.navigation.FragmentNavigator
import com.example.akademiaandroida.features.character.all.presentation.model.CharacterDisplayable
import com.example.akademiaandroida.mock.mock
import io.mockk.mockk
import io.mockk.slot
import io.mockk.verify
import org.amshove.kluent.shouldBe
import org.junit.jupiter.api.Test

internal class CharacterNavigatorImplTest {

    @Test
    fun `WHEN openCharactersDetailsScreen is called THEN invoke navigateTo method with appropriate action and character model as argument`() {
        //given
        val fragmentNavigator = mockk<FragmentNavigator>(relaxed = true)
        val characterNavigator: CharacterNavigator = CharacterNavigatorImpl(fragmentNavigator)
        val character = CharacterDisplayable.mock()
        val slot = slot<Pair<String, CharacterDisplayable>>()

        //when
        characterNavigator.openCharacterDetailsScreen(character)

        //then
        verify {
            fragmentNavigator.navigateTo(
                R.id.action_navigate_from_character_screen_to_character_details_screen,
                capture(slot)
            )
        }
        slot.captured.second shouldBe character
    }

    @Test
    fun `WHEN goBack is called THEN invoke goBack method of FragmentNavigator`() {
        //given
        val fragmentNavigator = mockk<FragmentNavigator>(relaxed = true)
        val characterNavigator: CharacterNavigator = CharacterNavigatorImpl(fragmentNavigator)

        //when
        characterNavigator.goBack()

        //then
        verify { fragmentNavigator.goBack() }
    }
}