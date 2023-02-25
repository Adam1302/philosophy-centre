package com.example.philosophycentre

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.philosophycentre.databinding.FragmentMainMenuBinding
import com.example.philosophycentre.model.PhilosophyViewModel

class MainMenuFragment : Fragment() {
    private var binding: FragmentMainMenuBinding? = null
    private val sharedViewModel: PhilosophyViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val fragmentBinding = FragmentMainMenuBinding.inflate(inflater, container, false)
        binding = fragmentBinding
        return fragmentBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding?.menuButtonQuoteScroller?.setOnClickListener {
            findNavController().navigate(R.id.action_mainMenuFragment_to_quoteScrollFragment)
        }
        binding?.menuButtonPhilosophicalBranches?.setOnClickListener {
            findNavController().navigate(R.id.action_mainMenuFragment_to_branchScrollFragment)
        }
        binding?.menuButtonPhilosophers?.setOnClickListener {
            findNavController().navigate(R.id.action_mainMenuFragment_to_philosopherScrollFragment)
        }

        binding?.apply {
            lifecycleOwner = viewLifecycleOwner
            mainMenuFragment = this@MainMenuFragment
            viewModel = sharedViewModel
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}