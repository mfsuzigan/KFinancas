package com.mfs.kfinancas.ui.view

import android.view.View
import com.mfs.kfinancas.extension.formataParaBrasileiro
import com.mfs.kfinancas.model.Resumo
import com.mfs.kfinancas.model.Transacao
import kotlinx.android.synthetic.main.resumo_card.view.*

class ResumoView(private val view:View, transacoes:List<Transacao>) {

    private val resumo = Resumo(transacoes)

    fun configurar(){
        view.resumo_card_receita.text = resumo.receita.formataParaBrasileiro()
        view.resumo_card_despesa.text = resumo.despesa.formataParaBrasileiro()
        view.resumo_card_total.text = resumo.total.formataParaBrasileiro()
    }
}

