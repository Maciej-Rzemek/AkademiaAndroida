package com.example.akademiaandroida.features.location.all.presentation

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.akademiaandroida.core.adapter.BindableAdapter
import com.example.akademiaandroida.databinding.LocationItemBinding
import com.example.akademiaandroida.features.location.all.presentation.model.LocationDisplayable

class LocationAdapter : BindableAdapter<LocationDisplayable>,
    RecyclerView.Adapter<LocationAdapter.LocationViewHolder>() {

    var listener: ((LocationDisplayable) -> Unit)? = null
    private val locations by lazy {
        mutableListOf<LocationDisplayable>()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LocationViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = LocationItemBinding.inflate(inflater, parent, false)
        return LocationViewHolder(binding)
    }

    override fun getItemCount(): Int = locations.size

    override fun onBindViewHolder(holder: LocationViewHolder, position: Int) {
        val location = locations[position]
        holder.bind(location, listener)
    }

    override fun setItems(items: List<LocationDisplayable>) {
        if (items.isNotEmpty()) {
            this.locations.clear()
        }

        this.locations.addAll(items)
        notifyDataSetChanged()
    }

    fun setOnLocationClickListener(listener: (LocationDisplayable) -> Unit) {
        this.listener = listener
    }

    inner class LocationViewHolder(private val binding: LocationItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(
            location: LocationDisplayable,
            listener: ((LocationDisplayable) -> Unit)?
        ) {
            with(binding) {
                binding.item = location
                listener?.let { root.setOnClickListener { it(location) } }
                binding.executePendingBindings()
            }
        }
    }
}

