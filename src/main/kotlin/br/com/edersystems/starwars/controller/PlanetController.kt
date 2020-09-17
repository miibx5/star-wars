/*
Project .....................: star-wars
Creation Date ...............: 17/09/2020 18:23:39
Developer....................: ederluciano
Copyright....................: 2020
Codification.................: UTF-8
...........................................................
 Éder L. Costa - © Copyright 2020 - All Rights Reserved
...........................................................
*/
package br.com.edersystems.starwars.controller

import br.com.edersystems.starwars.controller.request.PlanetRequest
import br.com.edersystems.starwars.model.entities.Planet
import br.com.edersystems.starwars.model.service.PlanetService

import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping(value = ["/planet"], produces = [MediaType.APPLICATION_JSON_VALUE])
class PlanetController(private val service: PlanetService) {

    @PostMapping(consumes = [MediaType.APPLICATION_JSON_VALUE])
    fun create(@RequestBody request: PlanetRequest): ResponseEntity<Planet> {
        return ResponseEntity.status(HttpStatus.CREATED).body(this.service.create(request))
    }
}