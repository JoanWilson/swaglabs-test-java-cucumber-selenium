package br.ce.joanwilson.steps;

import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Então;
import io.cucumber.java.pt.Quando;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.chrome.ChromeDriver;
import java.io.*;
import org.openqa.selenium.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class LoginTest {

    private WebDriver driver;

    @Dado("que estou no site")
    public void queEstouNoSite() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\joanw\\Desktop\\QA-projects\\chromeDriver\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");
    }
    @Dado("somente poderei utilizar os logins preestabelecidos")
    public void somentePodereiUtilizarOsLoginsPreestabelecidos() {
        System.out.println("standard_user\n" +
                "locked_out_user\n" +
                "problem_user\n" +
                "performance_glitch_user");
    }
    @Quando("preencho o primeiro campo com um {string}")
    public void preenchoOPrimeiroCampoComUm(String string) {
        driver.findElement(By.id("user-name")).sendKeys(string);
    }
    @Quando("preencho o segundo campo com uma {string}")
    public void preenchoOSegundoCampoComUma(String string) {
        driver.findElement(By.id("password")).sendKeys(string);
    }
    @Quando("clico no botão de Login")
    public void clicoNoBotãoDeLogin() {
        driver.findElement(By.id("login-button")).click();
    }

    @Então("a tela de produtos aparece" )
    public void aTelaDeProdutosAparece() {
        String text_title = driver.findElement(By.className("title")).getText();
        Assert.assertEquals("PRODUCTS", text_title);
    }

    @After(order = 1, value = "@funcionais")
    public void screenshot(Scenario cenario) {
        File file = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(file, new File("target/screenshot/"+cenario.getId()+".jpg"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @After(order = 0, value = "@funcionais")
    public void fecharBrowser() {
        driver.quit();
        System.out.println("terminando");
    }

}
