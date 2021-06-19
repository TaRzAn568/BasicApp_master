package com.example.basicapp

import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListAdapter
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_note_lsit.*
import kotlinx.coroutines.NonCancellable

class NoteLsitActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_note_lsit)
        setSupportActionBar(findViewById(R.id.toolbar))

        findViewById<FloatingActionButton>(R.id.fab).setOnClickListener {
            val intent : Intent = Intent(this, MainActivity::class.java)
            startActivity(intent);
        }

        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1,
                        DataManager.notes)
        listNote.adapter = adapter

        listNote.setOnItemClickListener{ parent, view, position, id ->
            val intent = Intent(this, MainActivity::class.java)
            intent.putExtra("NOTE_POSITION", position);
            startActivity(intent);
        }

    }
}