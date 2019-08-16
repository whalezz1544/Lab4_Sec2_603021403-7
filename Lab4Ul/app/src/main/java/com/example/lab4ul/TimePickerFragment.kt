package com.example.lab4ul

import android.app.Dialog
import android.app.TimePickerDialog
import android.content.DialogInterface
import android.os.Bundle
import android.widget.TextView
import android.widget.TimePicker
import android.widget.Toast
import androidx.fragment.app.DialogFragment
import java.util.*

class TimePickerFragment : DialogFragment(), TimePickerDialog.OnTimeSetListener {
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        // Use the current time as the default values for the picker val Calendar.get Instance () val hour = c.get (Calendar. HOUR OF DAY) val minute =c.get (Calendar. MINUTE)
        val c = Calendar.getInstance()
        val hour = c.get(Calendar.HOUR_OF_DAY)
        val minute = c.get(Calendar.MINUTE)

        return TimePickerDialog(activity,  2,this, hour, minute,  true)
    }

    override fun onTimeSet(view: TimePicker, hourOfDay: Int, minute: Int) {
        val minuteNew : String = if(minute<10) "0${minute.toString()}" else minute.toString()
        activity?.findViewById<TextView>(R.id.text_time)?.text = "$hourOfDay:$minuteNew"
    }
    override fun onCancel(dialog: DialogInterface?) {
        Toast.makeText(activity,"Please select a time.", Toast.LENGTH_SHORT).show()
        super.onCancel(dialog)
    }
}
