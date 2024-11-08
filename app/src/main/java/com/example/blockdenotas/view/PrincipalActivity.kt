package com.example.blockdenotas.view

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.LinearLayout
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.interaction.DragInteraction
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.blockdenotas.Model.AdapterRecyclerView
import com.example.blockdenotas.Model.Notas
import com.example.blockdenotas.databinding.ActivityAgregarNotaBinding
import com.example.blockdenotas.databinding.ActivityPrincipalBinding
import com.example.blockdenotas.databinding.NotaitemActivityBinding
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import org.json.JSONArray
import java.io.File

class PrincipalActivity : AppCompatActivity() {
    private lateinit var binding: ActivityPrincipalBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding=ActivityPrincipalBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnAgregarNota.setOnClickListener {
            startActivity(Intent(this, AgregarNotaActivity::class.java))
        }
        VerNotas()
    }
    fun VerNotas(){
        val listaN = leerJson()
        binding.recyclerViewNotas.layoutManager = LinearLayoutManager(this)
        binding.recyclerViewNotas.adapter=AdapterRecyclerView(listaN)

    }
    fun leerJson():List<Notas>{
        val archivo = File(filesDir, "NotasMemoria.json")
        if(!archivo.exists()) return emptyList()

        val json=archivo.readText()
        val gson = Gson();
        val itemtipo=object : TypeToken<List<Notas>>() {}.type

         //return gson.fromJson(json, itemtipo)
        val listaNotas = gson.fromJson<List<Notas>>(json, itemtipo)

        // Log para verificar el contenido de cada nota
        listaNotas.forEach { nota ->
            Log.d("leerJson", "Nota leída - Título: ${nota.titulo}, Contenido: ${nota.nota}")
        }

        return listaNotas

    }
}