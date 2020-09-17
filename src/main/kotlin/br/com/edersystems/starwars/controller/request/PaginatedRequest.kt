/*
Project .....................: star-wars
Creation Date ...............: 17/09/2020 18:12:32
Developer....................: ederluciano
Copyright....................: 2020
Codification.................: UTF-8
...........................................................
 Éder L. Costa - © Copyright 2020 - All Rights Reserved
...........................................................
*/
package br.com.edersystems.starwars.controller.request

import org.springframework.data.domain.Pageable
import org.springframework.data.domain.Sort

class PaginatedRequest : Pageable {
    private var limit = 0
    private var offset = 0
    private var sort: Sort

    constructor() {
        sort = Sort.by(Sort.Direction.ASC, "id")
    }

    @JvmOverloads
    constructor(offset: Int, limit: Int, sort: Sort = Sort.by(Sort.Direction.ASC, "id")) {
        require(offset >= 0) { "schedule.offset_less_than_zero" }
        require(limit >= 1) { "schedule.limit_less_than_one" }
        this.limit = limit
        this.offset = offset
        this.sort = sort
    }

    constructor(offset: Int, limit: Int, direction: Sort.Direction?, vararg properties: String?) : this(offset, limit, Sort.by(direction!!, *properties)) {}

    override fun getPageNumber(): Int {
        return offset / limit
    }

    override fun getPageSize(): Int {
        return limit
    }

    override fun getOffset(): Long {
        return offset.toLong()
    }

    override fun getSort(): Sort {
        return sort
    }

    override fun next(): Pageable {
        return PaginatedRequest(java.lang.Long.valueOf(getOffset()).toInt() + pageSize, pageSize, getSort())
    }

    override fun previousOrFirst(): Pageable {
        return if (hasPrevious()) PaginatedRequest(java.lang.Long.valueOf(getOffset()).toInt() - pageSize, pageSize, getSort()) else this
    }

    override fun first(): Pageable {
        return if (hasPrevious()) previousOrFirst() else first()
    }

    override fun hasPrevious(): Boolean {
        return offset > limit
    }
}