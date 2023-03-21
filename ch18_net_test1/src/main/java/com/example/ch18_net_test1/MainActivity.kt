package com.example.ch18_net_test1

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.ch18_net_test1.databinding.ActivityMainBinding
import com.example.ch18_net_test1.model.ItemModel
import com.example.ch18_net_test1.model.PageListModel
import com.example.ch18_net_test1.model.Walking
import com.example.ch18_net_test1.recycler.MyAdapter
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        val serviceKey = "ySW6Ei6Oncs0opwRU/DIeWdmLYyXDK7LXEybY0cGhExFc10LY76oPuVHH5nXFB0FM7A3I1QKOvuiIbtAkIirhw=="

        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val networkService = (applicationContext as MyApplication).networkService

        val userListCall = networkService.getList(
            serviceKey,
            1,
            10,
            "json"
        )
        Log.d("lsy", "url:" + userListCall.request().url().toString())

        userListCall.enqueue(object : Callback<Walking> {
            override fun onResponse(call: Call<Walking>, response: Response<Walking>) {

                val userList = response.body()
                Log.d("lsy","userList data 값 : ${userList?.getWalkingKr?.item}")
                //.......................................

                binding.recyclerView.adapter=MyAdapter(this@MainActivity, userList?.getWalkingKr?.item)

                binding.recyclerView.addItemDecoration(
                    DividerItemDecoration(this@MainActivity, LinearLayoutManager.VERTICAL)
                )

//                binding.pageView.text=userList?.page
//                binding.totalView.text=userList?.total
            }

            override fun onFailure(call: Call<Walking>, t: Throwable) {
                call.cancel()
            }
        })



    }
}