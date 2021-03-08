package com.example.akademiaandroida.features.character.all.presentation

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.akademiaandroida.core.adapter.BindableAdapter
import com.example.akademiaandroida.databinding.CharacterItemBinding
import com.example.akademiaandroida.features.character.all.presentation.model.CharacterDisplayable

class CharacterAdapter : BindableAdapter<CharacterDisplayable>,
    RecyclerView.Adapter<CharacterAdapter.CharacterViewHolder>() {

    var listener: ((CharacterDisplayable) -> Unit)? = null
    val characters by lazy {
        mutableListOf<CharacterDisplayable>()
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): CharacterAdapter.CharacterViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = CharacterItemBinding.inflate(inflater, parent, false)

        return CharacterViewHolder(binding)
    }

    override fun getItemCount(): Int = characters.size

    override fun onBindViewHolder(holder: CharacterAdapter.CharacterViewHolder, position: Int) {
        val character = characters[position]
        holder.bind(character, listener)
    }

    override fun setItems(items: List<CharacterDisplayable>) {
        if (items.isNotEmpty()) {
            this.characters.clear()
        }

        this.characters.addAll(items)
        notifyDataSetChanged()
    }


    fun setOnCharacterClickListener(listener: (CharacterDisplayable) -> Unit) {
        this.listener = listener
    }

    inner class CharacterViewHolder(private val binding: CharacterItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(
            character: CharacterDisplayable,
            listener: ((CharacterDisplayable) -> Unit)?
        ) {
            with(binding) {
                binding.item = character
                listener?.let { root.setOnClickListener { it(character) } }
                binding.executePendingBindings()
            }
        }
    }
}