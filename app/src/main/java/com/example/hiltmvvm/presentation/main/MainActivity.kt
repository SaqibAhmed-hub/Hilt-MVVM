package com.example.hiltmvvm.presentation.main

import android.content.ClipData
import android.content.Intent
import android.graphics.drawable.GradientDrawable
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.hiltmvvm.R
import com.example.hiltmvvm.data.network.dto.Result
import com.example.hiltmvvm.databinding.ActivityMainBinding
import com.example.hiltmvvm.presentation.DetailActivity
import com.example.hiltmvvm.presentation.adapter.CharacterAdapter
import com.example.hiltmvvm.utils.OnItemClickListener
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity(),OnItemClickListener {

    lateinit var mainViewModel: MainViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding: ActivityMainBinding =
            DataBindingUtil.setContentView(this, R.layout.activity_main)

        mainViewModel = ViewModelProvider(this)[MainViewModel::class.java]
        mainViewModel.getData()

        binding.recyclerView.layoutManager = GridLayoutManager(this,3)

        mainViewModel.data.observe(this,{
            val adapter = CharacterAdapter(it,this)
            binding.recyclerView.adapter = adapter
        })

    }

    override fun OnItemClick(position: Int, Item: Result) {
        Toast.makeText(this,"${Item.name} + $position ",Toast.LENGTH_SHORT).show()
        val intent = Intent(this,DetailActivity::class.java)
        intent.putExtra("Character", Item)
        startActivity(intent)
    }
}