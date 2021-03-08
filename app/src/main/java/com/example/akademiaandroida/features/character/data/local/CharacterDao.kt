package com.example.akademiaandroida.features.character.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.akademiaandroida.features.character.data.local.model.CharacterCached

@Dao
interface CharactersDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveCharacters(vararg character: CharacterCached)

    @Query("SELECT * FROM CharacterCached")
    suspend fun getCharacters(): List<CharacterCached>
}
