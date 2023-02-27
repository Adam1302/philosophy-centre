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
import com.example.philosophycentre.databinding.FragmentPhilosopherScrollBinding
import com.example.philosophycentre.model.Philosopher
import com.example.philosophycentre.model.PhilosopherListClickListener
import com.example.philosophycentre.model.PhilosophyViewModel

class PhilosopherScrollFragment : Fragment(), PhilosopherListClickListener {
    private var binding: FragmentPhilosopherScrollBinding? = null
    private var isLinearLayoutManager = true
    private val sharedViewModel: PhilosophyViewModel by activityViewModels()
    private lateinit var recyclerView: RecyclerView
    private lateinit var philosopherListClickListener: PhilosopherListClickListener

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val fragmentBinding = FragmentPhilosopherScrollBinding.inflate(inflater, container, false)
        binding = fragmentBinding

        philosopherListClickListener = this

        return fragmentBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding?.apply {
            lifecycleOwner = viewLifecycleOwner
            philosopherScrollFragment = this@PhilosopherScrollFragment
            viewModel = sharedViewModel
        }

        recyclerView = binding!!.recyclerView

        recyclerView.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = PhilosopherScrollAdapter(
                requireContext(),
                sharedViewModel.philosopherList,
                philosopherListClickListener
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

    override fun onPhilosopherListItemClick(philosopher: Philosopher) {
        sharedViewModel.currentPhilosopher = philosopher
        findNavController().navigate(
            R.id.action_philosopherScrollFragment_to_philosopherProfileFragment
        )
    }

    companion object {
        val TAG: String = "[PhilosopherScrollFragment]"
    }
}