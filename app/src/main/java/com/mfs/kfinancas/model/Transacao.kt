package com.mfs.kfinancas.model

import com.mfs.kfinancas.model.enum.TipoTransacao
import java.math.BigDecimal
import java.util.*

class Transacao(val valor: BigDecimal,
                val categoria: String = "Indefinida",
                val tipo: TipoTransacao,
                val data: Calendar = Calendar.getInstance()) {

    constructor(valor: BigDecimal, tipo: TipoTransacao) : this(valor, "Indefinida", tipo)


}