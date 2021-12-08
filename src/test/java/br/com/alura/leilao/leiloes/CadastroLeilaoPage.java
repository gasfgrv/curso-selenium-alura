package br.com.alura.leilao.leiloes;

import br.com.alura.leilao.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CadastroLeilaoPage extends PageObject {

    public static final String URL_CADASTRO_LEILAO = "http://localhost:8080/leiloes/new";

    public CadastroLeilaoPage(WebDriver browser) {
        super(browser);
    }

    public LeiloesPage cadastrarLeilao(String nome, String valorInicial, String dataAbertura) {
        this.browser.findElement(By.id("nome")).sendKeys(nome);
        this.browser.findElement(By.id("valorInicial")).sendKeys(valorInicial);
        this.browser.findElement(By.id("dataAbertura")).sendKeys(dataAbertura);
        this.browser.findElement(By.id("button-submit")).submit();

        return new LeiloesPage(browser);
    }

    public boolean isPaginaAtual() {
        return browser.getCurrentUrl().equals(URL_CADASTRO_LEILAO);
    }

    public boolean isMensagensDeValidacaoVisiveis() {
        String pageSource = browser.getPageSource();
        String validacaoNomeEmBranco = "não deve estar em branco";
        String ValidacaoNomeTamanho = "minimo 3 caracteres";
        String validacaoValor = "deve ser um valor maior de 0.1";
        String validacaoData = "deve ser uma data no formato dd/MM/yyyy";

        return pageSource.contains(validacaoNomeEmBranco) &&
                pageSource.contains(ValidacaoNomeTamanho) &&
                pageSource.contains(validacaoValor) &&
                pageSource.contains(validacaoData);

    }
}
