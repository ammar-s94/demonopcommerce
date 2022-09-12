package org.example.stepDefs;

import io.cucumber.java.en.When;
import org.example.pages.P03_homePage;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.util.List;

public class D04_searchStepDef {
    P03_homePage homePage = new P03_homePage();

    @When("^user enter product name as ([^\"]*) \"(.*)\"$")
    public void search(String product,String type){
        homePage.searchPOM().clear();
        homePage.searchPOM().click();
        homePage.searchPOM().sendKeys(product);
        homePage.searchBtnPOM().click();
        assertions(product, type);
    }
//    @Then("user should see items")
    public void assertions(String product, String type){
        String expectedURL="https://demo.nopcommerce.com/search?q=";
        String actualURL=homePage.urlAfterSearch();

        if (type.equals("name")) {
            SoftAssert soft = new SoftAssert();
            soft.assertTrue(actualURL.contains(expectedURL),"SoftAssert:url check failed");
            List<WebElement> elements =homePage.searchElements();
            soft.assertTrue(elements.size()>0,"SoftAssert:product name size check failed");
            for(int i=0;i<elements.size();i++)
            {
                soft.assertTrue(elements.get(i).getText().toLowerCase().contains(product),"Item"+i+"assertion failed");
            }
            soft.assertAll();
        }
        else{
           String elementSKU = homePage.elementInspect();
            Assert.assertTrue(elementSKU.contains(product));
        }



    }
}
