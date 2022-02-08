package com.example.hiltmvvm.data.network.service

import com.example.hiltmvvm.data.network.dto.ResponseCharacter
import retrofit2.Response
import retrofit2.http.GET

interface CharacterService {

    @GET("character")
    suspend fun getCharacter(): Response<ResponseCharacter>


}