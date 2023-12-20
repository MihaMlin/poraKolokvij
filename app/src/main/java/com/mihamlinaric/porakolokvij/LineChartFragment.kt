package com.mihamlinaric.porakolokvij

import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.github.mikephil.charting.components.XAxis
import com.github.mikephil.charting.data.Entry
import com.github.mikephil.charting.data.LineData
import com.github.mikephil.charting.data.LineDataSet
import com.mihamlinaric.porakolokvij.databinding.FragmentLineChartBinding
import kotlin.math.sin

class LineChartFragment : Fragment() {

    private var _binding: FragmentLineChartBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentLineChartBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // get lineChart
        val lineChart = binding.lineChart

        // setup chart entries
        val entries = ArrayList<Entry>()
        for (i in 0..720) {
            val x = i.toFloat()
            val y = sin(Math.toRadians(i.toDouble())).toFloat()
            entries.add(Entry(x, y))
        }

        // create LineDataSet with entries
        val dataSet = LineDataSet(entries, "Sin Wave")
        dataSet.color = Color.BLUE

        // create and set LineData
        val lineData = LineData(dataSet)
        lineChart.data = lineData

        // style LineChart
        lineChart.description.isEnabled = false
        lineChart.axisRight.isEnabled = false

        val xAxis = lineChart.xAxis
        xAxis.position = XAxis.XAxisPosition.BOTTOM

        val yAxis = lineChart.axisLeft
        yAxis.axisMaximum = 1f
        yAxis.axisMinimum = -1f


        // refresh and apply changes
        lineChart.invalidate()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}