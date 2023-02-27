package com.example.philosophycentre

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.example.philosophycentre.databinding.FragmentPhilosopherProfileBinding
import com.example.philosophycentre.databinding.FragmentPhilosophyBranchBinding
import com.example.philosophycentre.model.Philosopher
import com.example.philosophycentre.model.PhilosophyBranch
import com.example.philosophycentre.model.PhilosophyViewModel

class PhilosophyBranchFragment : Fragment() {
    private var binding: FragmentPhilosophyBranchBinding? = null
    private val sharedViewModel: PhilosophyViewModel by activityViewModels()
    private lateinit var philosophyBranch: PhilosophyBranch

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val fragmentBinding = FragmentPhilosophyBranchBinding.inflate(inflater, container, false)
        binding = fragmentBinding
        return fragmentBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        philosophyBranch = sharedViewModel.currentBranch!!

        binding?.apply {
            lifecycleOwner = viewLifecycleOwner
            philosophyBranchFragment = this@PhilosophyBranchFragment
            viewModel = sharedViewModel
            branchName.text = philosophyBranch.name
            branchInterested.text = android.text.TextUtils.join(
                ", ",
                philosophyBranch.interestedPhilosophers.map { philosopher -> philosopher.name }
            )
            branchDescription.text = philosophyBranch.branchDescription
        }
        /*
        recyclerView = binding!!.recyclerView
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        recyclerView.adapter = PhilosopherScrollAdapter(requireContext(), sharedViewModel.philosopherList)

        recyclerView.addItemDecoration(
            DividerItemDecoration(context, DividerItemDecoration.VERTICAL)
        )
         */
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }

    companion object {
        val TAG: String = "[PhilosopherBranchFragment]"
    }
}