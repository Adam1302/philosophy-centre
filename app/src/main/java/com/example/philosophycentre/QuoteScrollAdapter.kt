package com.example.philosophycentre

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.philosophycentre.model.FavouriteQuoteClickListener
import com.example.philosophycentre.model.Quote

class QuoteScrollAdapter(
    private val context: Context,
    private val dataset: List<Quote>,
    private val favouriteQuoteClickListener: FavouriteQuoteClickListener
) : RecyclerView.Adapter<QuoteScrollAdapter.QuoteScrollViewHolder>() {
    val bookmarkOpenResource: Int = context.resources.getIdentifier(
        "ic_bookmark_open",
        "drawable",
        context.packageName
    )
    val bookmarkFilledResource: Int = context.resources.getIdentifier(
        "ic_bookmark_filled",
        "drawable",
        context.packageName
    )

    class QuoteScrollViewHolder(val view: View) : RecyclerView.ViewHolder(view) {
        // Add a variable for the main card view, then set an on-click listener later
        val quoteTextView: TextView = view.findViewById(R.id.quote_item_text)
        val quoteAttributionView: TextView = view.findViewById(R.id.quote_item_attribution)
        val quoteFavouriteButton: ImageView = view.findViewById(R.id.quote_item_favourite_button)
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
        holder.apply{
            quoteTextView.text = context.resources.getString(item.textResourceId)
            quoteAttributionView.text = item.attributionResource
            quoteFavouriteButton.setImageResource(
                if (item.favourite) {
                    R.drawable.ic_bookmark_filled
                } else {
                    R.drawable.ic_bookmark_open
                }
            )
            quoteFavouriteButton.setOnClickListener {
                if (item.favourite) {
                    quoteFavouriteButton.setImageResource(bookmarkOpenResource)
                    item.favourite = false
                } else {
                    quoteFavouriteButton.setImageResource(bookmarkFilledResource)
                    item.favourite = true
                }
                favouriteQuoteClickListener.onFavouriteQuoteClick(item)
            }
        }
    }

    override fun getItemCount(): Int {
        return dataset.size
    }
    
    companion object {
        val TAG: String = "[QuoteScrollAdapter]"
    }
}
