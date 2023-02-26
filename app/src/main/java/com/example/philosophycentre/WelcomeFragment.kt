package com.example.philosophycentre

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.philosophycentre.databinding.FragmentWelcomeBinding
import com.example.philosophycentre.dataclasses.philosopherList
import com.example.philosophycentre.dataclasses.philosophyBranchList
import com.example.philosophycentre.model.Philosopher
import com.example.philosophycentre.model.PhilosophyBranch
import com.example.philosophycentre.model.PhilosophyViewModel

class WelcomeFragment: Fragment() {
    private var binding: FragmentWelcomeBinding? = null
    private val sharedViewModel: PhilosophyViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val fragmentBinding = FragmentWelcomeBinding.inflate(inflater, container, false)
        binding = fragmentBinding
        return fragmentBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding?.enterButton?.setOnClickListener {
            findNavController().navigate(R.id.action_welcomeFragment_to_mainMenuFragment)
        }

        binding?.welcomeFragment = this

        for (branch in philosophyBranchList) {
            sharedViewModel.addPhilosophyBranch(branch, requireContext())
        }

        for (philosopher in philosopherList) {
            sharedViewModel.addPhilosopher(philosopher, requireContext())
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }

    companion object {
        val TAG: String = "WelcomeFragment"
    }
}
