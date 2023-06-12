package org.hposadas.steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.hposadas.pages.AmazonSearchPage;
import org.hposadas.pages.BasePage;
import org.junit.Assert;

public class AmazonSteps {

    AmazonSearchPage page = new AmazonSearchPage();

    @Given("^the user navigates to www.amazon.com$")
    public void navigateToAmazon(){
        page.navigateToAmazon();
    }

    @And("^Searches for (.*)$")
    public void searchAProduct(String criteria){
        page.enterSearchCriteria(criteria);
        page.clickSearchButton();
    }

    @And("^navigates to the page number (.+)$")
    public void navigateToPageNumber(String pageNumber){
        page.goToPage(pageNumber);
    }

    @And("^selects the third item$")
    public void selectItem3(){
        page.pickThirdItem();
        //page.pickThirdItemFromList();
    }

    @Then("^the user is able to add it to the cart$")
    public void itemCanBeAddedToTheCart(){
        page.addToCart();
        Assert.assertEquals("Ajouté au panier", page.addedToCartMessage());
    }
}
