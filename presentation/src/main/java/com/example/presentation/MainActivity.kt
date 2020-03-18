package com.example.presentation

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.Settings
import android.util.Log
import com.example.data.weatherRepository.WeatherRepository
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.KodeinTrigger
import org.kodein.di.android.kodein
import org.kodein.di.generic.instance

class MainActivity : AppCompatActivity() , KodeinAware{
    override val kodein: Kodein by kodein()
    override val kodeinTrigger = KodeinTrigger()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        kodeinTrigger.trigger()

        val repository  by instance<WeatherRepository>()
        GlobalScope.launch {
            repository.getWeatherFromLastTenDays().collect { weather ->
                weather.forEach {
                    Log.i("testPrint", it.sol)
                }
            }
        }

    }
}
