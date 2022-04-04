package com.example.eventbus.Clients

import android.util.Log
import com.example.eventbus.Bus.EventBus
import com.example.eventbusproject.Messages.CustomMessage

class A : EventBus.Subscriber {
    fun sendToOther ( message : CustomMessage) {
        EventBus.getBusInstance().publish(message)
    }
    override fun receiveMessage(message: EventBus.BusMessage) {
        if (message is CustomMessage) {


            val fullClassName: String = message.getMessageSender().javaClass.name
            val simpleClassName = fullClassName.substring(fullClassName.lastIndexOf('.') + 1)


     //       Log.d("messagesSendingThrowBus" , message.namesToDelete.size.toString() +" From  "+simpleClassName)
        }
    }
}