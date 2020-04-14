package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.*;

public class OfertaSemanalTest{
    WebDriver driver;

    @BeforeClass
    public void prepareClass(){
        WebDriverManager.chromedriver().setup();

    }
    @BeforeMethod
    public void prepareTest(){
        driver = new ChromeDriver();
        driver.get("https://www.mercadolibre.com.uy/");

    }
    @Test
    public void openBrowser(){
    Reporter.log("Abri ML", true);

    }

    @AfterMethod
    public void cleanup() {
        driver.quit();
    }


}
