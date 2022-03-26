package com.example.methodfactorypattern.Requests

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import com.example.methodfactorypattern.FactoryMethodBuilder.Applicant
import com.example.methodfactorypattern.R

class NewPassportActivity : AppCompatActivity() , Applicant {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new_passport)
        var layout = findViewById<LinearLayout>(R.id.myLayout)
        interfaceCreation(layout)
    }
    override fun deliverActivity(): Activity {
        return this
    }

    override fun UIBuilder(layout: LinearLayout) {
        layout.addView(newSpace(this))
        layout.addView(newTextLabel(this , "Old Passport Number"))
        layout.addView(newSpace(this))
        layout.addView(newTextField(this,"Old Passport Number"))
        layout.addView(newSpace(this))

        layout.addView(newSpace(this))
        layout.addView(newTextLabel(this , "Expiration Date"))
        layout.addView(newSpace(this))
        layout.addView(newTextField(this,"Expiration Date"))
        layout.addView(newSpace(this))


    }
}