package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseTest {

    protected WebDriver driver;



    protected void getPrincipalPage() {
        System.setProperty("webdriver.chrome.driver","C:/Users/Camila Silva/Documents/Personal/Proyectos/chromedriver");
        driver = new ChromeDriver(); //levanto el browser

        driver.get("www.mercadolibre.com.uy");

    }
}
