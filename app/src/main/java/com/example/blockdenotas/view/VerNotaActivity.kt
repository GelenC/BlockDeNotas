package com.example.blockdenotas.view

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.blockdenotas.Model.Notas
import com.example.blockdenotas.R
import com.example.blockdenotas.databinding.ActivityVerNotaBinding
import com.example.blockdenotas.databinding.NotaitemActivityBinding
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.io.File

class VerNotaActivity : AppCompatActivity() {
    private lateinit var binding: ActivityVerNotaBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityVerNotaBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val titulo = intent.getStringExtra("titulo")
        val contenido = intent.getStringExtra("contenido")

        binding.tvTituloNota.setText(titulo)

        binding.btnGuardarNota.setOnClickListener {

        }

        binding.tvEscribirNota.setText(contenido)



    }
    fun leerJson(): MutableList<Notas>{
        val archivo = File(filesDir, "NotasMemoria.json")

        val json=archivo.readText()
        val gson = Gson();
        val itemtipo=object : TypeToken<List<Notas>>() {}.type

        //return gson.fromJson(json, itemtipo)
        val listaNotas = gson.fromJson<List<Notas>>(json, itemtipo)

        val listaN=listaNotas.toMutableList()

        return listaN

    }
}