/*
Project .....................: star-wars
Creation Date ...............: 17/09/2020 17:44:38
Developer....................: ederluciano
Copyright....................: 2020
Codification.................: UTF-8
...........................................................
 Éder L. Costa - © Copyright 2020 - All Rights Reserved
...........................................................
*/
package br.com.edersystems.starwars.model.entities

import br.com.edersystems.starwars.controller.request.PlanetRequest
import javax.persistence.*

@Entity
@Table(name = "planets")
data class Planet(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        val id: Long?, val name: String,
        @Column(length = 50, nullable = false)
        val climate: String,
        @Column(length = 70, nullable = false)
        val ground: String
) {
    constructor(request: PlanetRequest) : this(request.id, request.name, request.climate, request.ground)
}     