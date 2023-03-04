package com.example.philosophycentre

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.recyclerview.widget.RecyclerView
import com.example.philosophycentre.model.BranchListClickListener
import com.example.philosophycentre.model.Philosopher
import com.example.philosophycentre.model.PhilosopherListClickListener
import com.example.philosophycentre.model.PhilosophyBranch
import com.google.android.material.card.MaterialCardView

class BranchScrollAdapter(
    private val context: Context,
    private val dataset: List<PhilosophyBranch>,
    private val branchListClickListener: BranchListClickListener,
    private val gridView: Boolean = false
) : RecyclerView.Adapter<BranchScrollAdapter.BranchScrollViewHolder>() {

    class BranchScrollViewHolder(val view: View) : RecyclerView.ViewHolder(view) {
        // Add a variable for the main card view, then set an on-click listener later
        val branchLogoImageView: ImageView = view.findViewById(R.id.branch_item_logo)
        val branchNameTextView: TextView = view.findViewById(R.id.branch_item_name)
        val branchItem: MaterialCardView = view.findViewById(R.id.single_branch_item)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BranchScrollViewHolder {
        Log.d(TAG, "onCreateViewHolder: HELLO")
        val layout = LayoutInflater
            .from(parent.context)
            .inflate(
                if (gridView) R.layout.branch_item_grid else R.layout.branch_item,
                parent,
                false
            )

        return BranchScrollViewHolder(layout)
    }

    override fun onBindViewHolder(holder: BranchScrollViewHolder, position: Int) {
        val item = dataset[position]
        holder.apply {
            branchLogoImageView.setImageResource(
                getBranchImageResource(item)
            )
            branchNameTextView.text = item.name
            branchItem.setOnClickListener {
                branchListClickListener.onBranchListItemClick(item)
            }
        }
    }

    override fun getItemCount(): Int {
        return dataset.size
    }

    private fun getBranchImageResource(branch: PhilosophyBranch): Int {
        val imageName: String = "logo_${branch.branchNameAsLower}"
        Log.d(TAG, "getBranchImageResource: ${imageName}")
        return context.resources.getIdentifier(
            imageName,
            "drawable",
            context.packageName
        )
    }

    companion object {
        val TAG: String = "[BranchScrollAdapter]"
    }
}