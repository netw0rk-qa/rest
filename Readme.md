### Тестовое задание
Написать rest-сервис с одной get ручкой, 
который на вход принимает дату в формате YYYY-MM-DD, а на выход отдаёт, 
какой это день недели (понедельник, вторник...).

#### Использовал
Spring Framework

#### Описание
Запросы принимаются на ручку /dayofweek с GET-параметром date в формате YYYY-MM-DD

В ответ возвращается JSON с date и dayOfWeek

```json
{
    "date": String,
    "dayOfWeek": String
}
```

#### Запуск
gradle bootRun

#### Пример запроса/ответа
http://127.0.0.1:8080/dayofweek/?date=2000-01-01

```json
{
    "date": "2000-01-01",
    "dayOfWeek": "Суббота"
}
```
