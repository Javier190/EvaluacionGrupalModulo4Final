package com.example.EvalGrupalMod4

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast

import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso

class RecyclerAdapter : RecyclerView.Adapter<RecyclerAdapter.ViewHolder>() {

    var libros: MutableList<Libro>  = ArrayList()
    lateinit var context: Context

    //Constructor
    fun RecyclerAdapter(libros : MutableList<Libro>, context: Context){
        this.libros = libros
        this.context = context
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = libros.get(position)
        holder.bind(item, context)
    }

    //Metodo que devuelve un objeto ViewHolder al cual le pasamos la celda que hemos creado.
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return ViewHolder(layoutInflater.inflate(R.layout.product_list, parent, false))
    }

    override fun getItemCount(): Int {
        return libros.size
    }
    //Viewholder es como la clase encargada de las vistas de los items. y esta clase va a entregar info al adapter

    //Lo que hace esta clase es hacer referencia a los items de la celda, el view.findViewByID()
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val nombre_libro = view.findViewById(R.id.tv_libro) as TextView
        val imagen_libro = view.findViewById(R.id.imageview_libro) as ImageView

        //aqui se une la data class, que es la estructura de cada Item, con los textviews e imagen(el front)
        fun bind(libro:Libro, context: Context){
            nombre_libro.text = libro.title
           imagen_libro.loadUrl(libro.image)
            itemView.setOnClickListener(View.OnClickListener {
                //Toast.makeText(context, libro.title, Toast.LENGTH_SHORT).show()
                //Toast.makeText(context, adapterPosition.toString(), Toast.LENGTH_SHORT).show() //adapterpost me indica la posicion del indice
                when {
                    adapterPosition == 0  -> {Toast.makeText(context, libro.title, Toast.LENGTH_SHORT).show()
                        val intent = Intent(context,Detalle1::class.java)
                        context.startActivity(intent)
                    }
                    adapterPosition == 1  -> {Toast.makeText(context, libro.title, Toast.LENGTH_SHORT).show()
                        val intent = Intent(context,Detalle2::class.java)
                        context.startActivity(intent)
                    }
                    adapterPosition == 2  -> {Toast.makeText(context, libro.title, Toast.LENGTH_SHORT).show()
                        val intent = Intent(context,Detalle3::class.java)
                        context.startActivity(intent)
                    }
                }
                 })
        }
        fun ImageView.loadUrl(url: String) {
           Picasso.with(context).load(url).into(this)
        }
    }

}