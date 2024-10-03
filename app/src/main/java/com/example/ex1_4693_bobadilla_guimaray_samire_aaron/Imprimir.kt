package com.example.ex1_4693_bobadilla_guimaray_samire_aaron

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.ex1_4693_bobadilla_guimaray_samire_aaron.databinding.ActivityImprimirBinding

class Imprimir : AppCompatActivity() {

    private lateinit var binding: ActivityImprimirBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityImprimirBinding.inflate(layoutInflater)

        enableEdgeToEdge()
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val nombre = intent.getStringExtra("nombre") ?: "No hay data"
        val dni = intent.getStringExtra("dni") ?: "No hay data"
        val servicio = intent.getStringExtra("servicio") ?: "No hay servicio seleccionado"
        val costoServicio = intent.getStringExtra("costoServicio") ?: "0.00"
        val costoInstalacion = intent.getStringExtra("costoInstalacion") ?: "0.00"
        val descuento = intent.getStringExtra("descuento") ?: "0.00"
        val total = intent.getStringExtra("total") ?: "0.00"



        binding.rsNombre.text = "Nombre del Cliente: $nombre"
        binding.rsDni.text = "DNI: $dni"
        binding.rsServicio.text = "Servicio: $servicio"
        binding.rsCosto.text = "Costo de Servicio: $costoServicio"
        binding.rsInstalacion.text = "Costo de Instalación: $costoInstalacion"
        binding.rsDescuento.text = "Descuento: $descuento"
        binding.rsTotal.text = "Total a Pagar: $total"

    }
}