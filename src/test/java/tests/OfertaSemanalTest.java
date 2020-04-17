package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.*;
import pageObject.OfertaSemanale;
import pageObject.PaginaPrincipal;
import pageObject.PaginaProducto;

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

        PaginaPrincipal paginaPrincipal = new PaginaPrincipal(driver);
        paginaPrincipal.getOfertaSemanalPage();
        OfertaSemanale ofertaSemanale = new OfertaSemanale(driver);
        ofertaSemanale.getPaginaProducto();
        PaginaProducto paginaProducto = new PaginaProducto(driver);

        Reporter.log(ofertaSemanale.getNombreItemList().get(0).getText(), true);
        Reporter.log(paginaProducto.getItemName().getText(), true);

//        SoftAssert softAssert = new SoftAssert();
//        softAssert.assertEquals(ofertaSemanale.getNombreItemList().get(0).getText(), paginaProducto.getItemName().getText());

       // Assert.assertEquals();

    }

    @AfterMethod
    public void cleanup() {
        driver.quit();

}


}
