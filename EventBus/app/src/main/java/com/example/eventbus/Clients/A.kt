package com.example.eventbus.Clients

import android.util.Log
import com.example.eventbus.Bus.EventBus

class A : EventBus.Subscriber {
    fun sendToOther ( message : EventBus.BusMessage) {
        EventBus.getBusInstance().publish(message)
    }
    override fun receiveMessage(message: EventBus.BusMessage) {
        Log.d("messagesSendingThrowBus" , message.getMessageSender().toString() )
    }
}