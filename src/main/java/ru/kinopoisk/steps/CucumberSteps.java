package ru.kinopoisk.steps;


import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class CucumberSteps {

    MainPageSteps mainPageSteps = new MainPageSteps();
    FilterPageSteps filterPageSteps = new FilterPageSteps();

    //шаги MainPage:

    @When("^Нажата кнопка - Войти")
    public void goToLogIn(){
        mainPageSteps.goToLogIn();
    }

    @When("^Выбран пункт - У меня уже есть аккаунт")
    public void pressAllreadyHaveAccount(){
        mainPageSteps.pressAllreadyHaveAccount();
    }

    @When("^Нажата кнопка - Яндекс")
    public void pressYaButton(){
        mainPageSteps.pressYaButton();
    }

    @When("^Переход на всплывающее окно авторизации")
    public void switchToLogInWindow(){
        mainPageSteps.switchToLogInWindow();
    }

    @When("^Заполняется поле \"(.*)\" значением \"(.*)\"$")
    public void fillField(String fieldName,String value){
        mainPageSteps.fillField(fieldName,value);
    }

    @When("^В окне авторизации нажата кнопка - Войти")
    public void pressLogInFrame(){
        mainPageSteps.pressLogInFrame();
    }

    @When("^Курсор перемещен на кнопку \"(.*)\"$")
    public void moveToMenu(String menuItem){
        mainPageSteps.moveToMenu(menuItem);
    }

    @When("^Выбран пункт \"(.*)\"$")
    public void moveToSubMenu(String menuItem){
        mainPageSteps.selectSubMenuItem(menuItem);
    }

    @Then("^Проверка корректности входа по имени аккаунта")
    public void checkUsernameAfterLogIn(){
        mainPageSteps.checkUsernameAfterLogIn();
    }



    @When("Нажата кнопка Выйти")
    public void presslogOut(){
        mainPageSteps.presslogOut();
    }

    @Then("Проверка наличия кнопки Войти после выхода из профиля")
    public void checkLogInButtonAfterLogOut(){
        mainPageSteps.checkLogInButtonAfterLogOut();
    }


    //шаги FilterPage:

    @When("^Выбран жанр \"(.*)\"$")
    public void selectGenreList(String menuItem){
        filterPageSteps.selectGenreList(menuItem);
    }

    @When("^Выбрана страна \"(.*)\"$")
    public void selectCountryList(String menuItem){
        filterPageSteps.selectCountryList(menuItem);
    }

    @When("^В интервале от \"(.*)\" до \"(.*)\" года$")
    public void selectYears(String from, String to){
        filterPageSteps.selectYears(from, to);
    }

    @When("^Рейтинг от \"(.*)\"$")
    public void setRatingMin(String menuItem){
        filterPageSteps.setRatingMin(menuItem);
    }
    @When("^Рейтинг IMDb от \"(.*)\"$")
    public void setRatingImdb(String menuItem){
        filterPageSteps.setRatingImdb(menuItem);
    }
    @When("^Рейтинг кинокритиков от \"(.*)\"$")
    public void setTomatRating(String menuItem){
        filterPageSteps.setTomatRating(menuItem);
    }
    @When("^Рейтинг положительных рецензий от \"(.*)\"$")
    public void setPositiveRatingMin(String menuItem){
        filterPageSteps.setPositiveRatingMin(menuItem);
    }
    @When("^Рейтинг положительных рецензий до \"(.*)\"$")
    public void setPositiveRatingMax(String menuItem){
        filterPageSteps.setPositiveRatingMax(menuItem);
    }

    @When("^Минимальное количество оценок (\\d+)")
    public void setSliderPosition(Integer value){
        filterPageSteps.setSliderPosition(value);
    }


    @When("^Возраст \"(.*)\"$")
    public void selectRestriction(String menuItem){
        filterPageSteps.selectRestriction(menuItem);
    }

    @When("^Бюджет от \"(.*)\"$")
    public void selectBudgetMin(String menuItem){
        filterPageSteps.selectBudgetMin(menuItem);
    }

    @When("^Бюджет до \"(.*)\"$")
    public void selectBudgetMax(String menuItem){
        filterPageSteps.selectBudgetMax(menuItem);
    }

    @When("^Кассовые сборы от \"(.*)\"$")
    public void selectBoxOfficeMin(String menuItem){
        filterPageSteps.selectBoxOfficeMin(menuItem);
    }

    @When("^Кассовые сборы до \"(.*)\"$")
    public void selectBoxOfficeMax(String menuItem){
        filterPageSteps.selectBoxOfficeMax(menuItem);
    }
}
