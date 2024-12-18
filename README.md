# Проект "Виселица"

## Цель
Реализация игры **"Виселица"** на Java в процедурном стиле программирования с консольным интерфейсом.

---

## Правила игры

1. Пользователю загадывается случайное слово на русском языке в именительном падеже.
2. С каждым ходом игрок угадывает букву:
   - Если угаданная буква присутствует в загаданном слове, она открывается на соответствующих местах.
   - Если буква отсутствует, игроку начисляется одно очко на счет виселицы.
   - В случае, если игрок вводит уже использованную букву, ошибка не начисляется.
3. Игра продолжается до тех пор, пока игрок не угадает слово или не исчерпает все свои попытки, что приведет к завершению игры и "повешению" персонажа.
4. **Максимальное количество ошибок в одной партии:** 9.

---

## Функциональность приложения

- При запуске и после игры пользователю предлагаются функции меню (начать/закончить игру).
- В случае начала игры:
  - Загадывается случайное слово из словаря и отображается его маска.
  - Пользователю предложено ввести букву:
    - Если данная буква содержится в слове, маска обновляется.
    - Если буква не содержится, засчитывается ошибка и рисуется виселица.
    - Повторно используемая буква не влияет на результат.
- В случае завершения игры программа заканчивает свою работу.

---

## Примечание

- Ввод русской буквы не зависит от регистра.
- Добавление новых слов в словарь требует ввода русских слов любого регистра через строку.

