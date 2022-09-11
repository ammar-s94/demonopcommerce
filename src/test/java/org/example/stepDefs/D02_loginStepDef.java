package org.example.stepDefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.P02_login;

public class D02_loginStepDef {
    P02_login login = new P02_login();

    @Given("user go to login page")
    public void goRegisterPage() {login.loginLink().click();}
    @When("^user login with \"(.*)\" \"(.*)\" and \"(.*)\"$")
    public void emailAndPassword(String type,String email, String pass){login.enterCreds(email,pass);}
    @And ("user press on login button")
    public void login(){login.loginBtn();}
    @Then("user login to the system successfully")
    public void loginSuccess(){login.softAssertSuccess();}
    @Then("user could not login to the system")
    public void loginFailure(){login.softAssertFailure();}
}
