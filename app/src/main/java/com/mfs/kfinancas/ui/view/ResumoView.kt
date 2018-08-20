package com.mfs.kfinancas.ui.view

import android.content.Context
import android.support.v4.content.ContextCompat
import android.view.View
import com.mfs.kfinancas.R
import com.mfs.kfinancas.extension.formataParaBrasileiro
import com.mfs.kfinancas.model.Resumo
import com.mfs.kfinancas.model.Transacao
import kotlinx.android.synthetic.main.resumo_card.view.*

class ResumoView(private val view:View, context:Context, transacoes:List<Transacao>) {

    private val resumo = Resumo(transacoes)
    private val corReceita = ContextCompat.getColor(context, R.color.receita)
    private val corDespesa = ContextCompat.getColor(context, R.color.despesa)

    fun configurar(){
        view.resumo_card_despesa.text = resumo.despesa.formataParaBrasileiro()
        view.resumo_card_total.text = resumo.total.formataParaBrasileiro()
    }

    private fun configurarReceita(){
        view.resumo_card_receita.text = resumo.receita.formataParaBrasileiro()
        view.resumo_card_receita.setTextColor(corReceita)
    }

    private fun configurarDespesa(){
        view.resumo_card_despesa.text = resumo.despesa.formataParaBrasileiro()
        view.resumo_card_despesa.setTextColor(corDespesa)
    }

    private fun configurarTotal(){
        view.resumo_card_total.text = resumo.total.formataParaBrasileiro()
        view.resumo_card_total.setTextColor(
                        if (resumo.total.signum() > 0) corReceita else corDespesa)
    }
}

