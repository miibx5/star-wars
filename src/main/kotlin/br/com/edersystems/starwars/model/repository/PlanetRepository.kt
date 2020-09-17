/*
Project .....................: star-wars
Creation Date ...............: 17/09/2020 18:02:28
Developer....................: ederluciano
Copyright....................: 2020
Codification.................: UTF-8
...........................................................
 Éder L. Costa - © Copyright 2020 - All Rights Reserved
...........................................................
*/
package br.com.edersystems.starwars.model.repository

import br.com.edersystems.starwars.model.entities.Planet
import org.springframework.data.repository.PagingAndSortingRepository
import org.springframework.stereotype.Repository

@Repository
interface PlanetRepository : PagingAndSortingRepository<Planet, Long> {
}