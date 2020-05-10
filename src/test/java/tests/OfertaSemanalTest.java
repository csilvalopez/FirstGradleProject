package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;
import pageObject.OfertaSemanal;
import pageObject.PaginaPrincipal;
import pageObject.PaginaProducto;

import java.util.ArrayList;
import java.util.List;

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
    public void validateProductInformation(){

        PaginaPrincipal paginaPrincipal = new PaginaPrincipal(driver);
        OfertaSemanal ofertaSemanal = paginaPrincipal.getOfertaSemanalPage();
        List<String> listaOS = ofertaSemanal.getProductInfo();
        PaginaProducto paginaProducto = ofertaSemanal.getPaginaProducto();

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(listaOS.get(0), paginaProducto.getProductoInfo().get(0));
        softAssert.assertEquals(listaOS.get(1), paginaProducto.getProductoInfo().get(1));
        softAssert.assertEquals(listaOS.get(2), paginaProducto.getProductoInfo().get(2));
        softAssert.assertAll();
    }

    @AfterMethod
    public void cleanup() {
        driver.quit();


}


}
