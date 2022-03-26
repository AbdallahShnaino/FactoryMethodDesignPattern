package com.example.singletonsesignpattern

import android.content.Context
import android.widget.Toast

class DBConnection {
    companion object{
        private var instance : DBConnection? = null
        public fun getObjectReference () : DBConnection{
            if ( instance == null ) {
                instance = DBConnection()
            }
            return instance!!
        }
    }
    private constructor(){

    }
    fun makeConnection () : String {
        return "DB Connection created successfully"
    }
}