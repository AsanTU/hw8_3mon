package com.example.hw8_3mon.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.example.hw8_3mon.R
import com.example.hw8_3mon.databinding.FragmentFirstBinding
import com.example.hw8_3mon.databinding.FragmentMainBinding
import com.example.hw8_3mon.ui.model.Series

class FirstFragment : Fragment() {

    lateinit var binding: FragmentFirstBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentFirstBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        arguments?.let {
            val model = it.getSerializable("start") as Series
            binding.tvName.text = model.name
            binding.tvStatus.text = model.status
            Glide.with(binding.imgPoster).load(model.img).into(binding.imgPoster)
        }
    }
}