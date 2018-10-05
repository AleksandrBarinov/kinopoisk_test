package ru.kinopoisk.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import ru.kinopoisk.base.Waits;
import ru.kinopoisk.hooks.Hooks;

import java.util.ArrayList;

public class MainPage {

    public MainPage(WebDriver driver) {
        PageFactory.initElements(driver, this);

    }

    @FindBy(xpath = "//*[@class='header-fresh-user-partial-component__login-button']")
    WebElement logIn;

    @FindBy(xpath = "//*[text()='У меня есть аккаунт КиноПоиска']")
    WebElement allreadyHaveAccount;

    @FindBy(xpath = "//*[contains(@class,'auth__item_code_ya')]")
    WebElement yaButton;

    @FindBy(name = "login")
    WebElement loginFieldFrame;

    @FindBy(name = "passwd")
    WebElement passwdFieldFrame;

    @FindBy(xpath = "//*[text()='Войти']")
    WebElement logInFrame;

    @FindBy(xpath = "//*[@class='header-fresh-user-partial-component__button']")
    WebElement userIcon;

    @FindBy(xpath = "//*[@href='/logout/']")
    WebElement logOut;

    public String getUserNameRemembered() {
        return userNameRemembered;
    }

    public void setUserNameRemembered(String userNameRemembered) {
        this.userNameRemembered = userNameRemembered;
    }

    String userNameRemembered;

    Waits waits = new Waits();


    public void goToLogin(){
        waits.getWait().until(ExpectedConditions.visibilityOf(logIn));
        logIn.click();
    }

    public void pressAllreadyHaveAccount(){
        Hooks.driver.switchTo().frame("kp2-authapi-iframe");
        waits.getWait().until(ExpectedConditions.visibilityOf(allreadyHaveAccount));
        allreadyHaveAccount.click();
    }

    public void pressYaButton(){
        waits.getWait().until(ExpectedConditions.visibilityOf(yaButton));
        yaButton.click();
    }

    public void switchToLogInWindow() {
        ArrayList tabs2 = new ArrayList(Hooks.driver.getWindowHandles());
        Hooks.driver.switchTo().window((String) tabs2.get(1));
    }

    protected void fillField(WebElement element, String value){
        element.clear();
        element.sendKeys(value);
    }

    public void fillField(String fieldName, String value) {
        switch (fieldName) {
            case "логин":
                waits.getWait().until(ExpectedConditions.visibilityOf(loginFieldFrame));
                loginFieldFrame.click();
                fillField(loginFieldFrame, value);

                setUserNameRemembered(value);
                break;
            case "пароль":
                waits.getWait().until(ExpectedConditions.visibilityOf(passwdFieldFrame));
                passwdFieldFrame.click();
                fillField(passwdFieldFrame, value);
                break;
        }
    }

    public void pressLogInFrame(){
        logInFrame.click();

        ArrayList tabs2 = new ArrayList(Hooks.driver.getWindowHandles());
        Hooks.driver.switchTo().window((String) tabs2.get(0));

    }

    public void checkUsernameAfterLogIn(){

        String userNameRemembered = getUserNameRemembered();

        waits.getWait().until(ExpectedConditions.visibilityOf(userIcon));
        userIcon.click();

        String userNameActual = Hooks.driver.findElement(By.xpath("//*[contains(@href,'user')]/child::div")).getText();

        System.out.println(userNameActual + " equals ? " + userNameRemembered);

        Assert.assertEquals(userNameActual,userNameRemembered);

    }

    public void presslogOut(){

        ArrayList tabs2 = new ArrayList(Hooks.driver.getWindowHandles());
        Hooks.driver.switchTo().window((String) tabs2.get(0));

        waits.getWait().until
                (ExpectedConditions.visibilityOf(userIcon)).click();

        waits.getWait().until
                (ExpectedConditions.visibilityOf(logOut)).click();
    }

    public void checkLogInButtonAfterLogOut(){


        try {
            waits.getWait().until
                    (ExpectedConditions.visibilityOf(logIn));
            Assert.assertTrue(logIn.isDisplayed());

        } catch (NoSuchElementException e) {System.out.println("Возможно выход из профиля не осуществлён - " + e);}

    }

    public void moveToMenu(String menuItem){
        waits.getWait().until(ExpectedConditions.visibilityOf(userIcon));

        Actions builder = new Actions(Hooks.driver);

        builder.moveToElement(Hooks.driver.findElement(By.xpath
                ("//*[@class='header-fresh-partial-component__navigation-wrapper']//*[text()='"+menuItem+"']"))).build().perform();

    }

    public void selectSubMenuItem(String menuItem){

        waits.getWait().until(ExpectedConditions.visibilityOf(Hooks.driver.findElement(By.xpath
                        ("//*[@class='header-fresh-dropdown-partial-component__sidebar-navigation']//*[text()='"+menuItem+"']")))).click();

    }

}
