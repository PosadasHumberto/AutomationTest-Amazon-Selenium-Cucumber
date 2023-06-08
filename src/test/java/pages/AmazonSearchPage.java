package pages;

import org.openqa.selenium.WebDriver;

public class AmazonSearchPage extends BasePage{

    //atributos
    private String amazonUrl = "https://www.amazon.fr/";
    private String acceptCookiesButton = "//*[@id=\"sp-cc-accept\"]";
    private String searchInput = "//input[@id='twotabsearchtextbox']";
    private String searchButton = "//input[@id='nav-search-submit-button']";
    private String thirdItem = "/html[1]/body[1]/div[1]/div[1]/span[1]/div[1]/div[6]/div[1]/div[1]/div[1]";
    private String addToCartButton ="//input[@id='add-to-cart-button']";
    private String addedMessageText = "//span[contains(text(),'Ajouté au panier')]";

    //constructor
    public AmazonSearchPage() {
        super(driver);
    }

    //métodos
    public void navigateToAmazon(){
        navigateTo(amazonUrl);
        clickElement(acceptCookiesButton);
    }

    public void enterSearchCriteria(String criteria) {
        write(searchInput, criteria);
    }

    public void clickSearchButton() {
        clickElement(searchButton);
    }

    public void goToPage(String pageNumber) {
        goToLinkText(pageNumber);
    }

    public void pickThirdItem(){
        clickElement(thirdItem);
    }

    public void addToCart() {
        clickElement(addToCartButton);
    }

    public String addedToCartMessage() {
        return textFromElement(addedMessageText);
    }

}
