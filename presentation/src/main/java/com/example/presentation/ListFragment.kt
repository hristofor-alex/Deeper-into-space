package com.example.presentation

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.android.x.kodein
import org.kodein.di.generic.instance


class ListFragment : Fragment(), KodeinAware {
    companion object {
        fun newInstance() = ListFragment()
    }

    override val kodein: Kodein by kodein()
    private val viewModeFactory: ViewModelProvider.Factory by instance<ViewModelProvider.Factory>()
    private val viewModel: ListViewModel by lazy {
        ViewModelProviders.of(this, viewModeFactory).get(ListViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.list_fragment, container, false)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewModel.weather.toString()
    }

}
