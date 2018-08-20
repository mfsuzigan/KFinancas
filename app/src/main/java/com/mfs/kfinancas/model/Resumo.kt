package com.mfs.kfinancas.model

import com.mfs.kfinancas.model.enum.TipoTransacao
import java.math.BigDecimal


class Resumo(transacoes:List<Transacao>) {

    val receita:BigDecimal = somarPorTipo(transacoes, TipoTransacao.RECEITA)
    val despesa:BigDecimal = somarPorTipo(transacoes, TipoTransacao.DESPESA)
    val total:BigDecimal = receita.subtract(despesa)

    private fun somarPorTipo(transacoes: List<Transacao>, tipo: TipoTransacao): BigDecimal {
        return transacoes
                .filter { tipo == it.tipo }
                .fold(BigDecimal.ZERO, { soma, transacao -> soma.add(transacao.valor) })
    }
}