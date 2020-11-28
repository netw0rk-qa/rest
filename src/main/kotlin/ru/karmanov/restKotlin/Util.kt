package ru.karmanov.restKotlin

import java.time.LocalDate

// Класс определения дня недели по дате LocalDate
class Util (date: LocalDate){
    private val dateOfWeek:String = date.dayOfWeek.toString()
    private val days = mapOf(
            "MONDAY" to "Понедельник",
            "TUESDAY" to "Вторник",
            "WEDNESDAY" to "Среда",
            "THURSDAY" to "Четверг",
            "FRIDAY" to "Пятница",
            "SATURDAY" to "Суббота",
            "SUNDAY" to "Воскресенье",
    )

    fun getName():String?{
        return days[dateOfWeek]
    }
}