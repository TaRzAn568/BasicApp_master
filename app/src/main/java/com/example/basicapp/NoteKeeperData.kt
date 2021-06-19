package com.example.basicapp

data class CourseInfo (val coursrId:String,  val title: String) {
    override fun toString(): String {
        return coursrId;
    }
}

data class NoteInfo (var course: CourseInfo, var title:String, var text: String)

