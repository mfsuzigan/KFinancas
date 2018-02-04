package com.mfs.kfinancas.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import com.mfs.kfinancas.R
import com.mfs.kfinancas.extension.formataParaBrasileiro
import com.mfs.kfinancas.extension.formatarParaBrasileiro
import com.mfs.kfinancas.extension.limitarEmAte
import com.mfs.kfinancas.model.Transacao
import kotlinx.android.synthetic.main.transacao_item.view.*

class ListaTransacoesAdapter(private val transacoes: List<Transacao>,
                             private val contexto: Context) : BaseAdapter() {

    private val limiteCaracteresCategoria = 14

    override fun getView(posicao: Int, view: View?, parent: ViewGroup?): View {
        val viewCriada = LayoutInflater.from(contexto).inflate(R.layout.transacao_item, parent, false)
        val transacao: Transacao = transacoes[posicao]

        adicionaIcone(viewCriada, transacao)
        adicionaCategoria(viewCriada, transacao)
        adicionaValor(viewCriada, transacao)
        adicionaData(viewCriada, transacao)

        return viewCriada
    }

    private fun adicionaIcone(viewCriada: View, transacao: Transacao) {
        viewCriada.transacao_icone.setBackgroundResource(transacao.tipo.icone)
    }

    private fun adicionaData(viewCriada: View, transacao: Transacao) {
        viewCriada.transacao_data.text = transacao.data.formatarParaBrasileiro()
    }

    private fun adicionaValor(viewCriada: View, transacao: Transacao) {
        viewCriada.transacao_valor.text = transacao.valor.formataParaBrasileiro()
        viewCriada.transacao_valor.setTextColor(transacao.tipo.cor)
    }

    private fun adicionaCategoria(viewCriada: View, transacao: Transacao) {
        viewCriada.transacao_categoria.text = transacao.categoria.limitarEmAte(limiteCaracteresCategoria)
    }

    override fun getItem(posicao: Int): Transacao {
        return transacoes[posicao]
    }

    override fun getItemId(p0: Int): Long {
        return 0
    }

    override fun getCount(): Int {
        return transacoes.size
    }

}