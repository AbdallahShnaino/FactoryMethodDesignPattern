package com.example.observerproject.EventListener

import android.util.Log

class EventListener  {
    private constructor(){}
    companion object {
        private var array = ArrayList<ColorChangingListener>()
        private val names = ArrayList<String>()
        private var instance : EventListener? = null
        fun getInstance () : EventListener{
            if (instance == null){
                instance = EventListener()
                return instance!!
            }else{
                return instance!!
            }
        }
    }

    fun register (obj : ColorChangingListener) {
        Log.d("aaaaa" , obj.javaClass.name)
        if (!names.contains(obj.javaClass.name)){
            array.add(obj)
            names.add(obj.javaClass.name)
        }
    }
    fun sendMessage ( message : String) {
        for ( obj in array  ){
            obj.getUpdates(message)
        }
    }

    interface ColorChangingListener {
        public fun getUpdates ( message : String)
    }
}