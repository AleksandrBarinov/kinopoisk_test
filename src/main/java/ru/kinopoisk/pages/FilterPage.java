package ru.kinopoisk.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import ru.kinopoisk.base.Waits;
import ru.kinopoisk.hooks.Hooks;

import java.util.List;

import static ru.kinopoisk.hooks.Hooks.driver;

public class FilterPage {

    public FilterPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//*[@id='genreListTitle']")
    WebElement genreList;

    @FindBy(xpath = "//*[@id='countryListTitle']")
    WebElement countryList;

    @FindBy(xpath = "//*[@name='m_act[years][min]']")
    WebElement yearsMin;

    @FindBy(xpath = "//*[@name='m_act[years][max]']")
    WebElement yearsMax;

    @FindBy(xpath = "//*[@name='m_act[rating][min]']")
    WebElement ratingMin;

    @FindBy(xpath = "//*[@name='m_act[ex_rating][min]']")
    WebElement ratingImdb;

    @FindBy(xpath = "//*[@name='m_act[tomat_rating][min]']")
    WebElement tomatRating;

    @FindBy(xpath = "//*[@name='m_act[review_procent][min]']")
    WebElement positiveRatingMin;

    @FindBy(xpath = "//*[@name='m_act[review_procent][max]']")
    WebElement positiveRatingMax;


    @FindBy(xpath = "//*[contains(@class,'100-2500')]//*[contains(@class,'ui-slider-handle')]")
    WebElement minNumberOfRatingSlider;

    @FindBy(xpath = "//*[contains(@class,'100-2500')]")
    WebElement minNumberOfRatingSliderTrack;


    @FindBy(xpath = "//*[@name='m_act[restriction]']")
    WebElement restriction;

    @FindBy(xpath = "//*[@name='m_act[budget][min]']")
    WebElement budgetMin;

    @FindBy(xpath = "//*[@name='m_act[budget][max]']")
    WebElement budgetMax;

    @FindBy(xpath = "//*[@name='m_act[gross][min]']")
    WebElement boxOfficeMin;

    @FindBy(xpath = "//*[@name='m_act[gross][max]']")
    WebElement boxOfficeMax;

    Waits waits = new Waits();

    Actions actions = new Actions(Hooks.driver);

    public void selectGenreList(String menuItem){
        waits.getWait().until(ExpectedConditions.visibilityOf(genreList));
        genreList.click();

        driver.findElement(By.xpath
                ("//*[@style='display: block;']//*[contains(@class,'selectItem')]//*[@data-name='"+menuItem+"']")).click();

        genreList.click();
    }

    public void selectCountryList(String menuItem){
        waits.getWait().until(ExpectedConditions.elementToBeClickable(countryList));
        countryList.click();

        List<WebElement> elements = driver.findElements(By.xpath
                ("//*[@style='display: block;']//*[contains(@class,'selectItem')]//*[@data-name='"+menuItem+"']"));

        elements.get(0).click();

        countryList.click();

    }

    public void selectYears(String from, String to){
        Select select = new Select(yearsMin);
        select.selectByVisibleText(from);

        Select select2 = new Select(yearsMax);
        select2.selectByVisibleText(to);

    }



    protected void fillField(WebElement element, String value){
        element.clear();
        element.sendKeys(value);
    }

    public void setRatingMin(String value){
        fillField(ratingMin,value);
    }

    public void setRatingImdb(String value){
        fillField(ratingImdb,value);
    }

    public void setTomatRating(String value){
        fillField(tomatRating,value);
    }

    public void setPositiveRatingMin(String value){
        fillField(positiveRatingMin,value);
    }

    public void setPositiveRatingMax(String value){
        fillField(positiveRatingMax,value);
    }


    public void setSliderPosition(String menuItem) {

        int position = Integer.parseInt(menuItem);

        if (position < 100 || position > 2500) {
            throw new AssertionError(
                    "Slider position value should be in the range of 100 to 2500");
        }

        int xOffset = ((position - 500) / 5 );

        waits.getWait().until(ExpectedConditions.visibilityOf(minNumberOfRatingSlider));

        actions.moveToElement(minNumberOfRatingSlider).click();



        //actions.dragAndDropBy(minNumberOfRatingSlider, xOffset, 0).perform();


        for (int i = 0; i < xOffset; i++) {
            minNumberOfRatingSlider.sendKeys(Keys.ARROW_RIGHT);
        }

        System.out.println(Hooks.driver.findElement
                (By.xpath("//*[contains(@class,'whiteBlock interval2500')]//*[@name='m_act[num_vote]']")).getText() + " - 111");

        System.out.println(xOffset + " - xOffset");

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    public void selectRestriction(String value){
        Select select = new Select(restriction);
        select.selectByValue(value);
    }

    public void selectBudgetMin(String value){
        Select select = new Select(budgetMin);
        select.selectByValue(value);
    }

    public void selectBudgetMax(String value){
        Select select = new Select(budgetMax);
        select.selectByValue(value);
    }

    public void selectBoxOfficeMin(String value){
        Select select = new Select(boxOfficeMin);
        select.selectByValue(value);
    }

    public void selectBoxOfficeMax(String value){
        Select select = new Select(boxOfficeMax);
        select.selectByValue(value);
    }
}
