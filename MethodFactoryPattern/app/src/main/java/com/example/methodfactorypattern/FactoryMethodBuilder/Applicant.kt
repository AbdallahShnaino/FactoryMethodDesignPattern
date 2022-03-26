package com.example.methodfactorypattern.FactoryMethodBuilder

import android.app.ActionBar
import android.app.Activity
import android.view.View
import android.widget.*


open interface Applicant {
    fun interfaceCreation (layout : LinearLayout) {
        var activity = deliverActivity()
        // applicantIName
        newSpace(activity)
        layout.addView(newTextLabel(activity , "applicant Name"))
        newSpace(activity)
        layout.addView(newTextField(activity , "applicant Name"))
        newSpace(activity)


        // applicantID
        newSpace(activity)
        layout.addView(newTextLabel(activity , "applicant ID"))
        newSpace(activity)
        layout.addView(newTextField(activity , "applicant ID"))
        newSpace(activity)

        // applicantAddress
        newSpace(activity)
        layout.addView(newTextLabel(activity , "applicant Address"))
        newSpace(activity)
        layout.addView(newTextField(activity , "applicant Address"))
        newSpace(activity)

        // user do whatever he wants
        UIBuilder(layout)
        // btn
        layout.addView(newButton(activity,"Send"))

    }

    open fun deliverActivity () : Activity
    open fun UIBuilder (layout: LinearLayout)
    private fun newButton (activity: Activity , text: String) : Button{
        var reference = Button(activity)
        reference.layoutParams =
            ActionBar.LayoutParams(
                ActionBar.LayoutParams.MATCH_PARENT,
                ActionBar.LayoutParams.WRAP_CONTENT
            )
        reference.hint = text
        reference.textSize = 22f
        return reference
    }
     fun newSpace( activity: Activity ) : View {
        var reference = View(activity)
        reference.layoutParams =
            ActionBar.LayoutParams(
                ActionBar.LayoutParams.MATCH_PARENT,
                16
            )
        return reference
    }
     fun newTextField( activity: Activity , text: String) : EditText {
        var reference = EditText(activity)
        reference.layoutParams =
            ActionBar.LayoutParams(
                ActionBar.LayoutParams.MATCH_PARENT,
                ActionBar.LayoutParams.WRAP_CONTENT
            )
        reference.hint = text
        reference.textSize = 22f
        return reference
    }
     fun newTextLabel (activity: Activity , text: String) : TextView{
        var reference = TextView(activity)
        reference.layoutParams =
            ActionBar.LayoutParams(
                ActionBar.LayoutParams.MATCH_PARENT,
                ActionBar.LayoutParams.WRAP_CONTENT
            )
        reference.text = text
        reference.textSize = 22f
        return reference
    }
}