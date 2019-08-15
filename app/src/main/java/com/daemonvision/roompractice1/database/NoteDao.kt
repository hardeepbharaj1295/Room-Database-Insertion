package com.daemonvision.roompractice1.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface NoteDao {

    @Insert
    suspend fun insert(note: Note)

    @Query("SELECT * FROM note_table ORDER BY ID DESC")
    fun getAllNote(): LiveData<List<Note>>

    @Query("DELETE FROM note_table WHERE id = :key")
    fun deleteNote(key: Int)

    @Query("SELECT * FROM note_table ORDER BY id DESC LIMIT 1")
    fun getNote(): Note?

}