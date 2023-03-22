package com.example.tpconverter.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.tpconverter.databinding.FragmentHomeBinding
import com.example.tpconverter.json.RateConverter
import fr.cs2i.rateconverterkt.io.IoUtil

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


        RateConverter.convertRates(getRates())


        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


    private fun getRates(): String {
        return IoUtil.readTextFile(
            requireContext(),
            "data/rates.json"
        )
    }

    private fun getCurrencies(): String {
        return IoUtil.readTextFile(
            requireContext(),
            "data/currencies.json"
        )
    }
}