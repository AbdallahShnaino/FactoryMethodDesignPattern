package com.example.methodfactorypattern.Requests

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import com.example.methodfactorypattern.FactoryMethodBuilder.Applicant
import com.example.methodfactorypattern.R

class NewVisaActivity : AppCompatActivity() , Applicant{
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new_visa)
        var layout = findViewById<LinearLayout>(R.id.myLayout)
        interfaceCreation(layout)
    }

    override fun deliverActivity(): Activity {
        return this
    }

    override fun UIBuilder(layout: LinearLayout) {
        layout.addView(newSpace(this))
        layout.addView(newTextLabel(this , "Location"))
        layout.addView(newSpace(this))
        layout.addView(newTextField(this,"Location"))
        layout.addView(newSpace(this))

        layout.addView(newSpace(this))
        layout.addView(newTextLabel(this , "Date of Trip"))
        layout.addView(newSpace(this))
        layout.addView(newTextField(this,"Date of Trip"))
        layout.addView(newSpace(this))

        layout.addView(newSpace(this))
        layout.addView(newTextLabel(this , "Trip Duration"))
        layout.addView(newSpace(this))
        layout.addView(newTextField(this,"Trip Duration"))
        layout.addView(newSpace(this))

    }
}