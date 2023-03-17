package com.example.ch17_database_test

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import com.example.ch17_database_test.databinding.ActivityAddBinding


        class AddActivity2 : AppCompatActivity() {
            lateinit var binding: ActivityAddBinding
            override fun onCreate(savedInstanceState: Bundle?) {
                super.onCreate(savedInstanceState)
                binding= ActivityAddBinding.inflate(layoutInflater)
                setContentView(binding.root)
            }

            override fun onCreateOptionsMenu(menu: Menu?): Boolean {
                menuInflater.inflate(R.menu.menu_add, menu)
                return super.onCreateOptionsMenu(menu)
            }

            override fun onOptionsItemSelected(item: MenuItem): Boolean = when(item.itemId){
                R.id.menu_add_save2 ->{
                    //add........................
                    val inputData1 = binding.addEditView2.text.toString()
                    val inputData2 = binding.addEditView3.text.toString()

                    //DBHelper 클래스 이름을 변경
                    val db = DBHelper(this).writableDatabase
                    db.execSQL("insert into User (name, age) values (?,?)",
                        arrayOf <String> (inputData1,inputData2))
                    db.close()

                    val intent = intent
                    intent.putExtra("result", inputData1)
                    intent.putExtra("result", inputData2)
                    setResult(Activity.RESULT_OK, intent)
                    finish()
                    true
                }
                else -> true
            }
        }

