package org.example.pages;

import org.example.stepDefs.Hooks;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.Color;
import org.testng.asserts.SoftAssert;

public class P02_login {
    public WebElement loginLink() {return Hooks.driver.findElement(By.cssSelector("a[class=\"ico-login\"]"));}
    public WebElement emailPOM()
    {
        By email = By.cssSelector("input[id=\"Email\"]");
        return Hooks.driver.findElement(email);
    }
    public WebElement passwordPOM()
    {
        By password = By.cssSelector("input[id=\"Password\"]");
        return Hooks.driver.findElement(password);
    }

    public WebElement loginBtnPOM() {return Hooks.driver.findElement(By.cssSelector("button[class=\"button-1 login-button\"]"));}

    public String failureTextPOM(){return Hooks.driver.findElement(By.cssSelector("div[class=\"message-error validation-summary-errors\"]")).getText();}
    public String failureColorPOM(){return Hooks.driver.findElement(By.cssSelector("div[class=\"message-error validation-summary-errors\"]")).getCssValue("color");}
    public WebElement accountTabPOM(){return Hooks.driver.findElement(By.cssSelector("a[class=\"ico-account\"]"));}
    public String homeUrlPOM(){return Hooks.driver.getCurrentUrl();}

    public void enterCreds(String email, String pass){
        emailPOM().clear();
        emailPOM().click();
        emailPOM().sendKeys(email);
        passwordPOM().clear();
        passwordPOM().click();
        passwordPOM().sendKeys(pass);
    }
    public void loginBtn() {loginBtnPOM().click();}


    public void softAssertSuccess(){
        String expectedResult = "https://demo.nopcommerce.com/";
        String actualResult = homeUrlPOM();
        Boolean myAccount = accountTabPOM().isDisplayed();
        SoftAssert soft = new SoftAssert();

        soft.assertTrue(actualResult.contains(expectedResult),"First Assert");

        soft.assertTrue(myAccount,"Second Assert");

        soft.assertAll();
    }
    public void softAssertFailure(){
        String expectedResult = "Login was unsuccessful.";
        String actualResult = failureTextPOM();
        String expectedColor = "#e4434b";
        String actualColor = Color.fromString(failureColorPOM()).asHex();
        SoftAssert soft = new SoftAssert();

        soft.assertTrue(actualResult.contains(expectedResult),"First Assert");

        soft.assertTrue(actualColor.contains(expectedColor),"Second Assert");

        soft.assertAll();
    }
}
