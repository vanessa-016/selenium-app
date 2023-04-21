package com.selenium.steps;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebDriver;
import com.selenium.pages.LoginPage;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.os.WindowsRegistryException;


public class LoginStep {
    public WebDriver driver;
    public LoginPage loginPage;

    @Given("go to app {string}")
    public void go_to_app(String title){
        System.setProperty("webdriver.chrome.driver","chromedriver");
        driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");
        loginPage= new LoginPage(driver);
        Assert.assertEquals(title,driver.getTitle());

    }
    @When("access {string} and {string}")
    public void access(String name, String pass) {
        loginPage.setUserPass(name,pass);
    }
    @Then("i see the {string}")
    public void i_see_the(String title) {
        if (title.equals("https://www.saucedemo.com/inventory.html")){
            Assert.assertEquals(title,driver.getCurrentUrl());
        } else {
            Assert.assertEquals(title,"Epic sadface: Sorry, this user has been locked out.");
        }
    }
    @And("user click on logout")
    public void user_click_on_logout() {
        loginPage.logout();
        Assert.assertEquals("Swag Labs", driver.getTitle());
        driver.close();

    }
}