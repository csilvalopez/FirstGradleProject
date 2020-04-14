package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class PaginaPrincipal extends BasePage {


    public PaginaPrincipal(WebDriver pDriver, By localizador) {
        super(pDriver, localizador);
    }

    //ofertas semanales
    @FindBy(how = How.CSS, using = "a[href='https://ofertas.mercadolibre.com.uy/ofertas-de-la-semana#nav-header']")
    WebElement ofertasSemanales;


    public OfertaSemanale getOfertaSemanalPage (){
        ofertasSemanales.click();
        return new OfertaSemanale();
    }

}
