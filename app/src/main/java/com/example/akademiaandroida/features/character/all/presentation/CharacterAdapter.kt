package com.example.akademiaandroida.features.character.all.presentation

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.akademiaandroida.R
import com.example.akademiaandroida.features.character.all.presentation.model.CharacterDisplayable
import kotlinx.android.synthetic.main.character_item.view.*

class CharacterAdapter : RecyclerView.Adapter<CharacterAdapter.CharacterViewHolder>() {

    var listener: ((CharacterDisplayable) -> Unit)? = null
    val characters by lazy {
        mutableListOf<CharacterDisplayable>()
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): CharacterAdapter.CharacterViewHolder {
        val itemView = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.character_item, parent, false)

        return CharacterViewHolder(itemView)
    }

    override fun getItemCount(): Int = characters.size

    override fun onBindViewHolder(holder: CharacterAdapter.CharacterViewHolder, position: Int) {
        val character = characters[position]
        holder.bind(character)
    }

    fun setCharacters(characters: List<CharacterDisplayable>) {
        if (characters.isNotEmpty()) {
            this.characters.clear()
        }

        this.characters.addAll(characters)
        notifyDataSetChanged()
    }

    inner class CharacterViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bind(character: CharacterDisplayable) {
            with(itemView) {
                Glide.with(this).load(character.image).into(character_imageview)
                character_name.text = character.name
                listener?.let { setOnClickListener { it(character) } }
            }
        }
    }
}