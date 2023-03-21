package com.example.ch18_net_test1.model

import com.google.gson.annotations.SerializedName

data class ItemModel (
    @SerializedName("MAIN_TITLE")
    var MAIN_TITLE: String,
    @SerializedName("MAIN_IMG_NORMAL")
    var MAIN_IMG_NORMAL: String
)

