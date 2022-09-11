package org.example.stepDefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.P01_register;
import org.openqa.selenium.By;
import org.testng.asserts.SoftAssert;

public class D01_registerStepDef {
    P01_register register = new P01_register();

    @Given("user go to register page")
    public void goRegisterPage() {register.registerLink().click();}
    @When("user select gender type")
    public void selectGender(){register.genderPOM().click();}
    @And("^user enter first name \"(.*)\" and last name \"(.*)\"$")
    public void firstNameAndLastName(String firstName, String lastName){register.enterNames(firstName,lastName);}
    @And ("user enter date of birth")
    public void dateBirth(){register.enterBirthDate();}
    @And("^user enter email \"(.*)\"$")
    public void emailAddress(String email){register.enterEmail(email);}
    @And("^user fills password fields \"(.*)\" \"(.*)\"$")
    public void fillPassword(String pass, String conf){register.enterPassword(pass, conf);}
    @And("user clicks on register button")
    public void registerButton(){register.registerBtnPOM().click();}
    @Then("Success messages is displayed")
    public void successDisplayed(){register.softAssertSuccess();}

}
