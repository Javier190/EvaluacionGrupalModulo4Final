package com.example.EvalGrupalMod4

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    lateinit var mRecyclerView: RecyclerView
    val mAdapter: RecyclerAdapter = RecyclerAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setUpRecyclerView()
    }

    fun setUpRecyclerView() {
        mRecyclerView = findViewById(R.id.recyclerview_prod) as RecyclerView
        mRecyclerView.setHasFixedSize(true)
        mRecyclerView.layoutManager = LinearLayoutManager(this)
        mAdapter.RecyclerAdapter(getlibros(), this)  //recuerda que el adapter del recycler pide 2 parametros, contexto y la lista
        mRecyclerView.adapter = mAdapter  //Este es como el metodo mRecyclerView.setadapter(madapter) de JAVA
    }

    fun getlibros(): MutableList<Libro> {
        var libros: MutableList<Libro> = ArrayList()
        libros.add(Libro(resources.getString(R.string.el_universo_elegante), resources.getString(R.string.label1)))
        libros.add((Libro(resources.getString(R.string.el_tejido_cosmos), resources.getString(R.string.label2))))
        libros.add(Libro(resources.getString(R.string.la_particula_divina), resources.getString(R.string.label3)))
        libros.add(Libro(resources.getString(R.string.agujeros_negros_netgeo), resources.getString(R.string.label4)))
        libros.add(Libro(resources.getString(R.string.el_universo_elegante), resources.getString(R.string.label1)))
        libros.add(Libro(resources.getString(R.string.el_tejido_cosmos), resources.getString(R.string.label2)))
        libros.add(Libro(resources.getString(R.string.la_particula_divina), resources.getString(R.string.label3)))
        libros.add(Libro(resources.getString(R.string.agujeros_negros_netgeo), resources.getString(R.string.label4)))
        return libros
    }
}