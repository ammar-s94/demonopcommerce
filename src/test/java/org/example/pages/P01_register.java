package org.example.pages;

import io.cucumber.java.eo.Se;
import org.example.stepDefs.Hooks;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.asserts.SoftAssert;


public class P01_register {



    public WebElement registerLink() {return Hooks.driver.findElement(By.cssSelector("a[class=\"ico-register\"]"));}
    public WebElement genderPOM() {return Hooks.driver.findElement(By.cssSelector("input[value=\"M\"]"));}
    public WebElement firstNamePOM()
    {
        By firstName = By.cssSelector("input[id=\"FirstName\"]");
        return Hooks.driver.findElement(firstName);
    }
    public WebElement lastNamePOM()
    {
        By lastName = By.cssSelector("input[id=\"LastName\"]");
        return Hooks.driver.findElement(lastName);
    }
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
    public WebElement confirmPasswordPOM()
    {
        By confirmPassword = By.cssSelector("input[id=\"ConfirmPassword\"]");
        return Hooks.driver.findElement(confirmPassword);
    }
    public Select birthDayPOM() {return new Select(Hooks.driver.findElement(By.name("DateOfBirthDay")));}
    public Select birthMonthPOM() {return new Select(Hooks.driver.findElement(By.name("DateOfBirthMonth")));}
    public Select birthYearPOM() {return new Select(Hooks.driver.findElement(By.name("DateOfBirthYear")));}
    public WebElement registerBtnPOM() {return Hooks.driver.findElement(By.cssSelector("button[name=\"register-button\"]"));}

    public String successTextPOM(){return Hooks.driver.findElement(By.cssSelector("div[class=\"result\"]")).getText();}
    public String successColorPOM(){return Hooks.driver.findElement(By.cssSelector("div[class=\"result\"]")).getCssValue("color");}

    public void enterBirthDate(){
        birthDayPOM().selectByVisibleText("26");
        birthMonthPOM().selectByVisibleText("March");
        birthYearPOM().selectByVisibleText("1994");
    }

    public void enterNames(String first, String last){
        firstNamePOM().clear();
        lastNamePOM().clear();
        firstNamePOM().click();
        firstNamePOM().sendKeys(first);
        lastNamePOM().click();
        lastNamePOM().sendKeys(last);
    }
    public void enterPassword(String pass, String conf){
        passwordPOM().clear();
        confirmPasswordPOM().clear();
        passwordPOM().click();
        passwordPOM().sendKeys(pass);
        confirmPasswordPOM().click();
        confirmPasswordPOM().sendKeys(conf);
    }
    public void enterEmail(String email){
        emailPOM().clear();
        emailPOM().click();
        emailPOM().sendKeys(email);
    }




    public void softAssertSuccess(){
        String expectedResult = "Your registration completed";
        String actualResult = successTextPOM();
        String expectedColor = "rgba(76, 177, 124, 1)";
        String actualColor = successColorPOM();
        SoftAssert soft = new SoftAssert();

        System.out.println("First assert");
        soft.assertTrue(actualResult.contains(expectedResult),"First Assert");

        System.out.println("Second assert");
        soft.assertTrue(actualColor.contains(expectedColor),"Second Assert");
//        System.out.println(actualColor);
//        System.out.println(actualColor.contains(expectedColor));
        soft.assertAll();
    }

}
