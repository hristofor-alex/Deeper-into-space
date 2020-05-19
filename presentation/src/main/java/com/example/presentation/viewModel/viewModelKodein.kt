package com.example.presentation.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.presentation.ListViewModel
import org.kodein.di.Kodein
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.provider
import org.kodein.di.generic.singleton

val viewModelModule = Kodein.Module(name = "viewModelModule") {

    bind<ListViewModel>() with provider {
        ListViewModel(instance())
    }

}