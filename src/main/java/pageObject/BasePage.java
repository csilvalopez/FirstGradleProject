package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {

    private WebDriver driver;
    private WebDriverWait wait;

    public BasePage(WebDriver pDriver, By localizador) {
        wait = new WebDriverWait(pDriver, 10);
        driver = pDriver;
        waitUntilPresentByLocalizador(localizador, pDriver);
        PageFactory.initElements(pDriver, this);
    }

    public boolean presenceOfWebElement(By element){

        return (ExpectedConditions.presenceOfElementLocated(element)!=null);
    }



    public static WebElement waitUntilPresentByLocalizador(By localizador, WebDriver driver){
        return (new WebDriverWait(driver, 30)).until(ExpectedConditions.presenceOfElementLocated(localizador));
    }



}
