package org.example.stepDefs;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.P03_homePage;

public class D03_currenciesStepDef {
    P03_homePage homePage = new P03_homePage();

    @When("user select euro currency")
    public void selectCurrency(){homePage.selectCurrency();}
    @Then("user selection success")
    public void selectionSuccess(){homePage.assertSelection();}

}
