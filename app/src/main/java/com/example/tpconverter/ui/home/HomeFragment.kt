package com.example.tpconverter.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.tpconverter.R
import com.example.tpconverter.adapter.RateAdapter
import com.example.tpconverter.databinding.FragmentHomeBinding
import com.example.tpconverter.model.Rate

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val homeViewModel =
            ViewModelProvider(this).get(HomeViewModel::class.java)

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root

        displayRates()

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun getRates(): MutableList<Rate> {
        val list = mutableListOf<Rate>()
        for (i in 1..50) {
            list.add(Rate(1, "EUR", "Euro", 1.0, "eur"))
            list.add(Rate(2, "USD", "United States Dollar", 1.1, "usd"))
        }
        return list
    }

    private fun displayRates() {
        val rateList: RecyclerView = binding.rateRecyclerView
        val rates = getRates()
        val adapter = RateAdapter(requireContext(), rates)
        rateList.adapter = adapter
        rateList.layoutManager = LinearLayoutManager(requireContext())

    }
}