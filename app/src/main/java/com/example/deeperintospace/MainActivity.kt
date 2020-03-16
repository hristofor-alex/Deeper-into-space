package com.example.deeperintospace

import android.app.Activity
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.deeperintospace.weatherRepository.WeatherRepository
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.FlowPreview
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.KodeinContext
import org.kodein.di.android.kodein
import org.kodein.di.generic.instance
import org.kodein.di.generic.kcontext


class MainActivity : AppCompatActivity(), KodeinAware {
    override val kodeinContext: KodeinContext<Activity> = kcontext(this)
    override val kodein: Kodein by kodein()

    @FlowPreview
    @ExperimentalCoroutinesApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        kodeinTrigger?.trigger()

        val repository: WeatherRepository by instance()

        println()
    }
}
