package com.blitzmachine.catfactsdemo.view

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.blitzmachine.catfactsdemo.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    private val binding: FragmentHomeBinding by lazy { FragmentHomeBinding.inflate(layoutInflater) }
    private val viewModel: ViewModel by activityViewModels()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View = binding.root
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.randomCatFact.observe(viewLifecycleOwner) {
            binding.testView.text = it.fact
        }

        viewModel.listOfCatFacts.observe(viewLifecycleOwner) {
            Log.d("Frags", it.toString())
        }

        binding.floatingActionButton.setOnClickListener {
            viewModel.getRandomCatFact()
            viewModel.getListOfCatFacts()
        }

    }
}