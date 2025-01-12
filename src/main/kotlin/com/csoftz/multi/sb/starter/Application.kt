/*----------------------------------------------------------------------------*/
/* Source File:   APPLICATION.KT                                              */
/* Copyright (c), 2025 CSoftZ                                                 */
/*----------------------------------------------------------------------------*/
/*-----------------------------------------------------------------------------
 History
 Jan.10/2025  COQ  File created.
 -----------------------------------------------------------------------------*/
package com.csoftz.multi.sb.starter

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

/**
 * Entry point for running the application.
 *
 * @author COQ - Carlos Adolfo Ortiz Q.
 */
@SpringBootApplication
class Application

/**
 * Running application definition entry point.
 *
 * @param args Includes the command line parameters for the application.
 */
fun main(args: Array<String>) {
    runApplication<Application>(*args)
}
