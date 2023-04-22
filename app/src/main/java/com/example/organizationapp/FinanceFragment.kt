package com.example.organizationapp

import android.graphics.Color
import android.graphics.Typeface
import android.graphics.fonts.Font
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.core.content.res.ResourcesCompat
import androidx.core.content.res.TypedArrayUtils.getResourceId
import androidx.fragment.app.Fragment
import com.github.mikephil.charting.animation.Easing
import com.github.mikephil.charting.charts.Chart
import com.github.mikephil.charting.charts.PieChart
import com.github.mikephil.charting.data.PieData
import com.github.mikephil.charting.data.PieDataSet
import com.github.mikephil.charting.data.PieEntry
import com.github.mikephil.charting.formatter.PercentFormatter
import com.github.mikephil.charting.utils.MPPointF


class FinanceFragment : Fragment() {
    lateinit var chart: PieChart
    private val entries = listOf<PieEntry>(
        PieEntry(200f, "Food"),
        PieEntry(200f, "House,Transport"),
        PieEntry(300f, "Subscriptions"),
        PieEntry(100f, "Personal Care"),
        PieEntry(500f, "Entertainment"),
        PieEntry(100f, "Online"),
    )


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_finances_fragment, container, false)
        chart = view.findViewById(R.id.chart)

         val colors = listOf<Int>(
            ContextCompat.getColor(requireContext(), R.color.graph_purple),
            ContextCompat.getColor(requireContext(), R.color.graph_purple2),
            ContextCompat.getColor(requireContext(), R.color.graph_lilac),
            ContextCompat.getColor(requireContext(), R.color.graph_blue),
            ContextCompat.getColor(requireContext(), R.color.graph_green),
            ContextCompat.getColor(requireContext(), R.color.graph_green2),
        )

        val pieDataSet: PieDataSet = PieDataSet(entries, "January")
        pieDataSet.colors = colors

        val font = ResourcesCompat.getFont(requireContext(),R.font.comfortaa_font)
        pieDataSet.valueTypeface = font

        val pieData: PieData = PieData(pieDataSet)
        chart.data = pieData
        chart.holeRadius = 30f
        chart.transparentCircleRadius=35f
        chart.animateY(1400, Easing.EaseInOutQuad)
        pieDataSet.sliceSpace = 3f
        pieDataSet.selectionShift = 5f
        chart.setCenterTextTypeface(font)
        chart.centerText = "This month $1560"
        //Disable the text below the graph
        chart.legend.isEnabled = false
        chart.description.isEnabled = false
        pieData.setValueTextSize(20f)
        chart.setEntryLabelColor(Color.BLACK)
        chart.setEntryLabelTypeface(font)
        chart.setEntryLabelTextSize(10f)
        chart.invalidate()
        return view
    }

}