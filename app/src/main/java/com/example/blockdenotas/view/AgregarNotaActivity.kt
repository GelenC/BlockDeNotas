package com.example.blockdenotas.view
import androidx.activity.viewModels
import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.blockdenotas.Model.GuardarNota
import com.example.blockdenotas.databinding.ActivityAgregarNotaBinding

class AgregarNotaActivity : AppCompatActivity() {
    private val vm : GuardarNota by viewModels()
    private lateinit var binding: ActivityAgregarNotaBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding=ActivityAgregarNotaBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnGuardarNota.setOnClickListener {
            vm.guardarNota(binding.tvTituloNota.text.toString(), binding.tvEscribirNota.text.toString(), this)
            startActivity(Intent(this, PrincipalActivity::class.java))
        }

    }
}