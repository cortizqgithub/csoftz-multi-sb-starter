/*----------------------------------------------------------------------------*/
/* Source File:   CONTROLLEREXCEPTIONHANDLERCONSTANTS.KT                      */
/* Copyright (c), 2025 The Musketeers                                         */
/*----------------------------------------------------------------------------*/
/*-----------------------------------------------------------------------------
 History
 Jan.13/2025  COQ  File created.
 -----------------------------------------------------------------------------*/
package com.csoftz.multi.sb.starter.common.constants

/**
 * Constants associated with Controller Exception Handler.
 *
 * @author COQ - Carlos Adolfo Ortiz Q.
 */
object ControllerExceptionHandlerConstants {
    /*
     * General
    */
    const val USER_NOT_FOUND_ERROR_URL = "/api/v1/users"

    /*
     * Error Category
    */
    const val ERROR_CATEGORY_GENERIC = "Generic"
    const val ERROR_CATEGORY_PARAMETERS = "Parameters"

    /*
     * Title
    */
    const val TITLE_BAD_REQUEST_ON_PAYLOAD = "Bad Request on payload"
    const val TITLE_USER_NOT_FOUND = "Not Found"
    const val TITLE_VALIDATION_ERROR_ON_SUPPLIED_PAYLOAD = "Validation error on supplied payload"

    /*
     * Property
    */
    const val PROPERTY_TIMESTAMP = "timestamp"
    const val PROPERTY_ERROR_CATEGORY = "errorCategory"
    const val PROPERTY_ERRORS = "errors"
}
