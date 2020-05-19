package com.example.presentation

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.domain.entity.Sol
import com.example.domain.usecase.GetWeatherForLastTenDays
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.android.closestKodein
import org.kodein.di.android.kodein


class ListViewModel(private val getWeatherFlow: GetWeatherForLastTenDays) : ViewModel(){
    val weather = MutableLiveData<List<Sol>>()

    private val scope = CoroutineScope(Dispatchers.IO)

    init {
        scope.launch {
            withContext(Dispatchers.Main) {
                getWeatherFlow.get().collect {
                    Log.d("QWEQWEQWEQWE", it.size.toString())
                    weather.value = it
                }
            }
        }
    }
}
