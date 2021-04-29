package com.example.EvalGrupalMod4

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.method.ScrollingMovementMethod
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import com.squareup.picasso.Picasso

class Detalle3 : AppCompatActivity() {

    lateinit var imagen : ImageView
    lateinit var titulo : TextView
    lateinit var texto : TextView
    lateinit var et_coment : EditText
    lateinit var btn_guardar : Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detalle3)

        fun ImageView.loadUrl(url: String) {
            Picasso.with(context).load(url).into(imagen)
        }

        imagen = findViewById(R.id.image3) as ImageView
        titulo = findViewById(R.id.tv3) as TextView
        texto = findViewById(R.id.tv_descripcion3) as TextView
        et_coment = findViewById(R.id.et_coment3) as EditText
        btn_guardar = findViewById(R.id.btn_guardar3) as Button
        var tv_comentarios = findViewById(R.id.tv_comentarios3) as TextView
        texto.setMovementMethod(ScrollingMovementMethod())

        imagen.loadUrl(resources.getString(R.string.la_particula_divina))
        titulo.setText(resources.getString(R.string.label3))

        //Aqui se guarda nuestro comentario
        tv_comentarios.text = SharedApp.prefs.detalle3

        btn_guardar.setOnClickListener(){
            SharedApp.prefs.detalle3 = et_coment.text.toString()
            tv_comentarios.text = SharedApp.prefs.detalle3
            et_coment.setText("")

            if (tv_comentarios.text.isNotEmpty()){
                btn_guardar!!.isEnabled = false
            }
        }
    }
}