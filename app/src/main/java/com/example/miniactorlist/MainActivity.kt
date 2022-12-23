package com.example.miniactorlist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.ImageView
import android.widget.Toast
import androidx.constraintlayout.widget.Placeholder
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.miniactorlist.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.recyclerview_row.*
import java.text.FieldPosition

class MainActivity : AppCompatActivity() {

    //lateinit var list: ArrayList<Actor>
    lateinit var new: Actor

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //recyclerview
        val rv: RecyclerView = findViewById(R.id.rv)

        val actor1 = Actor("Leonardo DiCaprio", "Titanik", 48, "https://icdn.ensonhaber.com/resimler/galeri/00_1784.jpg")
        val actor2 = Actor("Benedict Cumberbatch", "Sherlock", 46, "https://media-cldnry.s-nbcnews.com/image/upload/rockcms/2022-03/220307-benedict-cumberbatch-jm-1047-880c59.jpg")
        val actor3 = Actor("Jonny Deep", "Karayip Korsanlari", 59, "https://i.hbrcdn.com/haber/2020/11/02/johnny-depp-kimdir-johnny-depp-kac-yasinda-13708909_3358_amp.jpg")
        val actor4 = Actor("Leonardo DiCaprio", "Titanik", 48, "https://icdn.ensonhaber.com/resimler/galeri/00_1784.jpg")
        val actor5 = Actor("Benedict Cumberbatch", "Sherlock", 46, "https://media-cldnry.s-nbcnews.com/image/upload/rockcms/2022-03/220307-benedict-cumberbatch-jm-1047-880c59.jpg")
        val actor6 = Actor("Jonny Deep", "Karayip Korsanlari", 59, "https://i.hbrcdn.com/haber/2020/11/02/johnny-depp-kimdir-johnny-depp-kac-yasinda-13708909_3358_amp.jpg")
        val actorList = arrayListOf<Actor>(actor1, actor2, actor3, actor4, actor5, actor6)


        val adapter: ActorAdapter = ActorAdapter(arrayListOf(actor1, actor2, actor3, actor4, actor5), this)

        rv.adapter = adapter
        rv.layoutManager = LinearLayoutManager(this)

        //buttons
        btn_add_actor.setOnClickListener {
            val random = (0..5).random()
            new = actorList[random]
            adapter.addActor(new)
        }

        btn_delete_actor.setOnClickListener {
            adapter.deleteActor()
        }




    }





}