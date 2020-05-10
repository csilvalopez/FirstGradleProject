package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.Reporter;

import java.util.ArrayList;
import java.util.List;


public class OfertaSemanal extends BasePage {

    @FindBy(how = How.CSS, using = "span[class='price__symbol']")
    private WebElement priceCurrency;

    @FindBy(how = How.CSS, using = "span[class='price__fraction']")
    private WebElement priceFraction;

    @FindBy(how = How.CSS, using = "span[class='price__decimals']")
    private WebElement priceDecimal;

    @FindBy(how = How.CSS, using = "span.main-title")
    private WebElement nombreItem;

    public OfertaSemanal(WebDriver driver) {
        super(driver, new By.ByCssSelector("#MLU467539014"));
    }

    public PaginaProducto getPaginaProducto(){
        nombreItem.click();
        return new PaginaProducto(getDriver());
    }


    public List<String> getProductInfo() {
        Reporter.log("Oferta Semanal: ", true);
        Reporter.log(nombreItem.getText(), true);
        Reporter.log(priceCurrency.getText(), true);
        Reporter.log(priceFraction.getText(), true);

        List<String> infoProductoSemanal = new ArrayList<>();
        infoProductoSemanal.add(nombreItem.getText());
        infoProductoSemanal.add(priceCurrency.getText());
        infoProductoSemanal.add(priceFraction.getText());

        return infoProductoSemanal;
    }

}
