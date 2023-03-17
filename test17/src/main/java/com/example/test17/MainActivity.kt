package com.example.test17

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Environment
import android.util.Log
import com.example.test17.databinding.ActivityMainBinding
import java.io.BufferedReader
import java.io.File
import java.io.OutputStreamWriter

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    lateinit var file : File
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //앱별 저장소는
        //data -> data ->패키지명:(com.example.test17) -> files
        binding.button1.setOnClickListener {
//            file = File(filesDir, "test.txt")
//            val writeStream: OutputStreamWriter = file.writer()
//            writeStream.write("hello world")
//            writeStream.flush()

//            openFileOutput("test2.txt", Context.MODE_PRIVATE).use {
//                it.write("hello world!!".toByteArray())

            if (Environment.getExternalStorageState() == Environment.MEDIA_MOUNTED) {
                Log.d("lsy", "외장 메모리 있다.")
            } else {
                Log.d("lsy", "외장 메모리 없다.")
            }
            binding.button2.setOnClickListener {
//            val readStream: BufferedReader = file.reader().buffered()
//            readStream.forEachLine {
//                Log.d("kkang", "$it")
//            }

                openFileInput("test2.txt").bufferedReader().forEachLine {
                    Log.d("kkang", "$it")
                }
            }
        }
    }}