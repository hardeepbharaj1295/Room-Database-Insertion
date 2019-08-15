package com.daemonvision.roompractice1.add

import android.app.Application
import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class AddViewModelFactory(private val context: Context) : ViewModelProvider.Factory{
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(AddViewModel::class.java))
        {
            return AddViewModel(context) as T
        }
        throw IllegalArgumentException("Unknown View Model Class")
    }
}