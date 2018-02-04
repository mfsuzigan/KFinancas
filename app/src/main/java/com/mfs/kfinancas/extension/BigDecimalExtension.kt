package com.mfs.kfinancas.extension

import java.math.BigDecimal
import java.text.DecimalFormat
import java.text.NumberFormat
import java.util.Locale

fun BigDecimal.formataParaBrasileiro():String{
    val locale: Locale = Locale.forLanguageTag("pt-Br")
    val numberFormat = DecimalFormat.getCurrencyInstance(locale)
    return numberFormat.format(this).replace("R$", "R$ ")
}