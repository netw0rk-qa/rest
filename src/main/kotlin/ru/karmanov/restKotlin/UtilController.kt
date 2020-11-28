package ru.karmanov.restKotlin

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import java.time.DayOfWeek
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.util.*

@RestController
class UtilController {
    @GetMapping("/dayofweek")
    fun getDayOfWeek(@RequestParam(value = "date", defaultValue = "") text: String?): ResponseEntity <*> {
        // Проверяю формат входных данных и если не соотв., то будем считать, что запрос по текущей дате
        val regex:Regex = Regex("""\d{4}-\d{2}-\d{2}""")
        val charSeq:CharSequence? = text
        val parseDate = if (regex.matches( charSeq!!)) text else LocalDate.now().toString()

        // Получаю экземпляр LocalDate либо с текущей датой, либо с датой из запроса
        val date:LocalDate = LocalDate.parse(parseDate)

        // Формат даты ответа
        val formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd")
        return ResponseEntity.ok(
                DayOfWeekResponse(
                        date = date.format(formatter),
                        dayOfWeek = Util(date).getName()
                )
        )
    }
}

// Класс для ответа
data class DayOfWeekResponse(
        val date: String?,
        val dayOfWeek: String?
)
