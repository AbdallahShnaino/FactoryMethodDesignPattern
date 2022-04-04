package com.example.eventbusproject.Messages

import com.example.eventbus.Bus.EventBus

class CustomMessage : EventBus.BusMessage() {
    private var nameToDelete :String? = null

    public fun setNameToDelete (messageBody :String) {
        this.nameToDelete = messageBody
    }

    fun getNameToDelete () : String {
       return nameToDelete!!
    }
}