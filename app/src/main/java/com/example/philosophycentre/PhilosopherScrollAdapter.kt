package com.example.philosophycentre

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.philosophycentre.model.Philosopher
import com.example.philosophycentre.model.PhilosopherListClickListener
import com.example.philosophycentre.model.Quote
import com.google.android.material.card.MaterialCardView

class PhilosopherScrollAdapter(
    private val context: Context,
    private val dataset: List<Philosopher>,
    private val philosopherListClickListener: PhilosopherListClickListener
) : RecyclerView.Adapter<PhilosopherScrollAdapter.PhilosopherScrollViewHolder>() {

    class PhilosopherScrollViewHolder(val view: View) : RecyclerView.ViewHolder(view) {
        // Add a variable for the main card view, then set an on-click listener later
        val philosopherNameTextView: TextView = view.findViewById(R.id.philosopher_item_name)
        val philosopherInterestsTextView: TextView = view.findViewById(R.id.philosopher_item_interests)
        val philosopherItem: MaterialCardView = view.findViewById(R.id.single_philosopher_item)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PhilosopherScrollViewHolder {
        val layout = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.philosopher_item, parent, false)

        return PhilosopherScrollViewHolder(layout)
    }

    override fun onBindViewHolder(holder: PhilosopherScrollViewHolder, position: Int) {
        val item = dataset[position]
        holder.philosopherNameTextView.text = item.name
        // holder.quoteAttributionView.text = context.resources.getString(item.attributionResourceId)
        holder.philosopherInterestsTextView.text = android.text.TextUtils.join(",", item.interests)

        holder.philosopherItem.setOnClickListener {
            philosopherListClickListener.onPhilosopherListItemClick(item)
            // findNavController().navigate(R.id.action_philosopherScrollFragment_to_philosopherProfileFragment)
        }
    }

    override fun getItemCount(): Int {
        return dataset.size
    }

    companion object {
        val TAG: String = "[PhilosopherScrollAdapter]"
    }
}