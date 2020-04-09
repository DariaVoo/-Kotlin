package lab6

import java.time.LocalDate

data class Grades(val date: LocalDate, val subject: String, val grades: MutableList<String>)