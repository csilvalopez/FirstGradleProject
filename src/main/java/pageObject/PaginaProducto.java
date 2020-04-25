package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.Reporter;

import java.util.List;

public class PaginaProducto extends BasePage{

    @FindBy(how = How.CSS, using = "#productInfo > fieldset > span:nth-child(2) > span")
    List<WebElement> priceList;

    @FindBy(how = How.CSS, using = "h1.item-title__primary")
    WebElement itemName;

    public PaginaProducto(WebDriver driver) {
        super(driver, By.cssSelector("#productInfo"));
    }

    public List<String> getProductoInfo (){

        Reporter.log("Oferta Semanal: ");

        List<String> infoProductoSemanal = null;

        Reporter.log(itemName.getText());
        Reporter.log(priceList.get(0).getText());
        Reporter.log(priceList.get(1).getText());

        infoProductoSemanal.add(itemName.getText());
        infoProductoSemanal.add(priceList.get(0).getText());
        infoProductoSemanal.add(priceList.get(1).getText());

        return infoProductoSemanal;
    }

//    public List<WebElement> getPriceList() {
//        return priceList;
//    }
//
//    public WebElement getItemName() {
//        return itemName;
//    }
}