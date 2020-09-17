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

import br.com.edersystems.starwars.controller.request.PlanetRequest
import br.com.edersystems.starwars.model.entities.Planet
import br.com.edersystems.starwars.model.repository.PlanetRepository
import org.springframework.stereotype.Service

@Service
class PlanetService(private val repository: PlanetRepository) {

    fun create(request: PlanetRequest): Planet {
        var planet = Planet(request)
        planet = this.repository.save(planet)
        return planet
    }

    fun getById(id: Long) = this.repository.findById(id)
}