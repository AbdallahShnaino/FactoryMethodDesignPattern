package com.example.eventbus.Bus

import java.util.*

class EventBus {

    private constructor(){
    }



    public fun setSubscribers (subscriber : Subscriber) {
        if (!subscribers.contains(subscriber)) {
            subscribers.add(subscriber)
        }
    }

    public fun RemoveSubscribers (subscriber : Subscriber) {
        if (!subscribers.contains(subscriber)) {
            subscribers.remove(subscriber)
        }
    }

    companion object {
        private var subscribers = ArrayList<Subscriber>()
        private var instance : EventBus? = null
        fun getBusInstance () : EventBus{
            if ( instance == null ) {

                instance = EventBus()
            }
            return instance!!
        }




    }


    public fun publish (message : BusMessage) {
        for ( client in subscribers ) {
            if (client.equals(message.getMessageSender())) {
                client.receiveMessage(message)
            }
        }
    }

    interface Subscriber {
        fun receiveMessage ( message : BusMessage )
    }
    abstract class BusMessage {
        private lateinit var sender : Subscriber
        public fun setMessageSender ( sender : Subscriber ) {
            this.sender = sender
        }
        public fun getMessageSender (  ) : Subscriber{
            return sender
        }
    }




}