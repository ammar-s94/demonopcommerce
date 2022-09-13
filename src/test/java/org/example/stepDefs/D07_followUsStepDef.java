package org.example.stepDefs;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.P03_homePage;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class D07_followUsStepDef {
    P03_homePage home = new P03_homePage();

    @When("user opens facebook link")
    public void openFB(){home.FbPOM().click();}
    @Then("FB link is opened in new tab")
    public void FBinNewTab(){
        WebDriverWait wait = new WebDriverWait(Hooks.driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.numberOfWindowsToBe(2));
        home.navigateTabs();
        String actualURL="https://www.facebook.com/nopCommerce";
        Assert.assertTrue(home.urlAfterSearch().contains(actualURL),"Facebook Assert: Failed");
        home.closeTab();

    }

    @When("user opens twitter link")
    public void openTwitter(){home.TwitterPOM().click();}
    @Then ("Twitter is opened in new tab")
    public void twitterinNewTab(){
        WebDriverWait wait = new WebDriverWait(Hooks.driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.numberOfWindowsToBe(2));
        home.navigateTabs();
        String actualURL="https://twitter.com/nopCommerce";
        Assert.assertTrue(home.urlAfterSearch().contains(actualURL),"Twitter Assert: Failed");
        home.closeTab();
    }


    @When("user opens rss link")
    public void openRss(){home.RssPOM().click();}
    @Then("Rss is opened in new tab")
    public void rssinNewTab() {
        WebDriverWait wait = new WebDriverWait(Hooks.driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.numberOfWindowsToBe(2));
        home.navigateTabs();
        String actualURL = "https://demo.nopcommerce.com/new-online-store-is-open";
        Assert.assertTrue(home.urlAfterSearch().contains(actualURL), "Rss Assert: Failed");
        home.closeTab();
    }

    @When("user opens youtube link")
    public void openYouTube(){home.youTubePOM().click();}
    @Then("YouTube is opened in new tab")
    public void youTubeinNewTab(){
        WebDriverWait wait = new WebDriverWait(Hooks.driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.numberOfWindowsToBe(2));
        home.navigateTabs();
        String actualURL="https://www.youtube.com/user/nopCommerce";
        Assert.assertTrue(home.urlAfterSearch().contains(actualURL),"YouTube Assert: Failed");
        home.closeTab();
    }

//    public void HandlingTwoTabs() throws InterruptedException {
//        //1- click on facebook
//        driver.findElement(By.cssSelector("a[href=\"http://www.facebook.com/nopCommerce\"]")).click();
//
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(7));
//        wait.until(ExpectedConditions.numberOfWindowsToBe(2));
//
//        //2- get window list inside array
//        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
//        System.out.println(tabs.size());
//
//        //3- switch from tab 0 to tab 1
//        driver.switchTo().window(tabs.get(1));
//        System.out.println("tab 1:  " +driver.getCurrentUrl());
//
//        //4- switch from tab 1 to tab 0
//        driver.switchTo().window(tabs.get(0));
//        System.out.println("tab 0:  " + driver.getCurrentUrl());
//
//
//        //Difference between driver.quit() and driver.close()
//        driver.close();
//
//
//        // reload
//        tabs = new ArrayList<>(driver.getWindowHandles());
//
//    }

}
