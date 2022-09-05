package com.amsavarthan.sample.epoxy.ui

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import com.amsavarthan.sample.epoxy.R
import com.amsavarthan.sample.epoxy.databinding.FragmentMoreBinding
import com.amsavarthan.sample.epoxy.epoxy.MoreController
import com.amsavarthan.sample.epoxy.util.Data

class MoreFragment : Fragment(R.layout.fragment_more), MoreController.AdapterCallback {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val binding = FragmentMoreBinding.bind(view)

        val controller = MoreController(this)
        binding.epoxyRecyclerView.layoutManager = GridLayoutManager(requireContext(), 2)
        binding.epoxyRecyclerView.setController(controller)

        controller.recentlyActive = Data.recentlyActive
    }

    override fun onItemClicked() {
        Toast.makeText(requireContext(), "Item Clicked", Toast.LENGTH_SHORT).show()
    }

}