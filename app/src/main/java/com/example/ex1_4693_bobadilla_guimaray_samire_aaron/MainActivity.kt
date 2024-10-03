package com.example.ex1_4693_bobadilla_guimaray_samire_aaron

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.ex1_4693_bobadilla_guimaray_samire_aaron.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)

        enableEdgeToEdge()
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        binding.btnCalcular.setOnClickListener {
            calcularCosto()
        }

        binding.btnImprimir.setOnClickListener {
            imprimirDatos()
        }

    }

    private fun calcularCosto() {
        val costoServicio: Double
        val costoInstalacion: Double
        val descuentoPorcentaje: Double

        when (binding.rdGroup.checkedRadioButtonId) {
            R.id.rdDuo -> {
                costoServicio = 109.00
                costoInstalacion = 35.00
                descuentoPorcentaje = 0.05
            }
            R.id.rdTrio -> {
                costoServicio = 159.00
                costoInstalacion = 60.00
                descuentoPorcentaje = 0.10
            }
            R.id.rdInternet -> {
                costoServicio = 89.00
                costoInstalacion = 15.00
                descuentoPorcentaje = 0.02
            }
            R.id.rdTelefono -> {
                costoServicio = 59.00
                costoInstalacion = 12.00
                descuentoPorcentaje = 0.01
            }
            R.id.rdCable -> {
                costoServicio = 79.00
                costoInstalacion = 15.00
                descuentoPorcentaje = 0.01
            }
            else -> {
                Toast.makeText(this, "Seleccione un servicio", Toast.LENGTH_SHORT).show()
                return
            }
        }

        val descuento = costoServicio * descuentoPorcentaje
        val total = costoServicio + costoInstalacion - descuento

        binding.etCosto.setText(String.format("%.2f", costoServicio))
        binding.etInstalacion.setText(String.format("%.2f", costoInstalacion))
        binding.etDescuento.setText(String.format("%.2f", descuento))
        binding.etTotal.setText(String.format("%.2f", total))
    }

    private fun imprimirDatos() {
        val nombre = binding.etNombre.text.toString()
        val dni = binding.etDni.text.toString()

        val servicioSeleccionado = when (binding.rdGroup.checkedRadioButtonId) {
            R.id.rdDuo -> "Duo - Teléfono e Internet"
            R.id.rdTrio -> "Trio - Teléfono + TV + Internet"
            R.id.rdInternet -> "Solo Internet"
            R.id.rdTelefono -> "Solo Teléfono"
            R.id.rdCable -> "Solo Cable"
            else -> "No Seleccionado"
        }

        val costoServicio = binding.etCosto.text.toString()
        val costoInstalacion = binding.etInstalacion.text.toString()
        val descuento = binding.etDescuento.text.toString()
        val total = binding.etTotal.text.toString()



        val newView = Intent(this, Imprimir::class.java)
        newView.putExtra("nombre", nombre)
        newView.putExtra("dni", dni)
        newView.putExtra("servicio", servicioSeleccionado)
        newView.putExtra("costoServicio", costoServicio)
        newView.putExtra("costoInstalacion", costoInstalacion)
        newView.putExtra("descuento", descuento)
        newView.putExtra("total", total)

        startActivity(newView)
    }

}