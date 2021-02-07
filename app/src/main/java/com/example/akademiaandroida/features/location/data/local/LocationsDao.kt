package com.example.akademiaandroida.features.location.data.local

import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.akademiaandroida.features.location.data.local.model.LocationsCached

interface LocationsDao {


    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveLocations(vararg locations: LocationsCached)

    @Query("SELECT * FROM LocationsCached")
    suspend fun getLocations(): List<LocationsCached>
}