package com.example.test10

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.DatePicker
import android.widget.TimePicker
import com.example.test10.databinding.ActivityMain279Binding

class MainActivity279 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //바인딩 뒤에 계속 사용함.
        //
        val binding = ActivityMain279Binding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.button1.setOnClickListener {
        DatePickerDialog(this, object: DatePickerDialog.OnDateSetListener {
            override fun onDateSet(p0: DatePicker?, p1: Int, p2: Int, p3: Int) {
                Log.d("kkang", "year : $p1, month : ${p2+1}, dayOfMonth : $p3")
            }
        }, 2023, 2, 10).show()
        }
        binding.button2.setOnClickListener {
        TimePickerDialog(this, object: TimePickerDialog.OnTimeSetListener {
            override fun onTimeSet(p0: TimePicker?, p1: Int, p2: Int) {
                Log.d("kkang", "time : $p1, minute : $p2")
            }
        }, 14, 0, true).show()
        }
    }
}