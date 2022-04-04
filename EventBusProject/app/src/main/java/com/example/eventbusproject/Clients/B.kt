package com.example.eventbus.Clients

import android.util.Log
import com.example.eventbus.Bus.EventBus
import com.example.eventbusproject.Messages.CustomMessage

class B : EventBus.Subscriber {

    fun sendToOther ( message : CustomMessage) {
        EventBus.getBusInstance().publish(message)
    }

    override fun receiveMessage(message: EventBus.BusMessage) {
        if (message is CustomMessage) {
        //    Log.d("messagesSendingThrowBus" , message.getMessageSendingBody())
        }

    }
}