package com.mfs.kfinancas.extension

fun String.limitarEmAte(nroCaracteres:Int):String{

    val primeiroCaractere = 0

    return if (this.length > nroCaracteres){
        "${this.substring(primeiroCaractere, nroCaracteres)}..."
    } else {
        this
    }
}