package com.nubank.nuclone

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import androidx.recyclerview.widget.LinearLayoutManager
import com.nubank.nuclone.adapter.AdapterPagamento
import com.nubank.nuclone.adapter.AdapterProduto
import com.nubank.nuclone.databinding.ActivityMainBinding
import com.nubank.nuclone.model.Pagamento
import com.nubank.nuclone.model.Produto

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var adapterPagamento: AdapterPagamento
    private lateinit var adapterProduto: AdapterProduto
    private val listaPagamento: MutableList<Pagamento> = mutableListOf()
    private val listaProduto: MutableList<Produto> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar!!.hide()

        val recyclerIconesPagamento = binding.recyclerIconesPagamento
        recyclerIconesPagamento?.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        recyclerIconesPagamento?.setHasFixedSize(true)
        adapterPagamento = AdapterPagamento(this, listaPagamento)
        recyclerIconesPagamento?.adapter = adapterPagamento
        listaIconesPagamento()

        val recyclerProduto = binding.recylcerProdutos
        recyclerProduto?.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        recyclerProduto?.setHasFixedSize(true)
        adapterProduto = AdapterProduto(this, listaProduto)
        recyclerProduto?.adapter = adapterProduto
        listaTextoInformativo()
    }

    private fun listaIconesPagamento() {
        val iconPix = Pagamento(R.drawable.ic_pix, "Área Pix")
        listaPagamento.add(iconPix)

        val iconPagar = Pagamento(R.drawable.barcode, "Pagar")
        listaPagamento.add(iconPagar)

        val iconEmprestimo = Pagamento(R.drawable.emprestimo, "Pegar \n Emprestado")
        listaPagamento.add(iconEmprestimo)

        val iconTranferir = Pagamento(R.drawable.transferencia, "Tranferir")
        listaPagamento.add(iconTranferir)

        val iconDepositar = Pagamento(R.drawable.depositar, "Depositar")
        listaPagamento.add(iconDepositar)

        val iconRecargar = Pagamento(R.drawable.ic_recarga_celular, "Recarga \nCelular")
        listaPagamento.add(iconRecargar)

        val iconCobrar = Pagamento(R.drawable.ic_cobrar, "Cobrar")
        listaPagamento.add(iconCobrar)

        val iconDoacao = Pagamento(R.drawable.doacao, "Doação")
        listaPagamento.add(iconDoacao)
    }

    private fun listaTextoInformativo() {
        val textoInformativo1 = Produto("Concorra a prêmios com o Nubank Vida a partir de R$4/mês. Saiba ...")
        listaProduto.add(textoInformativo1)

        val textoInformativo2 = Produto("Convide seus amigos para o Nubank e desbloqueie brasões incríveis.")
        listaProduto.add(textoInformativo2)
    }
}