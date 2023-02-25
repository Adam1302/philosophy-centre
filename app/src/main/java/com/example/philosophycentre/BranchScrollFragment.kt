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
import com.example.philosophycentre.databinding.FragmentBranchScrollBinding
import com.example.philosophycentre.databinding.FragmentPhilosopherScrollBinding
import com.example.philosophycentre.model.*

class BranchScrollFragment : Fragment(), BranchListClickListener {
    private var binding: FragmentBranchScrollBinding? = null
    private var isLinearLayoutManager = true
    private val sharedViewModel: PhilosophyViewModel by activityViewModels()
    private lateinit var recyclerView: RecyclerView
    private lateinit var branchListClickListener: BranchListClickListener

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val fragmentBinding = FragmentBranchScrollBinding.inflate(inflater, container, false)
        binding = fragmentBinding
        branchListClickListener = this

        return fragmentBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding?.apply {
            lifecycleOwner = viewLifecycleOwner
            branchScrollFragment = this@BranchScrollFragment
            viewModel = sharedViewModel
        }

        recyclerView = binding!!.recyclerView
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        recyclerView.adapter = BranchScrollAdapter(
            requireContext(),
            sharedViewModel.branchList,
            branchListClickListener
        )

        recyclerView.addItemDecoration(
            DividerItemDecoration(context, DividerItemDecoration.VERTICAL)
        )
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }

    override fun onBranchListItemClick(philosopherBranch: PhilosophyBranch) {
        sharedViewModel.currentBranch = philosopherBranch
        findNavController().navigate(
            R.id.action_branchScrollFragment_to_philosophyBranchFragment
        )
    }

    companion object {
        val TAG: String = "[BranchScrollFragment]"
    }
}