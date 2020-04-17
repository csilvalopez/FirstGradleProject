package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.List;

public class OfertaSemanale extends BasePage {

    @FindBy(how = How.CSS, using = "span[class='price__symbol']")
    List<WebElement> priceCurrencyList;

    @FindBy(how = How.CSS, using = "span[class='price__fraction']")
    List<WebElement> priceFractionList;

    @FindBy(how = How.CSS, using = "span[class='price__decimals']")
    List<WebElement> priceDecimalList;

    @FindBy(how = How.CSS, using = "span.main-title")
    List<WebElement> nombreItemList;


    public OfertaSemanale(WebDriver driver) {
        super(driver, new By.ByCssSelector("#MLU467539014"));
    }

    public PaginaProducto getPaginaProducto(){
        nombreItemList.get(0).click();
        return new PaginaProducto(getDriver());
    }

    public List<WebElement> getPriceCurrencyList() {
        return priceCurrencyList;
    }

    public List<WebElement> getPriceFractionList() {
        return priceFractionList;
    }

    public List<WebElement> getPriceDecimalList() {
        return priceDecimalList;
    }

    public List<WebElement> getNombreItemList() {
        return nombreItemList;
    }


}
