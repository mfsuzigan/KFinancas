package com.mfs.kfinancas.ui.activity

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.mfs.kfinancas.R
import com.mfs.kfinancas.model.Transacao
import com.mfs.kfinancas.model.enum.TipoTransacao
import com.mfs.kfinancas.ui.adapter.ListaTransacoesAdapter
import kotlinx.android.synthetic.main.activity_lista_transacoes.*
import java.math.BigDecimal

class ListaTransacoesActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lista_transacoes)
        lista_transacoes_listview.adapter = ListaTransacoesAdapter(obterTransacoesExemplo(), this)
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