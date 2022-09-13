package org.example.stepDefs;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.P03_homePage;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class D06_homeSlidersStepDef {
    P03_homePage home = new P03_homePage();

    @When("user clicks on first slider")
    public void selectOne(){
        home.sliderOnePOM().click();
    }
    @Then("user is redirected to first slider url")
    public void redirectedOne(){
        String actualURL="https://demo.nopcommerce.com/nokia-lumia-1020";
        WebDriverWait wait = new WebDriverWait(Hooks.driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(home.welcomeToOurStorePOM()));
        Assert.assertTrue(home.urlAfterSearch().contains(actualURL),"First Slider Assert: Failed");
    }

    @When("user clicks on second slider")
    public void selectTwo(){
        home.sliderTwoPOM().click();
    }
    @Then("user is redirected to second slider url")
    public void redirectedTwo(){
        String actualURL=" https://demo.nopcommerce.com/iphone-6";
        WebDriverWait wait = new WebDriverWait(Hooks.driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(home.welcomeToOurStorePOM()));
        Assert.assertTrue(home.urlAfterSearch().contains(actualURL),"Second Slider Assert: Failed");

    }
}
