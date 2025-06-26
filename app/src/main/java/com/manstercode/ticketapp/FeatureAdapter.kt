package com.manstercode.ticketapp

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView


class FeatureAdapter(
    private val features: List<Feature>,
    private val onItemClick: (Feature) -> Unit
) : RecyclerView.Adapter<FeatureAdapter.FeatureViewHolder>() {
    //Called once per visible item that needs to be created.
    //
    //LayoutInflater converts item_feature.xml into a View.
    //
    //That view is passed to FeatureViewHolder which extracts icon and name.

    inner class FeatureViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val icon: ImageView = itemView.findViewById(R.id.featureIcon)
        val name: TextView = itemView.findViewById(R.id.featureName)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FeatureViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_feature, parent, false)
        return FeatureViewHolder(view)
    }

    override fun onBindViewHolder(holder: FeatureViewHolder, position: Int) {
        val feature = features[position]
        //holder.icon.setImageResource(feature.iconResId)
        holder.icon.setImageResource(feature.iconResId)
        holder.name.text = feature.name
        //Binds the data to the UI:
        //iconResId: sets the image
        //name: sets the label
        //Adds a click listener that calls onItemClick(feature) — this is how you open different activities from the dashboard.
        // Handle item click
        holder.itemView.setOnClickListener {
            onItemClick(feature)
        }
    }

    override fun getItemCount() = features.size
    //Returns how many items to display in the grid.
}

