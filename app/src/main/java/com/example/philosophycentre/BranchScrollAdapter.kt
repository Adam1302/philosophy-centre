package com.example.philosophycentre

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.philosophycentre.model.BranchListClickListener
import com.example.philosophycentre.model.Philosopher
import com.example.philosophycentre.model.PhilosopherListClickListener
import com.example.philosophycentre.model.PhilosophyBranch
import com.google.android.material.card.MaterialCardView

class BranchScrollAdapter(
    private val context: Context,
    private val dataset: List<PhilosophyBranch>,
    private val branchListClickListener: BranchListClickListener
) : RecyclerView.Adapter<BranchScrollAdapter.BranchScrollViewHolder>() {

    class BranchScrollViewHolder(val view: View) : RecyclerView.ViewHolder(view) {
        // Add a variable for the main card view, then set an on-click listener later
        val branchNameTextView: TextView = view.findViewById(R.id.branch_item_name)
        val branchInterestsTextView: TextView = view.findViewById(R.id.branch_item_interested)
        val branchItem: MaterialCardView = view.findViewById(R.id.single_branch_item)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BranchScrollViewHolder {
        val layout = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.branch_item, parent, false)

        return BranchScrollViewHolder(layout)
    }

    override fun onBindViewHolder(holder: BranchScrollViewHolder, position: Int) {
        val item = dataset[position]
        holder.apply {
            branchNameTextView.text = item.name
            branchInterestsTextView.text = android.text.TextUtils.join(
                ", ",
                item.interestedPhilosophers.map { philosopher -> philosopher.name }
            )
            branchItem.setOnClickListener {
                branchListClickListener.onBranchListItemClick(item)
            }
        }
    }

    override fun getItemCount(): Int {
        return dataset.size
    }

    companion object {
        val TAG: String = "[BranchScrollAdapter]"
    }
}