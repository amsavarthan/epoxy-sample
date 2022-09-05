package com.amsavarthan.sample.epoxy.ui

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.amsavarthan.sample.epoxy.R
import com.amsavarthan.sample.epoxy.databinding.FragmentHomeBinding
import com.amsavarthan.sample.epoxy.epoxy.HomeController
import com.amsavarthan.sample.epoxy.util.Data

class HomeFragment : Fragment(R.layout.fragment_home), HomeController.AdapterCallback {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val binding = FragmentHomeBinding.bind(view)

        val controller = HomeController(this)
        binding.epoxyRecyclerView.setController(controller)

        controller.allMessages = Data.messages
        controller.recentlyActive = Data.recentlyActive
    }

    override fun onItemClicked() {
        Toast.makeText(requireContext(), "Item Clicked", Toast.LENGTH_SHORT).show()
    }

    override fun goToMoreFragment() {
        findNavController().navigate(R.id.action_homeFragment_to_moreFragment)
    }

}