/*----------------------------------------------------------------------------*/
/* Source File:   APIEXCEPTION.KT                                             */
/* Copyright (c), 2025 The Musketeers                                         */
/*----------------------------------------------------------------------------*/
/*-----------------------------------------------------------------------------
 History
 Jan.13/2025  COQ  File created.
 -----------------------------------------------------------------------------*/
package com.csoftz.multi.sb.starter.common.exception

/**
 * An exception model for errors in downstream service requests.
 * @param message   Description of the exception.
 * @param url       Identifies the location where the exception occurred.
 * @param errorCode HTTP error number for the exception.
 * @author COQ - Carlos Adolfo Ortiz Q.
 */
class ApiException(message: String, private val url: String, private val errorCode: String) : RuntimeException(message)
