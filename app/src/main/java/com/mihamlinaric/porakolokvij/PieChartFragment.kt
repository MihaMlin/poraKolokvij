package com.mihamlinaric.porakolokvij

import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.github.mikephil.charting.data.PieData
import com.github.mikephil.charting.data.PieDataSet
import com.github.mikephil.charting.data.PieEntry
import com.github.mikephil.charting.utils.ColorTemplate
import com.mihamlinaric.porakolokvij.databinding.FragmentPieChartBinding


class PieChartFragment : Fragment() {

    private var _binding: FragmentPieChartBinding? = null
    private val binding get() = _binding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentPieChartBinding.inflate(inflater, container, false)


        // get pieChart
        val pieChart = _binding!!.pieChart

        // setup chart entries
        val entries = ArrayList<PieEntry>()
        entries.add(PieEntry(25f, "Summer"))
        entries.add(PieEntry(10f, "Spring"))
        entries.add(PieEntry(20f, "Fall"))
        entries.add(PieEntry(45f, "Winter"))

        // create PieDataSet with entries
        val pieDataSet = PieDataSet(entries, "Car Crashes")
        pieDataSet.colors = ColorTemplate.MATERIAL_COLORS.asList()
        pieDataSet.setDrawValues(false)

        // create and set PieData
        val pieData = PieData(pieDataSet)
        pieChart.data = pieData

        // add style to PieChart
        pieChart.description.isEnabled = false
        pieChart.legend.isEnabled = true
        pieChart.setEntryLabelColor(Color.WHITE)
        pieChart.setEntryLabelTextSize(20f)

        // refresh and apply changes
        pieChart.invalidate()


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