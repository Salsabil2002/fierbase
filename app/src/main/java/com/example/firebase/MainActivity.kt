package com.example.firebase

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val a = ArrayList<item_Note>()

        val db = Firebase.firestore
        val btnAdd = findViewById<Button>(R.id.addnewnote)
        val userList = findViewById<RecyclerView>(R.id.recyclerview)

        btnAdd.setOnClickListener {
            val intent = Intent(this, Add_Note ::class.java)
            startActivity(intent)
        }
        val adapter = MyRecycle(this,a)
        userList.layoutManager= LinearLayoutManager(this)
        userList.adapter=adapter



        db.collection("us")
            .get()
            .addOnSuccessListener { result ->
                for (document in result) {
                    val nameNote = document.data.get("name").toString()
                    val c = document.data.get("countchar").toString().toInt()
                    val detailsNote = document.data.get("details").toString()
                    a.add(item_Note(nameNote,c, detailsNote))


                    adapter.notifyDataSetChanged()

                    Log.d("TAG", "${document.id} => ${document.data}")
                }
            }
            .addOnFailureListener { exception ->
                Log.w("TAG", "Error getting documents.", exception)
            }


    }
}