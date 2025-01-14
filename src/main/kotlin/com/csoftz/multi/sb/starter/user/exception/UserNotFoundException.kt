/*----------------------------------------------------------------------------*/
/* Source File:   USERNOTFOUNDEXCEPTION.KT                                    */
/* Copyright (c), 2023 CSoftZ                                                 */
/*----------------------------------------------------------------------------*/
/*-----------------------------------------------------------------------------
 History
 Jan.13/2025  COQ  File created.
 -----------------------------------------------------------------------------*/
package com.csoftz.multi.sb.starter.user.exception

import com.csoftz.multi.sb.starter.common.constants.ExceptionConstants.NOT_FOUND
import com.csoftz.multi.sb.starter.common.constants.ExceptionConstants.USER_WITH_ID

/**
 * An exception model for errors for User data.
 * @param userId Indicates the `userId` which was not found.
 * @author COQ - Carlos Adolfo Ortiz Q.
 */
class UserNotFoundException(userId: String?) : RuntimeException(USER_WITH_ID + userId + NOT_FOUND)
