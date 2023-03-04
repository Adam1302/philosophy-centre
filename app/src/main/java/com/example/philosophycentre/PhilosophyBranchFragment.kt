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
import com.example.philosophycentre.databinding.FragmentPhilosophyBranchBinding
import com.example.philosophycentre.model.*

class PhilosophyBranchFragment : Fragment(), PhilosopherListClickListener {
    private var binding: FragmentPhilosophyBranchBinding? = null
    private val sharedViewModel: PhilosophyViewModel by activityViewModels()
    private lateinit var recyclerView: RecyclerView
    private lateinit var philosophyBranch: PhilosophyBranch
    private lateinit var philosopherListClickListener: PhilosopherListClickListener

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val fragmentBinding = FragmentPhilosophyBranchBinding.inflate(inflater, container, false)
        binding = fragmentBinding

        philosopherListClickListener = this

        return fragmentBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        philosophyBranch = sharedViewModel.currentBranch!!

        binding?.apply {
            lifecycleOwner = viewLifecycleOwner
            philosophyBranchFragment = this@PhilosophyBranchFragment
            viewModel = sharedViewModel
            branchPicture.setImageResource(getBranchImageResource())
            branchName.text = philosophyBranch.name
            branchInterested.text = android.text.TextUtils.join(
                ", ",
                philosophyBranch.interestedPhilosophers.map { philosopher -> philosopher.name }
            )
            branchDescription.text = philosophyBranch.branchDescription
        }

        recyclerView = binding!!.recyclerView

        recyclerView.apply {
            layoutManager = LinearLayoutManager(
                requireContext(),
                LinearLayoutManager.HORIZONTAL,
                false
            )
            adapter =PhilosopherScrollAdapter(
                requireContext(),
                philosophyBranch.interestedPhilosophers,
                philosopherListClickListener,
                true
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

    override fun onPhilosopherListItemClick(philosopher: Philosopher) {
        sharedViewModel.currentPhilosopher = philosopher
        findNavController().navigate(
            R.id.action_philosophyBranchFragment_to_philosopherProfileFragment
        )
    }

    private fun getBranchImageResource(): Int {
        val imageName: String = "logo_${philosophyBranch.branchNameAsLower}"
        return requireContext().resources.getIdentifier(
            imageName,
            "drawable",
            requireContext().packageName
        )
    }

    companion object {
        val TAG: String = "[PhilosopherBranchFragment]"
    }
}