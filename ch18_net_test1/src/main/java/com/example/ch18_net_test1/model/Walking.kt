package com.example.ch18_net_test1.model

import android.content.ClipData

data class Walking(
    val getWalkingKr: GetWalkingKr
)

data class GetWalkingKr(
    val item: MutableList<Item>
        )

data class Item (
    val MAIN_TITLE: String,
    val MAIN_IMG_THUMB: String
        )
