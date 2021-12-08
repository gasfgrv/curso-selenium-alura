package br.com.alura.leilao;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

class HelloWorldSeleniumTest {

    @Test
    void hello() {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
        WebDriver brewser = new ChromeDriver();
        brewser.navigate().to("http://localhost:8080/leiloes");
        brewser.quit();
    }

}
