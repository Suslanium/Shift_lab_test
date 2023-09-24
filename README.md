# ShiftLabTest

ShiftLabTest - проект, сделанный в качестве тестового задания в рамках конкурса на ЦФТ ШИФТ Лаб.
**Проект создавался на Android Studio Hedgehog 2023.1.1 Beta 4, на более старых версиях проект может не собраться из-за версии Gradle.**

Основные задачи:
+ Реализовать экран регистрации с валидацией полей
+ Реализовать переход на главный экран при успешной регистрации
+ Реализовать главный экран с кнопкой, по нажатию которой появляется модальное окно с приветствием пользователя и указанием имени, введённого при регистрации

Выполненные необязательные задачи:
+ Реализован интерактивный выбор даты рождения
+ Реализованы уведомления о конкретных ошибках валидации в полях экрана регистрации
+ Кнопка регистрации реализована так, что её можно активировать только в случае заполненных без ошибок данных
+ Реализовано кеширование данных и сохранение сессии: после регистрации при повторных запусках приложения будет сразу открываться главный экран

# Использованные технологии

##### Стек технологий
+ [Kotlin](https://kotlinlang.org/)
+ [Kotlin Coroutines](https://developer.android.com/kotlin/coroutines)
+ [Kotlin Channels](https://kotlinlang.org/docs/channels.html)
+ [Koin](https://insert-koin.io/docs/quickstart/android-compose)
+ [Jetpack Navigation](https://developer.android.com/jetpack/compose/navigation)
+ [Google Accompanist](https://github.com/google/accompanist)
+ [Jetpack Security](https://developer.android.com/topic/security/data)
+ [State](https://developer.android.com/jetpack/compose/state)

##### Архитектура и паттерны
+ [Clean Architecture](https://developer.android.com/topic/architecture)
+ [MVVM](https://wikipedia.org/wiki/Model-View-ViewModel)

##### UI
+ [Jetpack Compose](https://developer.android.com/jetpack/compose)
+ [Material3](https://developer.android.com/jetpack/compose/designsystems/material3)
+ [Sheets Compose Dialogs (Calendar)](https://github.com/maxkeppeler/sheets-compose-dialogs#calendar)

# Скриншоты проекта

<p>
  <img src="https://github.com/Suslanium/Shift_lab_test/assets/84632927/39551e15-6019-46e3-9a0d-290a86192f74" width="250" height="540">
  <img src="https://github.com/Suslanium/Shift_lab_test/assets/84632927/f94ac9d5-2fe7-4f9b-8de9-97d5b52849ba" width="250" height="540">
  <img src="https://github.com/Suslanium/Shift_lab_test/assets/84632927/8c15604e-cdf4-4b86-be2c-29a821445263" width="250" height="540">
  <img src="https://github.com/Suslanium/Shift_lab_test/assets/84632927/2780fc1c-e002-4002-8968-26235dfffabc" width="250" height="540">
  <img src="https://github.com/Suslanium/Shift_lab_test/assets/84632927/ad848b1d-7104-4328-a43f-3b7842fb5c9a" width="250" height="540">
  <img src="https://github.com/Suslanium/Shift_lab_test/assets/84632927/cd8afb51-d8d9-45b0-ab3e-4803270bbc49" width="250" height="540">
</p>
