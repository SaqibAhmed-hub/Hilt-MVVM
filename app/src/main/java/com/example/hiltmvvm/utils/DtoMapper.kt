package com.example.hiltmvvm.utils

interface DtoMapper<Dto,DomainModel> {

    fun mapfromDto(dto:Dto): DomainModel

    fun maptoDto(model: DomainModel):Dto

}