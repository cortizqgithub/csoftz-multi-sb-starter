/*----------------------------------------------------------------------------*/
/* Source File:   TODOCONTROLLERTEST.JAVA                                     */
/* Copyright (c), 2025 CSoftZ                                                 */
/*----------------------------------------------------------------------------*/
/*-----------------------------------------------------------------------------
 History
 Jan.10/2025  COQ  File created.
 -----------------------------------------------------------------------------*/
package com.csoftz.multi.sb.starter.todo.controller.api.v1

import com.themusketeers.jps.common.config.JsonPlaceholderServiceAutoConfiguration
import com.themusketeers.jps.todo.model.Todo
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.autoconfigure.web.reactive.function.client.WebClientAutoConfiguration
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest
import org.springframework.context.annotation.Import
import org.springframework.http.HttpHeaders
import org.springframework.http.MediaType
import org.springframework.test.web.reactive.server.EntityExchangeResult
import org.springframework.test.web.reactive.server.WebTestClient

@WebFluxTest(TodoController::class)
@Import(WebClientAutoConfiguration::class, JsonPlaceholderServiceAutoConfiguration::class)
class TodoControllerTest {
    companion object {
        const val TODO_CONTROLLER_BASE_PATH = "/api/v1/todos"
        const val TODO_CONTROLLER_BASE_PATH_ID = "/api/v1/todos/{id}"
        const val TODO_TITLE = "ipsam aperiam voluptates qui"

        const val TODO_LIST_EXPECTED_SIZE = 200
        const val TODO_ID = 200
        const val TODO_USER_ID = 10
    }

    @Autowired
    private lateinit var client: WebTestClient

    @Test
    @DisplayName("Should Retrieve TODO List")
    fun shouldRetrieveTODOList() {
        client.get()
            .uri(TODO_CONTROLLER_BASE_PATH)
            .accept(MediaType.APPLICATION_JSON)
            .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
            .exchange()
            .expectStatus().isOk()
            .expectBodyList(Todo::class.java)
            .consumeWith<WebTestClient.ListBodySpec<Todo>> { response ->
                val resBody = response.responseBody

                assertThat(resBody)
                    .isNotNull()
                    .isNotEmpty()
                    .hasSize(TODO_LIST_EXPECTED_SIZE);
            }
    }

    @Test
    @DisplayName("Should Retrieve a TODO by ID")
    fun shouldRetrieveTODOById() {
        val expectedTodo: Todo = buildTodo()

        client.get()
            .uri(TODO_CONTROLLER_BASE_PATH_ID, TODO_ID)
            .accept(MediaType.APPLICATION_JSON)
            .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
            .exchange()
            .expectStatus().isOk()
            .expectBody<Todo?>(Todo::class.java)
            .consumeWith { response: EntityExchangeResult<Todo?> ->
                val resBody = response.responseBody

                assertThat(resBody)
                    .isNotNull()
                    .isEqualTo(expectedTodo)
            }
    }

    private fun buildTodo(): Todo {
        return Todo(TODO_USER_ID, TODO_ID, TODO_TITLE, false)
    }

}
