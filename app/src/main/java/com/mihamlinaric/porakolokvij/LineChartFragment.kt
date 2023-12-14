package com.mihamlinaric.porakolokvij

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.mihamlinaric.porakolokvij.databinding.FragmentLineChartBinding

class LineChartFragment : Fragment() {

    private var _binding: FragmentLineChartBinding? = null
    private val binding get() = _binding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentLineChartBinding.inflate(inflater, container, false)
        return binding!!.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        /*
        binding.buttonFirst.setOnClickListener {
            Timber.d(“Do some action here”);
        }
        */
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}