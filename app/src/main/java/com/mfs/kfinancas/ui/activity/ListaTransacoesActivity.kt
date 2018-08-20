package com.mfs.kfinancas.ui.activity

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.mfs.kfinancas.R
import com.mfs.kfinancas.extension.formataParaBrasileiro
import com.mfs.kfinancas.model.Transacao
import com.mfs.kfinancas.model.enum.TipoTransacao
import com.mfs.kfinancas.ui.adapter.ListaTransacoesAdapter
import kotlinx.android.synthetic.main.activity_lista_transacoes.*
import kotlinx.android.synthetic.main.resumo_card.*
import java.math.BigDecimal

class ListaTransacoesActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lista_transacoes)
        val transacoes = obterTransacoesExemplo()
        configurarTotalizadores(transacoes)

        lista_transacoes_listview.adapter = ListaTransacoesAdapter(transacoes, this)

    }

    private fun configurarTotalizadores(transacoes:List<Transacao>){
        val totalReceitas = Transacao.somarPorTipo(transacoes, TipoTransacao.RECEITA)
        resumo_card_receita.text = totalReceitas.formataParaBrasileiro()

        val totalDespesas = Transacao.somarPorTipo(transacoes, TipoTransacao.DESPESA)
        resumo_card_despesa.text = totalDespesas.formataParaBrasileiro()

        resumo_card_total.text = totalDespesas.add(totalReceitas).formataParaBrasileiro()

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