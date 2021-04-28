package com.example.EvalGrupalMod4

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import com.squareup.picasso.Picasso

class Detalle2 : AppCompatActivity() {

    lateinit var imagen : ImageView
    lateinit var titulo : TextView
    lateinit var texto : TextView
    lateinit var et_coment : EditText
    lateinit var btn_guardar : Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detalle2)

        fun ImageView.loadUrl(url: String) {
            Picasso.with(context).load(url).into(imagen)
        }

        imagen = findViewById(R.id.image2) as ImageView
        titulo = findViewById(R.id.tv2) as TextView
        texto = findViewById(R.id.tv_descripcion2) as TextView
        et_coment = findViewById(R.id.et_coment2) as EditText
        btn_guardar = findViewById(R.id.btn_guardar2) as Button
        var tv_comentarios = findViewById(R.id.tv_comentarios2) as TextView

        imagen.loadUrl(resources.getString(R.string.el_tejido_cosmos))
        titulo.setText(resources.getString(R.string.label1))
        texto.setText(resources.getString(R.string.descr1))

        //Aqui se guarda nuestro comentario
        tv_comentarios.text = SharedApp.prefs.detalle2

        btn_guardar.setOnClickListener(){
            SharedApp.prefs.detalle2 = et_coment.text.toString()
            tv_comentarios.text = SharedApp.prefs.detalle2
            et_coment.setText("")

            if (tv_comentarios.text.isNotEmpty()){
                btn_guardar!!.isEnabled = false
            }
        }
    }
}