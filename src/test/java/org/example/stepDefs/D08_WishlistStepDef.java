package org.example.stepDefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.en_scouse.An;
import org.example.pages.P03_homePage;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

public class D08_WishlistStepDef {
    P03_homePage home = new P03_homePage();

    @When("user adds HTC item to wishlist")
    public void addItem(){
        home.wishlistBtnPOM().click();
    }
    @Then("item is added successfully")
    public void assertItemAdded(){
        WebDriverWait wait = new WebDriverWait(Hooks.driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(home.whishlistSuccPOM()));
        String expectedBkndColor="#4bb07a";
        String expectedSuccessTextMsg="The product has been added to your wishlist";
        String actualColor = Color.fromString(home.bkgndColorPOM()).asHex();
        String actualText = home.whishlistSuccPOM().getText();
        SoftAssert soft = new SoftAssert();

//        System.out.println(expectedBkndColor);
//        System.out.println(expectedSuccessTextMsg);
//        System.out.println(actualColor);
//        System.out.println(actualText);

        soft.assertTrue(actualColor.contains(expectedBkndColor),"Background Color Assert: Failed");
        soft.assertTrue(actualText.contains(expectedSuccessTextMsg),"Success Text Message Assert: Failed");
        soft.assertAll();
    }

    @And("user go to wishlist page")
    public void navToWishlist(){
        WebDriverWait wait = new WebDriverWait(Hooks.driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.invisibilityOf(home.whishlistSuccPOM()));
        home.wishlistIconPOM().click();
    }

    @Then("Qty is greater than zero")
    public void assertItemgtz(){

        int zero=0;
        int actualValue = Integer.parseInt(home.wishlistQtyPOM().getAttribute("value"));
        SoftAssert soft = new SoftAssert();

//        System.out.println(Integer.parseInt(home.wishlistQtyPOM().getAttribute("value")));
//        System.out.println(actualValue>zero);

        soft.assertTrue(actualValue>zero,"Qty is greater than zero Assert: Failed");
        soft.assertAll();
    }
}
