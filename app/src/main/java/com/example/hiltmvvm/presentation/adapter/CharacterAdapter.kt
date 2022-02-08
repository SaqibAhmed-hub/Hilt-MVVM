package com.example.hiltmvvm.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.hiltmvvm.data.network.dto.Result
import com.example.hiltmvvm.databinding.ItemCharacterBinding
import com.example.hiltmvvm.utils.OnItemClickListener

class CharacterAdapter(val characterData: List<Result>,val onItemClickListener: OnItemClickListener): RecyclerView.Adapter<CharacterAdapter.ViewHolder>() {

    inner class ViewHolder(
        val binding: ItemCharacterBinding
    ):RecyclerView.ViewHolder(binding.root){

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder  {
        val inflater = LayoutInflater.from(parent.context)
        val characterBinding = ItemCharacterBinding.inflate(inflater,parent,false)
        return ViewHolder(characterBinding,)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val Item = characterData[position]
        holder.binding.characterText.text = Item.name
        holder.binding.characterStatus.text = Item.status
        holder.binding.characterImage.load(Item.image)
        holder.binding.root.setOnClickListener {
            onItemClickListener.OnItemClick(position,Item)
        }
    }

    override fun getItemCount(): Int {
       return characterData.size
    }


}