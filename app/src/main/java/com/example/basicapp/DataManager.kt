package com.example.basicapp

object DataManager {
    val courses = HashMap<String, CourseInfo>()
    val notes = ArrayList<NoteInfo>();

    init {
        initializeCourses()
        initializeNotes()
    }


    private fun initializeCourses(){
        var course = CourseInfo("Android Intent", "Android programming with intent")
        courses.set(course.coursrId, course);

        course = CourseInfo("Android_async", "Android async programming and services")
        courses.set(course.coursrId, course);

        course = CourseInfo(title = "Java Fundamentals : The java lang",coursrId =  "Java Lang")
        courses.set(course.coursrId, course);
    }

    private fun initializeNotes(){
        var note =
            courses.get("Android Intent")?.let { NoteInfo(it,"Intent intro", "Here we start with intents") };
        if (note != null) {
            notes.add(note)
        }

         note =
            courses.get("Android Intent")?.let { NoteInfo(it,"Intent demo", "playing with intents") };
        if (note != null) {
            notes.add(note)
        }

        note =
            courses.get("Android_async")?.let { NoteInfo(it,"Android Async ", "Android_async notes") };
        if (note != null) {
            notes.add(note)
        }

        note =
            courses.get("Java Lang")?.let { NoteInfo(it,"Java", "Java Lang Notes") };
        if (note != null) {
            notes.add(note)
        }


    }

}