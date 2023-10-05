package com.example.carapp.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.findNavController
import com.example.carapp.databinding.CarFragmentBinding
import com.example.carapp.model.CarViewModel

class CarFragment : Fragment() {

    private var binding: CarFragmentBinding? = null
    private val viewModel: CarViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = CarFragmentBinding.inflate(inflater, container, false)
        binding!!.viewModel = viewModel
        return binding!!.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding?.apply {
            backToDashboardCarBtn.setOnClickListener {
                val action = CarFragmentDirections.actionBackToDashboard()
                view.findNavController().navigate(action)
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}