package com.example.eventbusproject.Adapter

import android.app.Activity
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.eventbus.Bus.EventBus
import com.example.eventbusproject.Messages.CustomMessage
import com.example.eventbusproject.R


class NamesAdapter ( var dataSet : ArrayList<String>)  :
    RecyclerView.Adapter<NamesAdapter.ViewHolder>() {



    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val name: TextView
        val deleteBtn: TextView

        init {
            name = view.findViewById(R.id.nameTv)
            deleteBtn = view.findViewById(R.id.deletebtn)

        }
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.name_layout, viewGroup, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        viewHolder.name.text = dataSet[position]
        var name = dataSet[position]

        viewHolder.deleteBtn.setOnClickListener {
            dataSet.removeAt(position)
            deleteSet.add(name)
            this.notifyDataSetChanged()
        }
    }

    override fun getItemCount() = dataSet.size

    companion object{
        private var deleteSet = ArrayList<String>()
        fun arrayToDelete () : ArrayList<String>{
            return  deleteSet
        }
    }


}


