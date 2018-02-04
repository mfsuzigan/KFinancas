package com.mfs.kfinancas.model.enum

import com.mfs.kfinancas.R

enum class TipoTransacao(val cor: Int, val icone: Int) {
    RECEITA(R.color.receita, R.drawable.icone_transacao_item_receita),
    DESPESA(R.color.despesa, R.drawable.icone_transacao_item_despesa)
}