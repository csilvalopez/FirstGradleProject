package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.Reporter;

import java.util.List;


public class OfertaSemanal extends BasePage {

    @FindBy(how = How.CSS, using = "span[class='price__symbol']")
    WebElement priceCurrency;

    @FindBy(how = How.CSS, using = "span[class='price__fraction']")
    WebElement priceFraction;

    @FindBy(how = How.CSS, using = "span[class='price__decimals']")
    WebElement priceDecimal;

    @FindBy(how = How.CSS, using = "span.main-title")
    WebElement nombreItem;


    public OfertaSemanal(WebDriver driver) {
        super(driver, new By.ByCssSelector("#MLU467539014"));
    }

    public PaginaProducto getPaginaProducto(){
        nombreItem.click();
        return new PaginaProducto(getDriver());
    }

    public List<String> getProductInfo() {
        Reporter.log("Oferta Semanal: ");

        List<String> infoProductoSemanal = null;

        Reporter.log(nombreItem.getText());
        Reporter.log(priceCurrency.getText());
        Reporter.log(priceFraction.getText());

        infoProductoSemanal.add(nombreItem.getText());
        infoProductoSemanal.add(priceCurrency.getText());
        infoProductoSemanal.add(priceFraction.getText());

        return infoProductoSemanal;
    }
//    public String getPriceFraction() {
//        Reporter.log(priceFraction.getText());
//        return priceFraction.getText();
//    }
////    public String getPriceDecimal() {
////        Reporter.log(priceDecimal.getText());
////        return priceDecimal.getText();
////    }
//    public String getNombreItem() {
//        Reporter.log(nombreItem.getText());
//        return nombreItem.getText();
//    }
}
