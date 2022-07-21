package com.afam.mateapp

import java.io.Serializable

/**
 * Creamos un data class <> y le enviamos los parametros del modelo.
 */

data class MatOption(val name: String, val img: String, val color: String,val operation:Int): Serializable {}