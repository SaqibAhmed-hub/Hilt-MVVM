package com.example.hiltmvvm.utils

import com.example.hiltmvvm.data.network.dto.Result

interface OnItemClickListener {
    fun OnItemClick(position: Int, Item: Result)
}