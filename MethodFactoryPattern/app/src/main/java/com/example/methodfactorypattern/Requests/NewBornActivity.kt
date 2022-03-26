package com.example.methodfactorypattern.Requests

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import com.example.methodfactorypattern.FactoryMethodBuilder.Applicant
import com.example.methodfactorypattern.R

class NewBornActivity : AppCompatActivity() , Applicant{
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new_born)
        var layout = findViewById<LinearLayout>(R.id.myLayout)
        interfaceCreation(layout)
    }
    override fun deliverActivity(): Activity {
        return this
    }

    override fun UIBuilder(layout: LinearLayout) {
        layout.addView(newSpace(this))
        layout.addView(newTextLabel(this , "Born Name"))
        layout.addView(newSpace(this))
        layout.addView(newTextField(this,"Born Name"))
        layout.addView(newSpace(this))

        layout.addView(newSpace(this))
        layout.addView(newTextLabel(this , "Date of Birth"))
        layout.addView(newSpace(this))
        layout.addView(newTextField(this,"Date of Birth"))
        layout.addView(newSpace(this))

        layout.addView(newSpace(this))
        layout.addView(newTextLabel(this , "Born Sex"))
        layout.addView(newSpace(this))
        layout.addView(newTextField(this,"Born Sex"))
        layout.addView(newSpace(this))

    }
}