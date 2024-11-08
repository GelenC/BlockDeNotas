package com.example.blockdenotas.Model

import android.content.Context
import androidx.lifecycle.ViewModel
import org.json.JSONArray
import org.json.JSONObject
import java.io.File
import java.io.FileWriter

class GuardarNota : ViewModel() {
    private val NombreArchivo = "NotasMemoria.json"

    fun guardarNota(titulo: String, nota: String, context: Context) {
        val nuevaNota = JSONObject().apply {
            put("titulo", titulo)
            put("nota", nota)  // Cambia "contenido" a "nota"
        }
        guardarArchivoJSON(nuevaNota, context)
    }

    fun guardarArchivoJSON(nuevaNota: JSONObject, context: Context) {
        val archivo = File(context.filesDir, NombreArchivo)

        // Variable para almacenar el JSON Array
        val arrayJson = if (archivo.exists()) {
            // Si el archivo existe, lo leemos y lo convertimos en JSONArray
            val archivoTemp = archivo.readText()
            JSONArray(archivoTemp)
        } else {
            // Si no existe, creamos un JSONArray vacío
            JSONArray()
        }

        // Agregamos la nueva nota al array
        arrayJson.put(nuevaNota)

        // Escribimos el array actualizado en el archivo
        FileWriter(archivo).use { escribir ->
            escribir.write(arrayJson.toString())
        }
    }
}