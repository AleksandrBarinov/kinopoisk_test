#language: ru
@login

Функционал: Поиск фильмов по критериям в Кинопоиске

    Структура сценария:

      Когда Курсор перемещен на кнопку "<меню>"
      Когда Выбран пункт "<пункт>"
      Когда Выбран жанр "<жанр>"
      Когда Выбрана страна "<страна>"
      Когда В интервале от "<год от>" до "<год до>" года

      Когда Рейтинг от "<рейтинг>"
      Когда Рейтинг IMDb от "<IMDb>"
      Когда Рейтинг кинокритиков от "<кинокритиков>"

      Когда Рейтинг положительных рецензий до "<пол. рец. до>"
      Когда Рейтинг положительных рецензий от "<пол. рец. от>"

      Когда Минимальное количество оценок "<мин. кол. оценок>"

      Когда Возраст "<возраст>"
      Когда Бюджет от "<бюджет от>"
      Когда Бюджет до "<бюджет до>"
      Когда Кассовые сборы от "<сборы>"

      Примеры:

  |  меню  |         пункт      |  жанр  |страна|год от|год до|рейтинг|IMDb|кинокритиков|пол. рец. до|пол. рец. от|мин. кол. оценок|возраст|бюджет от|бюджет до|сборы|
  | Фильмы |Навигатор по фильмам|ужасы   |США   |1998  |2000  |7      |7   |80          |95          |90          |2000            |12+    |50       |100      |25   |
  | Фильмы |Навигатор по фильмам|ужасы   |США   |1997  |2000  |4      |4   |67          |50          |90          |1200            |16+    |25       |200      |5    |
  | Фильмы |Навигатор по фильмам|ужасы   |США   |1998  |2000  |2      |4   |34          |95          |90          |2300            |18+    |10       |250      |10   |


