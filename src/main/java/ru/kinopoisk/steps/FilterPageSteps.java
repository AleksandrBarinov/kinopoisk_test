package ru.kinopoisk.steps;

import ru.kinopoisk.hooks.Hooks;
import ru.kinopoisk.pages.FilterPage;
import ru.yandex.qatools.allure.annotations.Step;

public class FilterPageSteps {

    FilterPage filterPage = new FilterPage(Hooks.driver);

    @Step("Выбран жанр {0}")
    public void selectGenreList(String menuItem){
        filterPage.selectGenreList(menuItem);
    }
    @Step("Выбрана страна {0}")
    public void selectCountryList(String menuItem){
        filterPage.selectCountryList(menuItem);
    }
    @Step("В интервале от {0} до {1} года")
    public void selectYears(String from, String to){
        filterPage.selectYears(from, to);
    }

    @Step("Рейтинг от {0}")
    public void setRatingMin(String menuItem){
        filterPage.setRatingMin(menuItem);
    }
    @Step("Рейтинг IMDb от {0}")
    public void setRatingImdb(String menuItem){
        filterPage.setRatingImdb(menuItem);
    }
    @Step("Рейтинг кинокритиков от {0}")
    public void setTomatRating(String menuItem){
        filterPage.setTomatRating(menuItem);
    }
    @Step("Рейтинг положительных рецензий от {0}")
    public void setPositiveRatingMin(String menuItem){
        filterPage.setPositiveRatingMin(menuItem);
    }
    @Step("Рейтинг положительных рецензий до {0}")
    public void setPositiveRatingMax(String menuItem){
        filterPage.setPositiveRatingMax(menuItem);
    }


    @Step("Минимальное количество оценок {0}")
    public void setSliderPosition(String menuItem){
        filterPage.setSliderPosition(menuItem);
    }


    @Step("Возраст {0}")
    public void selectRestriction(String value){
        filterPage.selectRestriction(value);
    }
    @Step("Бюджет от {0}")
    public void selectBudgetMin(String value){
        filterPage.selectBudgetMin(value);
    }
    @Step("Бюджет до {0}")
    public void selectBudgetMax(String value){
        filterPage.selectBudgetMax(value);
    }
    @Step("Кассовые сборы от {0}")
    public void selectBoxOfficeMin(String value){
        filterPage.selectBoxOfficeMin(value);
    }
    @Step("Кассовые сборы до {0}")
    public void selectBoxOfficeMax(String value){
        filterPage.selectBoxOfficeMax(value);
    }
}
