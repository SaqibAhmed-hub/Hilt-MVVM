package com.example.hiltmvvm.presentation

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import coil.load
import com.example.hiltmvvm.R
import com.example.hiltmvvm.data.network.dto.Result
import com.example.hiltmvvm.databinding.ActivityDetailBinding

class DetailActivity : AppCompatActivity() {
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        val binding: ActivityDetailBinding =
            DataBindingUtil.setContentView(this, R.layout.activity_detail)

        val character = intent.getParcelableExtra<Result>("Character")

        binding.characterDetailImage.load(character?.image)
        binding.characterDetailName.text = "Name : ${character?.name}"
        binding.characterDetailStatus.text = "Status: ${character?.status}"
        binding.characterDetailSpecies.text = "Species: ${character?.species}"
        binding.characterDetailType.text = "Type: ${character?.type}"
        binding.characterDetailGender.text = "Gender: ${character?.gender}"
        binding.characterDetailLocation.text ="Location: ${character?.location?.name}"
        binding.executePendingBindings()
    }
}