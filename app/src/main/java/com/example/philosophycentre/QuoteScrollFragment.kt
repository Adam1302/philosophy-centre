package com.example.philosophycentre

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.philosophycentre.databinding.FragmentQuoteScrollBinding
import com.example.philosophycentre.model.FavouriteQuoteClickListener
import com.example.philosophycentre.model.PhilosopherListClickListener
import com.example.philosophycentre.model.PhilosophyViewModel
import com.example.philosophycentre.model.Quote

class QuoteScrollFragment : Fragment(), FavouriteQuoteClickListener {
    private var binding: FragmentQuoteScrollBinding? = null
    private var isLinearLayoutManager = true
    private val sharedViewModel: PhilosophyViewModel by activityViewModels()
    private lateinit var recyclerView: RecyclerView
    private lateinit var favouriteQuoteClickListener: FavouriteQuoteClickListener

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val fragmentBinding = FragmentQuoteScrollBinding.inflate(inflater, container, false)
        binding = fragmentBinding

        favouriteQuoteClickListener = this

        return fragmentBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding?.apply {
            lifecycleOwner = viewLifecycleOwner
            quoteScrollFragment = this@QuoteScrollFragment
            viewModel = sharedViewModel
        }

        recyclerView = binding!!.recyclerView

        recyclerView.apply{
            layoutManager = LinearLayoutManager(requireContext())
            adapter = QuoteScrollAdapter(
                requireContext(),
                sharedViewModel.fullQuoteList,
                favouriteQuoteClickListener
            )
            addItemDecoration(
                DividerItemDecoration(context, DividerItemDecoration.VERTICAL)
            )
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }

    override fun onFavouriteQuoteClick(quote: Quote) {
        if (quote.favourite) {
            sharedViewModel.favouriteQuoteList.add(quote)
        } else {
            sharedViewModel.favouriteQuoteList.remove(quote)
        }
        Log.d(TAG, "onFavouriteQuoteClick: ${sharedViewModel.favouriteQuoteList}")
    }

    companion object {
        val TAG: String = "[QuoteScrollFragment]"
    }
}
