package com.mihamlinaric.porakolokvij

import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.github.mikephil.charting.components.Legend
import com.github.mikephil.charting.components.XAxis
import com.github.mikephil.charting.components.YAxis
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

        // add style to barChart
        barChart.setMaxVisibleValueCount(5) // if more then 10 entries are displayed, no values will be drawn
        barChart.setDrawBarShadow(false)
        barChart.setDrawValueAboveBar(true)

        val xAxis = barChart.xAxis
        xAxis.position = XAxis.XAxisPosition.BOTTOM
        xAxis.textSize = 12f
        xAxis.setDrawGridLines(false)
        xAxis.valueFormatter = IndexAxisValueFormatter(listOf("Summer", "Spring", "Fall", "Winter"))
        xAxis.granularity = 1f // controls interval between axis values

        val leftAxis = barChart.axisLeft
        leftAxis.setPosition(YAxis.YAxisLabelPosition.OUTSIDE_CHART)
        leftAxis.textSize = 10f
        leftAxis.setDrawGridLines(false)
        leftAxis.axisMinimum = 0f
        leftAxis.axisMaximum = 2200f
        leftAxis.labelCount = 5

        val rightAxis = barChart.axisRight
        rightAxis.isEnabled = false

        val legend = barChart.legend
        legend.isEnabled = true
        legend.orientation = Legend.LegendOrientation.HORIZONTAL

        val description = barChart.description
        description.isEnabled = false

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


        // refresh and apply changes
        barChart.invalidate()
    }



    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}