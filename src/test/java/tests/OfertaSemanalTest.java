package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;
import pageObject.OfertaSemanal;
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
        OfertaSemanal ofertaSemanal = new OfertaSemanal(driver);
        ofertaSemanal.getPaginaProducto();
        PaginaProducto paginaProducto = new PaginaProducto(driver);

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(ofertaSemanal.getProductInfo().get(0), paginaProducto.getProductoInfo().get(0));
        softAssert.assertEquals(ofertaSemanal.getProductInfo().get(1), paginaProducto.getProductoInfo().get(1));
        softAssert.assertEquals(ofertaSemanal.getProductInfo().get(2), paginaProducto.getProductoInfo().get(2));

    }

    @AfterMethod
    public void cleanup() {
        driver.quit();

}


}
