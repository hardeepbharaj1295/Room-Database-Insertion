package com.daemonvision.roompractice1.add

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.EditText
import android.widget.Toast
import androidx.lifecycle.ViewModelProviders
import com.daemonvision.roompractice1.R
import com.daemonvision.roompractice1.database.Note

class AddNewNoteActivity : AppCompatActivity() {

    private lateinit var noteViewModel: AddViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_new_note)

        val viewModelFactory = AddViewModelFactory(this@AddNewNoteActivity)

        noteViewModel = ViewModelProviders.of(this,viewModelFactory).get(AddViewModel::class.java)

    }

    public fun insert(view: View) {
        val title = findViewById<EditText>(R.id.title)
        val description = findViewById<EditText>(R.id.description)

        val note = Note(null, title.text.toString(), description.text.toString())
        noteViewModel.insert(note)
        Toast.makeText(this,"Inserted",Toast.LENGTH_SHORT).show()

    }

}
