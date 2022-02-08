package com.example.hiltmvvm.data.repository

import com.example.hiltmvvm.data.network.dto.Result
import com.example.hiltmvvm.data.network.service.CharacterService
import com.example.hiltmvvm.utils.NetworkResource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.lang.Exception
import javax.inject.Inject


class MainRepository @Inject constructor(
    private val characterService: CharacterService
) {

    suspend fun getCharacterData(): Flow<List<Result>> = flow {
        try {
            val response = characterService.getCharacter()
            if (response.isSuccessful) {
                val data = response.body()?.results!!
                emit(data)
            }

        } catch (e: Exception) {
            emit(emptyList())
        }

    }


}