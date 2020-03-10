package com.example.deeperintospace

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import com.example.deeperintospace.weatherRepository.WeatherRepository
import com.example.networkmodule.retrofit.RetrofitWeather

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
     val net = RetrofitWeather()
        net.weathersData.observe(this, Observer {

        })
        net.getWeather()
    }
}
