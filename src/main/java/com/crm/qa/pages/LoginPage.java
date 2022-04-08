package com.crm.qa.pages;

import com.crm.qa.base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

public class LoginPage extends TestBase {

    //Page Factory
    @FindBy(xpath = "//*[@id=\"navbar-collapse\"]/ul/li[1]/a")
    WebElement login;

    @FindBy(name = "email")
    WebElement username;

    @FindBy(name = "password")
    WebElement password;

    @FindBy(xpath = "//*[@id=\"ui\"]/div/div/form/div/div[3]")
    WebElement loginButton;

    @FindBy(xpath = "//*[@id=\"ui\"]/div/div/div[3]/a")
    WebElement signUpButton;

    @FindBy(xpath = "/html/body/div[2]/div/div[1]/a/img")
    WebElement crmLogo;

    public LoginPage(){
        PageFactory.initElements(driver, this);
        }
    public String validateLoginPage(){
        return driver.getTitle();
    }

    public boolean validateCRMImage(){
        return crmLogo.isDisplayed();
    }

    public HomePage login(String un, String pwd){
        login.click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        username.sendKeys(un);
        password.sendKeys(pwd);
        loginButton.click();

        return new HomePage();
    }
}
