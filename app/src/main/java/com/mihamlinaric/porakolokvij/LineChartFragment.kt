package com.mihamlinaric.porakolokvij

import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.github.mikephil.charting.components.XAxis
import com.github.mikephil.charting.components.YAxis
import com.github.mikephil.charting.data.Entry
import com.github.mikephil.charting.data.LineData
import com.github.mikephil.charting.data.LineDataSet
import com.github.mikephil.charting.formatter.IndexAxisValueFormatter
import com.mihamlinaric.porakolokvij.databinding.FragmentLineChartBinding
import kotlin.math.cos
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

        // add style to LineChart
        val legend = lineChart.legend
        legend.isEnabled = true
        legend.textSize = 16f

        val description = lineChart.description
        description.isEnabled = false


        lineChart.axisRight.isEnabled = false

        val xAxis = lineChart.xAxis
        xAxis.position = XAxis.XAxisPosition.BOTTOM
        xAxis.setDrawGridLines(true)
        xAxis.gridLineWidth = 1f
        xAxis.granularity = 180f

        val leftAxis = lineChart.axisLeft
        leftAxis.setPosition(YAxis.YAxisLabelPosition.OUTSIDE_CHART)
        leftAxis.setDrawGridLines(true)
        leftAxis.gridLineWidth = 1.5f
        leftAxis.axisMaximum = 1.5f
        leftAxis.axisMinimum = -1.5f
        leftAxis.labelCount = 3
        leftAxis.granularity = 1f

        // create LineDataSet for sine wave
        val entriesSine = ArrayList<Entry>()
        for (i in 0..720) {
            val x = i.toFloat()
            val y = sin(Math.toRadians(i.toDouble())).toFloat()
            entriesSine.add(Entry(x, y))
        }

        // setup chart entries for cosine wave
        val entriesCosine = ArrayList<Entry>()
        for (i in 0..720) {
            val x = i.toFloat()
            val y = cos(Math.toRadians(i.toDouble())).toFloat()
            entriesCosine.add(Entry(x, y))
        }

        // create LineDataSet for sine wave
        val dataSetSine = LineDataSet(entriesSine, "Sine Wave")
        dataSetSine.color = Color.RED
        dataSetSine.setDrawCircles(false)
        dataSetSine.lineWidth = 3f

        // create LineDataSet for cosine wave
        val dataSetCosine = LineDataSet(entriesCosine, "Cosine Wave")
        dataSetCosine.color = Color.BLUE
        dataSetCosine.setDrawCircles(false)
        dataSetCosine.lineWidth = 3f

        // create and set LineData
        val lineData = LineData(dataSetSine, dataSetCosine)
        lineChart.data = lineData

        // refresh and apply changes
        lineChart.invalidate()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}