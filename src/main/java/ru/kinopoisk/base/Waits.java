package ru.kinopoisk.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.kinopoisk.hooks.Hooks;

public class Waits {

    public Wait<WebDriver> getWait() {
        return wait;
    }

    Wait<WebDriver> wait = new WebDriverWait(Hooks.driver, 15, 1000);

}
