package com.mihamlinaric.porakolokvij

import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.github.mikephil.charting.components.Legend
import com.github.mikephil.charting.data.PieData
import com.github.mikephil.charting.data.PieDataSet
import com.github.mikephil.charting.data.PieEntry
import com.github.mikephil.charting.utils.ColorTemplate
import com.mihamlinaric.porakolokvij.databinding.FragmentPieChartBinding


class PieChartFragment : Fragment() {

    private var _binding: FragmentPieChartBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentPieChartBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // get pieChart
        val pieChart = binding.pieChart

        // add style to PieChart
        pieChart.isDrawHoleEnabled = true
        pieChart.holeRadius = 42f
        pieChart.setHoleColor(Color.GRAY)

        pieChart.transparentCircleRadius = 52f
        pieChart.setTransparentCircleColor(Color.WHITE)
        pieChart.setTransparentCircleAlpha(100)

        pieChart.setEntryLabelColor(Color.WHITE)
        pieChart.setEntryLabelTextSize(20f)

        val legend = pieChart.legend
        legend.isEnabled = true
        legend.verticalAlignment = Legend.LegendVerticalAlignment.TOP
        legend.horizontalAlignment = Legend.LegendHorizontalAlignment.RIGHT
        legend.orientation = Legend.LegendOrientation.VERTICAL
        legend.textSize = 16f

        val description = pieChart.description
        description.isEnabled = true
        description.text = "Car Crashes Distribution"
        description.textSize = 16f
        description.setPosition(500f, 60f)

        // setup PieDataSet
        val entries = ArrayList<PieEntry>()
        entries.add(PieEntry(25f, "Summer"))
        entries.add(PieEntry(10f, "Spring"))
        entries.add(PieEntry(20f, "Fall"))
        entries.add(PieEntry(45f, "Winter"))

        val pieDataSet = PieDataSet(entries, "Car Crashes")

        // style PieDataSet
        pieDataSet.colors = ColorTemplate.MATERIAL_COLORS.asList()
        pieDataSet.setDrawValues(false)

        // set data of chart
        pieChart.data = PieData(pieDataSet)

        // refresh and apply changes
        pieChart.invalidate()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}