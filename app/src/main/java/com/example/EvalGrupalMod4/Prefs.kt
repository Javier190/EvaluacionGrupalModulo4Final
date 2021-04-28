package com.example.EvalGrupalMod4

import android.content.Context
import android.content.SharedPreferences

class Prefs(context: Context) {
    val PREFS_NAME = "com.example.proyectoxmod4" //Aqui es donde se guardan las preferencias
    val SHARED_NAME = "shared_name" //Esta es la clave de la preferencia
    val SHARED_NAME2 = "shared_name2"
    val SHARED_NAME3 = "shared_name3"

    val prefs:SharedPreferences = context.getSharedPreferences(PREFS_NAME,0)

    var detalle1:String?
        get() = prefs.getString(SHARED_NAME,"")
        set(value) = prefs.edit().putString(SHARED_NAME,value).apply()

    var detalle2:String?
        get() = prefs.getString(SHARED_NAME2,"")
        set(value) = prefs.edit().putString(SHARED_NAME2,value).apply()

    var detalle3:String?
        get() = prefs.getString(SHARED_NAME3,"")
        set(value) = prefs.edit().putString(SHARED_NAME3,value).apply()

}