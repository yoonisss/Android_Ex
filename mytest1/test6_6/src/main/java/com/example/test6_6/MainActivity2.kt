package com.example.test6_6

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.ActionBarDrawerToggle
import com.example.test6_6.databinding.ActivityMain2Binding
import com.example.test6_6.databinding.ActivityMain3Binding


class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main3)

        val binding = ActivityMain2Binding.inflate(layoutInflater)
        // 액티비티 화면 출력
        setContentView(binding.root)
        // 뷰 객체 이용
//        binding.visibleBtn.setOnClickListener {
//            binding.targetView.visibility = View.VISIBLE
//        }
//        binding.invisibleBtn.setOnClickListener {
//            binding.targetView.visibility = View.INVISIBLE
//        }


    }
}