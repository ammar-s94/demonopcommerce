package org.example.pages;

import org.example.stepDefs.Hooks;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.util.List;

public class P03_homePage {
    public Select currencyPOM() {return new Select(Hooks.driver.findElement(By.name("customerCurrency")));}
    public void selectCurrency(){currencyPOM().selectByVisibleText("Euro");}

    public List<WebElement> Elements(){
        List <WebElement> elements = Hooks.driver.findElements(By.cssSelector("span[class=\"price actual-price\"]"));
        return elements;
    }
    public void assertSelection(){
        String symbol = "€";

        List <WebElement> elements =Elements();
        for(int i=0;i<elements.size();i++)
        {
            Assert.assertTrue(elements.get(i).getText().contains(symbol),"Item"+i+"assertion failed");
        }
    }
}
