package com.example.philosophycentre

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.philosophycentre.databinding.FragmentPhilosopherProfileBinding
import com.example.philosophycentre.model.BranchListClickListener
import com.example.philosophycentre.model.FavouriteQuoteClickListener
import com.example.philosophycentre.model.Philosopher
import com.example.philosophycentre.model.PhilosophyBranch
import com.example.philosophycentre.model.PhilosophyViewModel
import com.example.philosophycentre.model.Quote

class PhilosopherProfileFragment : Fragment(), BranchListClickListener, FavouriteQuoteClickListener {
    private var binding: FragmentPhilosopherProfileBinding? = null
    private val sharedViewModel: PhilosophyViewModel by activityViewModels()
    private lateinit var recyclerViewBranches: RecyclerView
    private lateinit var recyclerViewQuotes: RecyclerView
    private lateinit var philosopher: Philosopher
    private lateinit var branchListClickListener: BranchListClickListener
    private lateinit var favouriteQuoteClickListener: FavouriteQuoteClickListener

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val fragmentBinding = FragmentPhilosopherProfileBinding.inflate(inflater, container, false)
        binding = fragmentBinding
        branchListClickListener = this
        favouriteQuoteClickListener = this
        return fragmentBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        philosopher = sharedViewModel.currentPhilosopher!!

        binding?.apply {
            lifecycleOwner = viewLifecycleOwner
            philosopherProfileFragment = this@PhilosopherProfileFragment
            viewModel = sharedViewModel
            philosopherPicture.setImageResource(getPhilosopherImageResource())
            philosopherName.text = philosopher.name
            // philosopherDesc.text = philosopher.biography
            philosopherInterests.text = getString(R.string.areas_of_interest)
            philosopherQuotesTitle.text = getString(R.string.philosopher_quotes_title)

        }

        recyclerViewBranches = binding!!.recyclerViewBranches

        recyclerViewBranches.apply {
            layoutManager = LinearLayoutManager(
                requireContext(),
                LinearLayoutManager.HORIZONTAL,
                false
            )
            adapter = BranchScrollAdapter(
                requireContext(),
                philosopher.interests,
                branchListClickListener,
                true
            )
            addItemDecoration(
                DividerItemDecoration(context, DividerItemDecoration.HORIZONTAL)
            )
        }


        recyclerViewQuotes = binding!!.recyclerViewQuotes

        recyclerViewQuotes.apply {
            layoutManager = LinearLayoutManager(
                requireContext(),
                LinearLayoutManager.HORIZONTAL,
                false
            )
            adapter = QuoteScrollAdapter(
                requireContext(),
                philosopher.quotes,
                favouriteQuoteClickListener
            )
            addItemDecoration(
                DividerItemDecoration(context, DividerItemDecoration.HORIZONTAL)
            )
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }

    override fun onBranchListItemClick(philosopherBranch: PhilosophyBranch) {
        sharedViewModel.currentBranch = philosopherBranch
        findNavController().navigate(
            R.id.action_philosopherProfileFragment_to_philosophyBranchFragment
        )
    }

    override fun onFavouriteQuoteClick(quote: Quote) {
        if (quote.favourite) {
            sharedViewModel.favouriteQuoteList.add(quote)
        } else {
            sharedViewModel.favouriteQuoteList.remove(quote)
        }
    }

    private fun getPhilosopherImageResource(): Int {
        val imageName: String = "philosopher_${philosopher.lastNameLower}"
        return requireContext().resources.getIdentifier(
            imageName,
            "drawable",
            requireContext().packageName
        )
    }

    companion object {
        val TAG: String = "[PhilosopherScrollFragment]"
    }
}