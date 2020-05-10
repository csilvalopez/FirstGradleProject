package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class PaginaPrincipal extends BasePage {

      @FindBy(how = How.CSS, using = "a[href='https://ofertas.mercadolibre.com.uy/ofertas-de-la-semana#nav-header']")
      WebElement ofertasSemanales;

    public PaginaPrincipal(WebDriver driver) {
        super(driver, By.cssSelector("a[href='https://ofertas.mercadolibre.com.uy/ofertas-de-la-semana#nav-header']"));
    }

    public OfertaSemanal getOfertaSemanalPage (){
        JavascriptExecutor executor = (JavascriptExecutor)getDriver();
        executor.executeScript("arguments[0].click();", ofertasSemanales);
        return new OfertaSemanal(getDriver());
    }

}
