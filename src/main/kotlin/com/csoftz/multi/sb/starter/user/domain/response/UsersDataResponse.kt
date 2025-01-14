/*----------------------------------------------------------------------------*/
/* Source File:   USERDATARESPONSE.JAVA                                       */
/* Copyright (c), 2025 The Musketeers                                         */
/*----------------------------------------------------------------------------*/
/*-----------------------------------------------------------------------------
 History
 Jan.07/2025  COQ  File created.
 -----------------------------------------------------------------------------*/
package com.csoftz.multi.sb.starter.user.domain.response

import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.annotation.JsonPropertyOrder
import com.csoftz.user.domain.User
import reactor.core.publisher.Flux

/**
 * Keeps the users for the User List response.
 *
 * @param count Indicates how many users are registered in the system.
 * @param users Indicates the registered User List.
 * @author COQ - Carlos Adolfo Ortiz Q.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder("count", "users")
data class UsersDataResponse(val count: Long, val users: Flux<User>)

/**
 * Keeps the users for the User List response.
 *
 * @param user Indicates one user information record retrieved.
 * @author COQ - Carlos Adolfo Ortiz Q.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder("user")
data class UserDataResponse(val user: User)
