package com.daemonvision.roompractice1

import android.util.Log
import androidx.annotation.WorkerThread
import com.daemonvision.roompractice1.database.Note
import com.daemonvision.roompractice1.database.NoteDao

class NoteRepository(private val noteDao: NoteDao) {

    @WorkerThread
    suspend fun insert(note: Note) {
        Log.e("Repository", "Started")
        noteDao.insert(note)
    }
}