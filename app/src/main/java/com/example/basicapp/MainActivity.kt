package com.example.basicapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.ArrayAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    var position = -1
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(findViewById(R.id.mainActToolbar))

        val adapterCourses = ArrayAdapter<CourseInfo>(this, android.R.layout.simple_spinner_item,
            DataManager.courses.values.toList());
        adapterCourses.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        mainActivitySpinner.adapter = adapterCourses;

        position = intent.getIntExtra("NOTE_POSITION", -1)

        if(position != -1){
            displayNote(position);
        }

    }

    private fun displayNote(position:Int) {
        val note =  DataManager.notes.get(position)
        etText.setText(note.text)
        etTitle.setText(note.title)
        mainActivitySpinner.setSelection(DataManager.courses.values.indexOf(note.course))
    }

    @Override
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_activity_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when(item.itemId){
            R.id.menuItemSettings -> true
            R.id.menuItemNext -> {
                moveNext();
                true
            }
            else ->super.onOptionsItemSelected(item)
        }


    }

    private fun moveNext() {
        position++
        displayNote(position)
    }
}