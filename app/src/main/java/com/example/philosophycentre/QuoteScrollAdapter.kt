package com.example.philosophycentre

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.philosophycentre.model.Quote

class QuoteScrollAdapter(
    private val context: Context,
    private val dataset: List<Quote>
) : RecyclerView.Adapter<QuoteScrollAdapter.QuoteScrollViewHolder>() {

    class QuoteScrollViewHolder(val view: View) : RecyclerView.ViewHolder(view) {
        // Add a variable for the main card view, then set an on-click listener later
        val quoteTextView: TextView = view.findViewById(R.id.quote_item_text)
        val quoteAttributionView: TextView = view.findViewById(R.id.quote_item_attribution)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): QuoteScrollViewHolder {
        val layout = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.quote_item, parent, false)
        // Setup custom accessibility delegate to set the text read

        return QuoteScrollViewHolder(layout)
    }

    override fun onBindViewHolder(holder: QuoteScrollViewHolder, position: Int) {
        val item = dataset[position]
        holder.quoteTextView.text = context.resources.getString(item.textResourceId)
        // holder.quoteAttributionView.text = context.resources.getString(item.attributionResourceId)
        holder.quoteAttributionView.text = item.attributionResource
    }

    override fun getItemCount(): Int {
        return dataset.size
    }
    
    companion object {
        val TAG: String = "[QuoteScrollAdapter]"
    }
}
