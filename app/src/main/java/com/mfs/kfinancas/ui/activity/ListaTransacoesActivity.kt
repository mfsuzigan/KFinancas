package com.mfs.kfinancas.ui.activity

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.mfs.kfinancas.R
import com.mfs.kfinancas.extension.formataParaBrasileiro
import com.mfs.kfinancas.model.Transacao
import com.mfs.kfinancas.model.enum.TipoTransacao
import com.mfs.kfinancas.ui.adapter.ListaTransacoesAdapter
import com.mfs.kfinancas.ui.view.ResumoView
import kotlinx.android.synthetic.main.activity_lista_transacoes.*
import kotlinx.android.synthetic.main.resumo_card.*
import java.math.BigDecimal

class ListaTransacoesActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lista_transacoes)
        val transacoes = obterTransacoesExemplo()

        configurarTotalizadores(transacoes)
        configurarLista(transacoes)

    }

    private fun configurarLista(transacoes: List<Transacao>) {
        lista_transacoes_listview.adapter = ListaTransacoesAdapter(transacoes, this)
    }

    private fun configurarTotalizadores(transacoes:List<Transacao>){
        ResumoView(window.decorView, transacoes).configurar()
    }

    private fun obterTransacoesExemplo(): List<Transacao> {
        return listOf(
                Transacao(BigDecimal(40000),
                        "Supermercado",
                        TipoTransacao.DESPESA),
                Transacao(tipo = TipoTransacao.RECEITA,
                        valor = BigDecimal(45),
                        categoria = "Economia de grande vulto"))
    }
}