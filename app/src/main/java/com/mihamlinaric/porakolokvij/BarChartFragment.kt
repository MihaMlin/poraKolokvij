package com.mihamlinaric.porakolokvij

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.github.mikephil.charting.components.XAxis
import com.github.mikephil.charting.data.BarData
import com.github.mikephil.charting.data.BarDataSet
import com.github.mikephil.charting.data.BarEntry
import com.github.mikephil.charting.formatter.IndexAxisValueFormatter
import com.github.mikephil.charting.utils.ColorTemplate
import com.mihamlinaric.porakolokvij.databinding.FragmentBarChartBinding


class BarChartFragment : Fragment() {

    private var _binding: FragmentBarChartBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentBarChartBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // get barChart
        val barChart = binding.barChart

        // setup chart entries
        val entries = ArrayList<BarEntry>()
        entries.add(BarEntry(0f, 1100f))  // Summer
        entries.add(BarEntry(1f, 550f))   // Spring
        entries.add(BarEntry(2f, 800f))   // Fall
        entries.add(BarEntry(3f, 2000f))  // Winter

        // create BarDataSet with entries
        val barDataSet = BarDataSet(entries, "Car Crashes")
        barDataSet.colors = ColorTemplate.MATERIAL_COLORS.toList()
        barDataSet.valueTextSize = 18f

        // create and set BarData
        val barData = BarData(barDataSet)
        barChart.data = barData

        // customize the appearance of the chart
        barChart.legend.isEnabled = true
        barChart.description.isEnabled = false
        barChart.axisRight.isEnabled = false

        val yAxis = barChart.axisLeft
        yAxis.axisMinimum = 0f
        yAxis.axisMaximum = 2200f

        val xAxis = barChart.xAxis
        xAxis.position = XAxis.XAxisPosition.BOTTOM
        xAxis.valueFormatter = IndexAxisValueFormatter(listOf("Summer", "Spring", "Fall", "Winter"))
        xAxis.granularity = 1f


        // refresh and apply changes
        barChart.invalidate()
    }



    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}