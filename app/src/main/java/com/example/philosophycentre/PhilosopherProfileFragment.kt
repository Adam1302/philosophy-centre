package com.example.philosophycentre

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.philosophycentre.databinding.FragmentPhilosopherProfileBinding
import com.example.philosophycentre.databinding.FragmentPhilosopherScrollBinding
import com.example.philosophycentre.model.Philosopher
import com.example.philosophycentre.model.PhilosophyViewModel

class PhilosopherProfileFragment : Fragment() {
    private var binding: FragmentPhilosopherProfileBinding? = null
    private val sharedViewModel: PhilosophyViewModel by activityViewModels()
    private lateinit var philosopher: Philosopher

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val fragmentBinding = FragmentPhilosopherProfileBinding.inflate(inflater, container, false)
        binding = fragmentBinding
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
            philosopherDesc.text = philosopher.biography
            philosopherInterests.text = android.text.TextUtils.join(
                ", ",
                philosopher.interests.map { branch -> branch.name }
            )
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