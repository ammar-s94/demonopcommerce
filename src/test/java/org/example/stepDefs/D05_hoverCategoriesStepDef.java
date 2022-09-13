package org.example.stepDefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.P03_homePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;


import java.util.List;

public class D05_hoverCategoriesStepDef {
    P03_homePage home = new P03_homePage();
    List<WebElement> mainCateg;
    int count;
    int userSelection;
    boolean hasSub=false;
    String mainCategChosen;
    String subCategChosen;


    @When("user hover on main random category")
    public void hover() throws InterruptedException {
        Actions action = new Actions(Hooks.driver);
        mainCateg = home.mainCateg();
        count = mainCateg.size();
        int min = 0;
        int max = count - 1;
        userSelection =  (int)Math.floor(Math.random()*(max-min+1)+min);
        /*! need to remove this line for normal op. */
//        userSelection=0;
        System.out.println("userMainSelection: "+userSelection);
        System.out.println("maincount: "+count);
        action.moveToElement(mainCateg.get(userSelection)).perform();
        mainCategChosen=mainCateg.get(userSelection).findElement(By.tagName("a")).getText().toLowerCase().trim();
        System.out.println("mainCategChosen: "+mainCategChosen);
//        Thread.sleep(1000);
    }

    @And("user select a sub-category")
    public void selectSub() throws InterruptedException {
        List<WebElement> subCateg;
        Actions action = new Actions(Hooks.driver);
        try{
            if(!mainCateg.get(userSelection).findElement(By.tagName("ul")).getSize().equals(0))
                {
                    hasSub=true;
                    subCateg = mainCateg.get(userSelection).findElement(By.cssSelector("ul[class=\"sublist first-level\"]")).findElements(By.tagName("li"));
                    int subCount = subCateg.size();
                    System.out.println("subCount: "+subCount);

                    for(int i=0;i<subCount;i++){
                        System.out.println("subCateg: "+subCateg.get(i).findElement(By.tagName("a")).getText());
                    }

                    int min = 0;
                    int max = subCount - 1;
                    int userSubSelection =  (int)Math.floor(Math.random()*(max-min+1)+min);
                    /*! need to remove this line for normal op. */
//                    userSubSelection=1;
                    System.out.println("userSubSelection: "+userSubSelection);
                    action.moveToElement(subCateg.get(userSubSelection)).perform();
                    subCategChosen=subCateg.get(userSubSelection).findElement(By.tagName("a")).getText().toLowerCase().trim();
                    System.out.println("subCategChosen: "+subCategChosen);
//                    Thread.sleep(2000);
                    subCateg.get(userSubSelection).click();
//                    Thread.sleep(1000);
                }
        }
        catch(Exception e){
            hasSub=false;
            mainCateg.get(userSelection).click();
//            Thread.sleep(1000);
        }
    }
    @Then("user navigates to selected sub-category page")
    public void assertNav(){
        if(hasSub)
            Assert.assertTrue(home.selectedElementDisplayPOM().getText().toLowerCase().trim().contains(subCategChosen),"Sub-Category Selection Test failed");
        else
            Assert.assertTrue(home.selectedElementDisplayPOM().getText().toLowerCase().trim().contains(mainCategChosen),"Main-Category Selection Test failed");

    }
}
