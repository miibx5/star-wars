/*
Project .....................: star-wars
Creation Date ...............: 17/09/2020 18:04:13
Developer....................: ederluciano
Copyright....................: 2020
Codification.................: UTF-8
...........................................................
 Éder L. Costa - © Copyright 2020 - All Rights Reserved
...........................................................
*/package br.com.edersystems.starwars.model.service

import br.com.edersystems.starwars.controller.request.PaginatedRequest
import br.com.edersystems.starwars.controller.request.PlanetRequest
import br.com.edersystems.starwars.controller.response.PaginatedResult
import br.com.edersystems.starwars.model.entities.Planet
import br.com.edersystems.starwars.model.repository.PlanetRepository
import org.springframework.stereotype.Service


@Service
class PlanetService(private val repository: PlanetRepository) {

    fun create(request: PlanetRequest) = this.repository.save(Planet(request))

    fun getById(id: Long): Planet = this.repository.findById(id).orElseGet(null)

    fun gePlanet(request: PaginatedRequest?): PaginatedResult<Planet> {
        val pagePlanets = request?.let { this.repository.findAll(it) }
        val planets: List<Planet> = (pagePlanets?.content ?: pagePlanets?.content) as List<Planet>
        return PaginatedResult(planets, pagePlanets!!.totalElements, request.offset, request.pageSize)
    }

    fun update(request: PlanetRequest): Planet {
        if (request.id == null) {
            throw IllegalArgumentException()
        }
        return this.create(request)
    }
}