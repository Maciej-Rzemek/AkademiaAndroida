package com.example.akademiaandroida.features.episodes.all.presentation

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.akademiaandroida.core.adapter.BindableAdapter
import com.example.akademiaandroida.databinding.EpisodeItemBinding
import com.example.akademiaandroida.features.episodes.all.presentation.model.EpisodeDisplayable

class EpisodeAdapter : BindableAdapter<EpisodeDisplayable>,
    RecyclerView.Adapter<EpisodeAdapter.EpisodeViewHolder>() {

    var listener: ((EpisodeDisplayable) -> Unit)? = null
    private val episodes by lazy {
        mutableListOf<EpisodeDisplayable>()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EpisodeViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = EpisodeItemBinding.inflate(inflater, parent, false)

        return EpisodeViewHolder(binding)
    }

    override fun getItemCount(): Int = episodes.size

    override fun onBindViewHolder(holder: EpisodeViewHolder, position: Int) {
        val episode = episodes[position]
        holder.bind(episode, listener)
    }

    override fun setItems(items: List<EpisodeDisplayable>) {
        if (items.isNotEmpty()) {
            this.episodes.clear()
        }

        this.episodes.addAll(items)
        notifyDataSetChanged()
    }

    fun setOnEpisodeClickListener(listener: (EpisodeDisplayable) -> Unit) {
        this.listener = listener
    }

    inner class EpisodeViewHolder(private val binding: EpisodeItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(
            episode: EpisodeDisplayable,
            listener: ((EpisodeDisplayable) -> Unit)?
        ) {
            with(binding) {
                binding.item = episode
                listener?.let { root.setOnClickListener { it(episode) } }
                binding.executePendingBindings()
            }
        }
    }
}