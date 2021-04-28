package com.example.EvalGrupalMod4

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import com.squareup.picasso.Picasso


class Detalle1 : AppCompatActivity() {

    lateinit var imagen : ImageView
    lateinit var titulo : TextView
    lateinit var texto : TextView
    lateinit var et_coment : EditText
    lateinit var btn_guardar : Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detalle1)

        fun ImageView.loadUrl(url: String) {
            Picasso.with(context).load(url).into(imagen)
        }

        imagen = findViewById(R.id.image1) as ImageView
        titulo = findViewById(R.id.tv1) as TextView
        texto = findViewById(R.id.tv_descripcion) as TextView
        et_coment = findViewById(R.id.et_coment) as EditText
        btn_guardar = findViewById(R.id.btn_guardar) as Button
        var tv_comentarios = findViewById(R.id.tv_comentarios) as TextView

        imagen.loadUrl(resources.getString(R.string.el_universo_elegante))
        titulo.setText(resources.getString(R.string.label1))
        texto.setText(resources.getString(R.string.descr1))

        //Aqui se guarda nuestro comentario
        tv_comentarios.text = SharedApp.prefs.detalle1

        btn_guardar.setOnClickListener(){
            SharedApp.prefs.detalle1 = et_coment.text.toString()
            tv_comentarios.text = SharedApp.prefs.detalle1
            et_coment.setText("")

            if (tv_comentarios.text.isNotEmpty()){
                btn_guardar!!.isEnabled = false
            }
        }
    }
}