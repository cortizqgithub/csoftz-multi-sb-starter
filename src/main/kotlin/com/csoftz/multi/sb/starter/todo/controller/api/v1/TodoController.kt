/*----------------------------------------------------------------------------*/
/* Source File:   TODOCONTROLLER.KT                                           */
/* Copyright (c), 2025 CSoftZ                                                 */
/*----------------------------------------------------------------------------*/
/*-----------------------------------------------------------------------------
 History
 Jan.10/2025  COQ  File created.
 -----------------------------------------------------------------------------*/
package com.csoftz.multi.sb.starter.todo.controller.api.v1

import com.themusketeers.jps.todo.JPSTodoClient
import com.themusketeers.jps.todo.model.Todo
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

/**
 * Exposes endpoints to consume JSON PlaceHolder service.
 * @param jpsTodoClient Reference to the Rest Client API consumer to JsSON PlaceHolder Service.
 * @author COQ - Carlos Adolfo Ortiz Q.
 */
@RestController
@RequestMapping("/api/v1/todos")
class TodoController(private val jpsTodoClient: JPSTodoClient) {
    /**
     * Retrieves a list of [Todo] items.
     * GET /api/v1/todos
     *
     * @return List of items
     */
    @GetMapping
    fun findAll(): Flux<Todo> = jpsTodoClient.findAll()

    /**
     * Find a [Todo] record using an 'id'. If record is not found an HTTP 400 is returned (see
     *
     * @param id Indicates the identifier we want to locate.
     * @return The requested information.
     */
    @GetMapping("{id}")
    fun retrieveById(@PathVariable id: Int?): Mono<Todo> = jpsTodoClient.findById(id)
}
