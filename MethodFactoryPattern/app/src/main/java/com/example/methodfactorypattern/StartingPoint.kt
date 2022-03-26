package com.example.methodfactorypattern

import android.app.Activity
import android.app.Application
import com.example.methodfactorypattern.FactoryMethodBuilder.Applicant
import java.io.File

class StartingPoint : Application() {
    companion object{
        val map : HashMap<String, Class<out Activity?>> = HashMap<String, Class<out Activity?>>()

    }
    fun start () {
        val directory = File("/home/abdallah/eclipse-workspace/Homework1/src/TabApp")
        val filesCollection = directory.listFiles()
        var index = 1
        for (file in filesCollection) {
            val className = file.name.split("\\.").toTypedArray()[0]
            var c: Class<out Activity?>? = null
            try {
                c = Class.forName("Requests.$className").asSubclass(Activity::class.java)
                map.put( className , c)
                index++
            } catch (e: ClassNotFoundException) {
                e.printStackTrace()
            }
        }
    }
}