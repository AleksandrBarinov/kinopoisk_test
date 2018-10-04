package ru.kinopoisk.steps;

import ru.kinopoisk.hooks.Hooks;
import ru.kinopoisk.pages.MainPage;
import ru.yandex.qatools.allure.annotations.Step;

public class MainPageSteps {

    MainPage mainPage = new MainPage(Hooks.driver);

    @Step("Нажата кнопка - Войти")
    public void goToLogIn(){
        mainPage.goToLogin();
    }

    @Step("Выбран пункт - У меня уже есть аккаунт")
    public void pressAllreadyHaveAccount(){
        mainPage.pressAllreadyHaveAccount();
    }

    @Step("Нажата кнопка - Яндекс")
    public void pressYaButton(){
        mainPage.pressYaButton();
    }

    @Step("Переход на всплывающее окно авторизации")
    public void switchToLogInWindow(){
        mainPage.switchToLogInWindow();
    }


    //логин или пароль:
    @Step("Заполняется поле {0} значением {1}")
    public void fillField(String fieldName, String value){
        mainPage.fillField(fieldName, value);
    }

    @Step("В окне авторизации нажата кнопка - Войти")
    public void pressLogInFrame(){
        mainPage.pressLogInFrame();
    }

    @Step("Курсор перемещен на кнопку {0}")
    public void moveToMenu(String menuItem){
        mainPage.moveToMenu(menuItem);
    }

    @Step("Выбран пункт {0}")
    public void selectSubMenuItem(String menuItem){
        mainPage.selectSubMenuItem(menuItem);
    }

    @Step("Проверка корректности входа по имени аккаунта")
    public void checkUsernameAfterLogIn(){
        mainPage.checkUsernameAfterLogIn();
    }


    @Step("Нажата кнопка Выйти")
    public void presslogOut(){
        mainPage.presslogOut();
    }

    @Step("Проверка наличия кнопки Войти после выхода из профиля")
    public void checkLogInButtonAfterLogOut(){
        mainPage.checkLogInButtonAfterLogOut();
    }
}
