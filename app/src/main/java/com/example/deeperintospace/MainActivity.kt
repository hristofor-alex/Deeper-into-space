package com.example.deeperintospace

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.deeperintospace.weatherRepository.WeatherRepository
import com.example.localdb.RoomWeather
import com.example.networkmodule.retrofit.RetrofitWeather
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.debounce
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    @FlowPreview
    @ExperimentalCoroutinesApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val weatherRepo = WeatherRepository.getInstance()
        GlobalScope.launch {
            weatherRepo.getWeatherFromLastTenDays().collect { weather ->

              weather.forEach{

                  Log.i("sosem", it.sol
                  )
              }

            }

        }

        
    }
}
