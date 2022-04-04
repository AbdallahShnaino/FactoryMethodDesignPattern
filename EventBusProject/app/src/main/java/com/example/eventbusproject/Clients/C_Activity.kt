package com.example.eventbusproject.Clients

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.eventbus.Bus.EventBus
import com.example.eventbusproject.Adapter.NamesAdapter
import com.example.eventbusproject.Messages.CustomMessage
import com.example.eventbusproject.R
import java.util.ArrayList

class C_Activity : AppCompatActivity() ,  EventBus.Subscriber{
    var names = ArrayList<String>()

    override fun receiveMessage(message: EventBus.BusMessage) {

        if (message is CustomMessage) {
            val fullClassName: String = message.getMessageSender().javaClass.name
            val simpleClassName = fullClassName.substring(fullClassName.lastIndexOf('.') + 1)
            Log.d("messagesSendingThrowBus" , message.getNameToDelete() +" From  "+simpleClassName)
            names.remove(message.getNameToDelete() )
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cactivity)
        var tv = findViewById<View>(R.id.c_recycler) as RecyclerView
        var adapter = NamesAdapter(names)
        tv.adapter = adapter
        tv.layoutManager = LinearLayoutManager(this)

        var bus = EventBus.getBusInstance()
        bus.setSubscribers(this)

        names.add("1111")
        names.add("2222")
        names.add("3333")


        var delete = NamesAdapter.arrayToDelete()
        for ( i in delete) {
            var message = CustomMessage()
            message.setMessageSender(this)
            message.setNameToDelete(i)
            sendToOther(message)
        }


    }

    fun sendToOther ( message : CustomMessage) {
        EventBus.getBusInstance().publish(message)
    }
}