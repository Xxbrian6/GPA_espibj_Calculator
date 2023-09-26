package com.example.gpa_espibj_calculator
import kotlin.math.ceil

const val TOTAL_COURSES = 5

class GpaCalculator (grade1: Int , grade2: Int , grade3: Int , grade4: Int , grade5: Int){
    var grade1 = 0
        set(value) {
            field = if (value >= 0) value else 0
        }
    var grade2 = 0
        set(value) {
            field = if (value >= 0) value else 0
        }
    var grade3 = 0
        set(value) {
            field = if (value >= 0) value else 0
        }
    var grade4 = 0
        set(value) {
            field = if (value >= 0) value else 0
        }
    var grade5 = 0
        set(value) {
            field = if (value >= 0) value else 0
        }

    val totalGPA: Int
        get(){
            return ceil((grade1+grade2+grade3+grade4+grade5) /TOTAL_COURSES.toDouble()).toInt()
        }
    init {
        this.grade1 = grade1
        this.grade2 = grade2
        this.grade3 = grade3
        this.grade4 = grade4
        this.grade5 = grade5
    }
}