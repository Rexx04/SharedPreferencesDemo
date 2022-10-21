package com.trinity.sharedpreferencesdemo

import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText

class MainActivity : AppCompatActivity() {

    private lateinit var nombre: EditText
    private lateinit var edad: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        nombre = findViewById(R.id.etNombre)
        edad = findViewById(R.id.etEdad)
    }

    override fun onResume() {
        super.onResume()

        var sh: SharedPreferences = getSharedPreferences("SharedPreferencesDemo", MODE_PRIVATE)

        var stNombre: String? = sh.getString("nombre", "")
        var inEdad: Int? = sh.getInt("edad",0)

        nombre.setText(stNombre)
        edad.setText(inEdad.toString())
    }

    override fun onPause() {
        super.onPause()

        var sh: SharedPreferences = getSharedPreferences("SharedPreferencesDemo", MODE_PRIVATE)
        var edit: SharedPreferences.Editor = sh.edit()

        edit.putString("nombre",nombre.text.toString())
        edit.putInt("edad",edad.text.toString().toInt())
        edit.apply()
    }
}