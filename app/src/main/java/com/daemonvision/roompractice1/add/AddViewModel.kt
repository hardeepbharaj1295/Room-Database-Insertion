package com.daemonvision.roompractice1.add

import android.app.Application
import android.content.Context
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel
import com.daemonvision.roompractice1.NoteRepository
import com.daemonvision.roompractice1.database.Note
import com.daemonvision.roompractice1.database.NoteDatabase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

public class AddViewModel(context: Context): ViewModel() {

    private val repository: NoteRepository

    private var viewModel = Job()

    private val uiScope = CoroutineScope(Dispatchers.Main + viewModel)

    init {
        val noteDao = NoteDatabase.getInstance(context).noteDao()
        repository = NoteRepository(noteDao)
    }

    fun insert(note: Note)
    {
        Log.e("View Model","Started")
        uiScope.launch {
            repository.insert(note)
        }
    }
}