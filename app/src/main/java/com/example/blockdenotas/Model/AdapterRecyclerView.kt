package com.example.blockdenotas.Model

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.blockdenotas.databinding.ActivityAgregarNotaBinding
import com.example.blockdenotas.databinding.NotaitemActivityBinding
import com.example.blockdenotas.view.PrincipalActivity
import com.example.blockdenotas.view.VerNotaActivity

class AdapterRecyclerView(val listaNotas: List<Notas>): RecyclerView.Adapter<AdapterRecyclerView.viewHolder>() {
    class viewHolder(val binding: NotaitemActivityBinding): RecyclerView.ViewHolder(binding.root){
        fun bind(nota:Notas){
            binding.tvTituloitem.text=nota.titulo
            binding.tvContenidoitem.text=nota.nota

            binding.LayoutNotaBoton.setOnClickListener {
                val context = itemView.context
                val intent=Intent(context, VerNotaActivity::class.java)

                intent.putExtra("titulo", nota.titulo)
                intent.putExtra("contenido", nota.nota)
                context.startActivity(intent)
            }
        }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AdapterRecyclerView.viewHolder {
        val binding = NotaitemActivityBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return viewHolder(binding)
    }

    override fun onBindViewHolder(holder: AdapterRecyclerView.viewHolder, position: Int) {
        holder.bind(listaNotas[position])
    }

    override fun getItemCount()=listaNotas.size

}