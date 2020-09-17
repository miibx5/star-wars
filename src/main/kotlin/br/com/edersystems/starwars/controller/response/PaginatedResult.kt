/*
Project .....................: star-wars
Creation Date ...............: 17/09/2020 18:22:14
Developer....................: ederluciano
Copyright....................: 2020
Codification.................: UTF-8
...........................................................
 Éder L. Costa - © Copyright 2020 - All Rights Reserved
...........................................................
*/
package br.com.edersystems.starwars.controller.response

class PaginatedResult<T>(private val elements: List<T>, private val totalElements: Long, private val offset: Long, private val limit: Int) {
    companion object {
        const val DEFAULT_OFFSET: Long = 0
        const val DEFAULT_MAX_NO_OF_ROWS = 100
    }
}