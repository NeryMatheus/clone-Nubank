package com.nubank.nuclone.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.nubank.nuclone.databinding.ProdutoItemBinding
import com.nubank.nuclone.model.Produto

class AdapterProduto(private val context: Context, private val listaProduto: MutableList<Produto>):
    RecyclerView.Adapter<AdapterProduto.ProdutoViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProdutoViewHolder {
        val itemLista = ProdutoItemBinding.inflate(LayoutInflater.from(context), parent, false)
        return ProdutoViewHolder(itemLista)
    }

    override fun getItemCount() = listaProduto.size

    override fun onBindViewHolder(holder: ProdutoViewHolder, position: Int) {
        holder.txtTextoInformativo.text = listaProduto[position].texto
    }

    inner class ProdutoViewHolder(binding: ProdutoItemBinding): RecyclerView.ViewHolder(binding.root) {
        val txtTextoInformativo = binding.txtTextoInformativo
    }
}