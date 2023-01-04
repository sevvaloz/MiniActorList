package com.example.miniactorlist

import android.content.Context
import android.text.Layout
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.recyclerview_row.*
import java.security.AccessController.getContext
import kotlin.random.Random

class ActorAdapter(val actorList: ArrayList<Actor>, val context: Context): RecyclerView.Adapter<ActorAdapter.ActorViewHolder>() {

   class ActorViewHolder(itemview: View): RecyclerView.ViewHolder(itemview) {

       var txtName: TextView? = null
       var txtFilm: TextView? = null
       var imgActor: ImageView? = null
       var btnDelete: ImageView? = null

       init {
           txtName = itemview.findViewById(R.id.txtName)
           txtFilm = itemview.findViewById(R.id.txtFilm)
           imgActor = itemview.findViewById(R.id.imgActor)
           btnDelete = itemview.findViewById(R.id.btnDelete)
       }
   }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ActorViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.recyclerview_row, parent, false)
        return ActorViewHolder(view)
    }

    override fun onBindViewHolder(holder: ActorViewHolder, position: Int) {
        val current: Actor = actorList[position]
        holder.txtName?.text = current.name
        holder.txtFilm?.text = current.film
        holder.imgActor?.setOnClickListener{
            Toast.makeText(context, "Yaş: ${current.age}", Toast.LENGTH_LONG).show()
        }
        holder.imgActor?.let {
            Glide.with(context)
                    .load(current.image)
                    .circleCrop()
                    .into(it)
        }
        holder.btnDelete?.setOnClickListener {
            deleteActor(current)
        }
    }

    override fun getItemCount(): Int {
        return actorList.size
    }


    //add actor function
    fun addActor(a: Actor){
        actorList.add(a)
        notifyItemInserted(actorList.size)
    }

    //delete actor function
    fun deleteActor(a: Actor){
        val pos = actorList.indexOf(a)
        actorList.removeAt(pos)
        notifyItemRemoved(pos)
    }

}

