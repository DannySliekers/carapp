package com.example.carapp.fragments

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.example.carapp.databinding.DashboardFragmentBinding


class DashboardFragment : Fragment() {
    private var _binding: DashboardFragmentBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = DashboardFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding?.apply {
            // Set up the button click listeners
            myReservationsBtn.setOnClickListener {
                val action = DashboardFragmentDirections.actionDashboardFragmentToReservationFragment()
                view.findNavController().navigate(action)
            }

            feedbackBtn.setOnClickListener {
                val action = DashboardFragmentDirections.actionDashboardFragmentToFeedbackFragment()
                view.findNavController().navigate(action)
            }

            myCarsBtn.setOnClickListener {
                val action = DashboardFragmentDirections.actionDashboardFragmentToCarFragment()
                view.findNavController().navigate(action)
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}   