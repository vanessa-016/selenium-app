package com.selenium.pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class LoginPage {

    public WebDriver tdriver;
    public LoginPage(WebDriver ndriver) {
        tdriver = ndriver;
        PageFactory.initElements(ndriver, this);
    }


    @FindBy (id="login_button_container")
    WebElement txtMsg;

    @FindBy (id="logout_sidebar_link")
    WebElement btnLogout;

    @FindBy (id="react-burger-menu-btn")
    WebElement btnMenu;
    @FindBy (id="user-name")
    WebElement txtName;
    @FindBy (id="password")
    WebElement txtPass;
    @FindBy (id="login-button")
    WebElement btnLogin;

    @FindBy (id="header_container")
    WebElement label;

    public void setUserPass(String username, String pass){
        txtName.sendKeys(username);
        txtPass.sendKeys(pass);
        btnLogin.click();

    }
    public void logout(){
        btnMenu.click();
        btnLogout.click();

    }

}

