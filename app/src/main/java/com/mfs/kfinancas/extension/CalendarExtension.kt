package com.mfs.kfinancas.extension

import java.text.SimpleDateFormat
import java.util.*

fun Calendar.formatarParaBrasileiro():String {
    return SimpleDateFormat("dd/MM/yyyy").format(this.time)
}
