/*----------------------------------------------------------------------------*/
/* Source File:   USERCONTROLLER.KT                                           */
/* Copyright (c), 2025 CSoftZ                                                 */
/*----------------------------------------------------------------------------*/
/*-----------------------------------------------------------------------------
 History
 Jan.13/2025  COQ  File created.
 -----------------------------------------------------------------------------*/
package com.csoftz.multi.sb.starter.user.controller.api.v1

import com.csoftz.multi.sb.starter.common.constants.GlobalConstants.USER_CONTROLLER_DELETE_USER_INFO
import com.csoftz.multi.sb.starter.common.constants.GlobalConstants.USER_CONTROLLER_GET_RETRIEVE_USERS_INFO
import com.csoftz.multi.sb.starter.common.constants.GlobalConstants.USER_CONTROLLER_GET_RETRIEVE_USER_INFO
import com.csoftz.multi.sb.starter.common.constants.GlobalConstants.USER_CONTROLLER_PATCH_USER_INFO
import com.csoftz.multi.sb.starter.common.constants.GlobalConstants.USER_CONTROLLER_POST_INSERT_USER_INFO
import com.csoftz.multi.sb.starter.user.domain.response.UserDataResponse
import com.csoftz.multi.sb.starter.user.domain.response.UsersDataResponse
import com.csoftz.multi.sb.starter.user.exception.UserNotFoundException
import com.csoftz.user.domain.User
import com.csoftz.user.service.UserService
import jakarta.validation.Valid
import org.slf4j.LoggerFactory
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PatchMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController

/**
 * User API Controller.
 * <p><b>Path:</b>{@code api/v1/users}</p>
 *
 * @author COQ - Carlos Adolfo Ortiz Q.
 */
@RestController
@RequestMapping("api/v1/user")
class UserController(val userService: UserService) {
    private val log = LoggerFactory.getLogger(UserController::class.java)

    /**
     * Retrieves all users registered in the system.
     * <p>{@code GET: api/v1/users}</p>
     *
     * @return Registered information.
     */
    @GetMapping
    fun retrieveUsers(): UsersDataResponse {
        log.info(USER_CONTROLLER_GET_RETRIEVE_USERS_INFO)

        return UsersDataResponse(userService.count(), userService.retrieveAll())
    }

    /**
     * Retrieve one user registered in the system.
     * <p>{@code GET: api/v1/users/{userId} }</p>
     *
     * @param userId Indicates the user unique identifier to search. If it is empty or NULL an exception is thrown.
     * @return If it is not found an HTTP 404 is returned, otherwise an HTTP 200 is returned with the proper information.
     */
    @GetMapping("{userId}")
    fun retrieveUser(@PathVariable userId: String): UserDataResponse {
        log.info(USER_CONTROLLER_GET_RETRIEVE_USER_INFO)
        log.info("==> User Id=[$userId]")

        val userRetrieved = userService.retrieve(userId) ?: throw UserNotFoundException(userId)

        return UserDataResponse(userRetrieved)
    }

    /**
     * Add new record to the User List system.
     * <p>{@code POST: api/v1/users}</p>
     * <p>For the User to be inserted there are validations for required fields, {@code name} and {@code address}.
     * A BAD REQUEST 400 error code is returned when {@code payload} is mal formed.</p>
     *
     * @param user Includes the user information to insert.
     * @return Record with 'Id' inserted.
     */
    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    fun insertUser(@Valid @RequestBody user: User): User {
        log.info(USER_CONTROLLER_POST_INSERT_USER_INFO)
        log.info("==> Payload user=[$user]")

        return userService.insert(user)
    }

    /**
     * Modifies the data for the user.
     * <p>{@code PATCH: api/v1/users}</p>
     * <p>For the User to be inserted there are validations for required fields, {@code name} and {@code address}.
     * A BAD REQUEST 400 error code is returned when {@code payload} is mal formed.</p>
     *
     * @param user Includes the user information to update.
     * @return If record is not found, then an HTTP 404 is returned, otherwise an HTTP 200 is returned.
     */
    @PatchMapping
    fun updateUser(@Valid @RequestBody user: User): User {
        log.info(USER_CONTROLLER_PATCH_USER_INFO)
        log.info("==> Payload user=[$user]")

        if (!userService.update(user)) {
            throw UserNotFoundException(user.id)
        }

        return user
    }

    /**
     * Removes an User from the system.
     *
     * <p>{@code DELETE api/v1/users/{userId}}</p>
     *
     * @param userId Indicates the user unique identifier to search. If it is empty or NULL an exception is thrown.
     * @return HTTP 200 if removed, HTTP 404 if user record not found.
     */
    @DeleteMapping("{userId}")
    fun deleteUser(@PathVariable userId: String): Boolean {
        log.info(USER_CONTROLLER_DELETE_USER_INFO)
        log.info("==> User Id=[$userId]")

        if (!userService.delete(userId)) {
            throw UserNotFoundException(userId)
        }

        return true
    }
}
