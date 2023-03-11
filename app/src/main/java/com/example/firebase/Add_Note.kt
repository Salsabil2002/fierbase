package com.example.firebase

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

class Add_Note : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_note)
        var titleName = findViewById<EditText>(R.id.titelInput)
        var titleDetiels =findViewById<EditText>(R.id.titelDetials)
       // var countCha =findViewById<EditText>(R.id.countNumber)
        var  btnSave=findViewById<Button>(R.id.savenote)


        btnSave.setOnClickListener {
            val n = titleName.text.toString()
            Log.d("nn",n)
            val db = Firebase.firestore
            val note = hashMapOf(
                "name" to titleName.text.toString(),
                "countchar" to countCha.text.toString().toInt(),
                "details" to titleDetiels.text.toString(),

            )
            db.collection("users")
                .add(note)
                .addOnSuccessListener { documentReference ->
                    Log.d("TAG", "DocumentSnapshot added with ID: ${documentReference.id}")
                }
                .addOnFailureListener { e ->
                    Log.w("TAG", "Error adding document", e)
                }
finish()
        }

//
//// Add a new document with a generated ID
//        btnSave.setOnClickListener {
//            db.collection("users")
//                .add(note)
//                .addOnSuccessListener { documentReference ->
//                    Log.d("TAG", "DocumentSnapshot added with ID: ${documentReference.id}")
//                }
//                .addOnFailureListener { e ->
//                    Log.w("TAG", "Error adding document", e)
//                }
//        }

    }
}