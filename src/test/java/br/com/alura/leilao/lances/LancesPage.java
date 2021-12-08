package br.com.alura.leilao.lances;

import br.com.alura.leilao.PageObject;
import org.openqa.selenium.WebDriver;

public class LancesPage extends PageObject {

    private static final String URL_LANCES = "http://localhost:8080/leilao/2";

    public LancesPage(WebDriver browser) {
        super(null);
        this.browser.navigate().to(URL_LANCES);
    }

    public boolean isPaginaAtual() {
        return browser.getCurrentUrl().contains(URL_LANCES);
    }

    public boolean isTituloLeilaoVisivel() {
        return browser.getPageSource().contains("Dados do Leilão");
    }
}
