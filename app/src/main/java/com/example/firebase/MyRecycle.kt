package com.example.firebase

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

class MyRecycle (val context: Context, val list: ArrayList<item_Note>): RecyclerView.Adapter<MyRecycle.viewHolder>() {

    val db = Firebase.firestore
    class  viewHolder(item : View): RecyclerView.ViewHolder(item){

        var nameNote = item.findViewById<TextView>(R.id.output)
        var details = item.findViewById<TextView>(R.id.detialsoutput)
        var countNumbrer = item.findViewById<TextView>(R.id.count)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): viewHolder {
        var  root =  LayoutInflater.from(context).inflate(R.layout.item_note,parent,false)
        return viewHolder(root)
    }

    override fun onBindViewHolder(holder: viewHolder, position: Int) {
        holder.nameNote.text=list[position].name.toString()
        holder.details.text=list[position].details.toString()
       //holder.countNumbrer.text= list[position].countChar.toString()

    }

    override fun getItemCount(): Int {
        return list.size
    }
}