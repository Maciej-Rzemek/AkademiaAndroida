package com.example.akademiaandroida.features.episodes.all.presentation

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.akademiaandroida.R
import com.example.akademiaandroida.features.episodes.all.presentation.model.EpisodeDisplayable
import kotlinx.android.synthetic.main.episode_item.view.*

class EpisodeAdapter : RecyclerView.Adapter<EpisodeAdapter.EpisodeViewHolder>() {

    var listener: ((EpisodeDisplayable) -> Unit)? = null
    private val episodes by lazy {
        mutableListOf<EpisodeDisplayable>()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EpisodeViewHolder {
        val itemView = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.episode_item, parent, false)

        return EpisodeViewHolder(itemView)
    }

    override fun getItemCount(): Int = episodes.size

    override fun onBindViewHolder(holder: EpisodeViewHolder, position: Int) {
        val episode = episodes[position]
        holder.bind(episode)
    }

    fun setEpisodes(episodes: List<EpisodeDisplayable>) {
        if (episodes.isNotEmpty()) {
            this.episodes.clear()
        }

        this.episodes.addAll(episodes)
        notifyDataSetChanged()
    }

    inner class EpisodeViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bind(episode: EpisodeDisplayable) {
            with(itemView) {
                episode_title.text = episode.name
                episode_per_season.text = episode.code
                listener?.let { setOnClickListener { it(episode) } }
            }
        }
    }
}