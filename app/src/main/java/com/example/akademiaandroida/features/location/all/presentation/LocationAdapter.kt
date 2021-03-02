package com.example.akademiaandroida.features.location.all.presentation

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.akademiaandroida.R
import com.example.akademiaandroida.features.location.all.presentation.model.LocationDisplayable
import kotlinx.android.synthetic.main.location_item.view.*

class LocationAdapter : RecyclerView.Adapter<LocationAdapter.LocationViewHolder>() {

    var listener: ((LocationDisplayable) -> Unit)? = null
    private val locations by lazy {
        mutableListOf<LocationDisplayable>()
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): LocationAdapter.LocationViewHolder {
        val itemView = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.location_item, parent, false)

        return LocationViewHolder(itemView)
    }

    override fun getItemCount(): Int = locations.size

    override fun onBindViewHolder(holder: LocationAdapter.LocationViewHolder, position: Int) {
        val location = locations[position]
        holder.bind(location)
    }

    fun setLocations(locations: List<LocationDisplayable>) {
        if (locations.isNotEmpty()) {
            this.locations.clear()
        }

        this.locations.addAll(locations)
        notifyDataSetChanged()
    }

    inner class LocationViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bind(location: LocationDisplayable) {
            with(itemView) {
                location_title.text = location.name
                location_dimension.text = location.dimension
                listener?.let { setOnClickListener { it(location) } }
            }
        }
    }
}