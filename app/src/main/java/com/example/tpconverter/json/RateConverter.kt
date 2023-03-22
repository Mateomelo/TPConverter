package com.example.tpconverter.json

import ApiRateList
import android.util.Log
import androidx.core.content.ContentProviderCompat.requireContext
import com.fasterxml.jackson.module.kotlin.jsonMapper
import com.fasterxml.jackson.module.kotlin.kotlinModule
import fr.cs2i.rateconverterkt.io.IoUtil

object RateConverter {
    fun convertRates(data: String) {


        val objectMapper = jsonMapper {
            addModule(kotlinModule())
        }
        val result: ApiRateList = objectMapper.readValue(
            data,
            ApiRateList::class.java
        )
        Log.d("Conv : ", "Result: $result")

    }
}