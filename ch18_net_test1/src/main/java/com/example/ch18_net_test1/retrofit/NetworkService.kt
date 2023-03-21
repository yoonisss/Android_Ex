package com.example.ch18_net_test1.retrofit


import com.example.ch18_net_test1.model.PageListModel
import com.example.ch18_net_test1.model.Walking
import retrofit2.Call
import retrofit2.http.*


interface NetworkService {


    @GET("/6260000/WalkingService/getWalkingKr")
    fun getList(
        @Query("serviceKey") serviceKey: String?,
        @Query("pageNo") pageNo: Int,
        @Query("numOfRows") numOfRows: Int,
        @Query("resultType") resultType:String?

    ): Call<Walking>

}