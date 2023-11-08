package com.example.hw8_3mon.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.navigation.fragment.findNavController
import com.example.hw8_3mon.R
import com.example.hw8_3mon.databinding.FragmentMainBinding
import com.example.hw8_3mon.ui.model.Series
import com.example.hw8_3mon.ui.adapter.SeriesAdapter

class MainFragment : Fragment() {

    private lateinit var binding: FragmentMainBinding

    private val seriesList = arrayListOf(
        Series(
            "https://www.google.com/url?sa=i&url=https%3A%2F%2Fpixabay.com%2Fillustrations%2Frick-sanchez-rick-and-morty-cartoon-7426878%2F&psig=AOvVaw3bWrzE-XfsVk_0M2IyWQh_&ust=1699284201804000&source=images&cd=vfe&opi=89978449&ved=0CBEQjRxqFwoTCODc2YuVrYIDFQAAAAAdAAAAABAE",
            "Alive",
            "Rick Sanchez"
        ),
        Series(
            "https://www.google.com/url?sa=i&url=https%3A%2F%2Fwall.alphacoders.com%2Ftag%2F4k-morty-smith-wallpapers&psig=AOvVaw1RlYdOsDkmYjNsl3aoKM57&ust=1699284387023000&source=images&cd=vfe&ved=0CBEQjRxqFwoTCPjnmOSVrYIDFQAAAAAdAAAAABAE",
            "Alive",
            "Morty Smith"
        ),
        Series(
            "https://www.google.com/url?sa=i&url=https%3A%2F%2Fwww.etsy.com%2Flisting%2F1434188339%2Frick-and-morty-digital-paint-albert&psig=AOvVaw3iWmzmpccq33RMB9sDiffC&ust=1699284417195000&source=images&cd=vfe&ved=0CBEQjRxqFwoTCNj2svKVrYIDFQAAAAAdAAAAABAE",
            "Dead",
            "Albert Einstein"
        ),
        Series(
            "https://i.pinimg.com/564x/79/0a/5a/790a5a50d01857ee1bbe2039f3f1a0db.jpg",
            "Alive",
            "Jerry Smith"
        )
    )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMainBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initAdapter()
    }

    private fun initAdapter() {
        val adapter = SeriesAdapter(seriesList, this::onClick)
        binding.rvPoster.adapter = adapter
    }

    private fun onClick(model: Series) {
        findNavController().navigate(R.id.firstFragment, bundleOf("start" to model))
    }
}