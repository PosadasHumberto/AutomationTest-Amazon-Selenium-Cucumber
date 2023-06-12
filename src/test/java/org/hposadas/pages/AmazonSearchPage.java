package org.hposadas.pages;

public class AmazonSearchPage extends BasePage{

    //atributos
    private String amazonUrl = "https://www.amazon.fr/";
    private String acceptCookiesButton = "//*[@id=\"sp-cc-accept\"]";
    private String searchInput = "//input[@id='twotabsearchtextbox']";
    private String searchButton = "//input[@id='nav-search-submit-button']";
    private String thirdItem = "/html[1]/body[1]/div[1]/div[2]/div[1]/div[1]/div[1]/span[1]/div[1]/div[6]/div[1]/div[1]/div[1]";
    private String addToCartButton ="//input[@id='add-to-cart-button']";
    private String nextPageButton = "/html[1]/body[1]/div[1]/div[2]/div[1]/div[1]/div[1]/span[1]/div[1]/div[58]/div[1]/div[1]/span[1]/a[3]";

    private String noWarrantyButton = "#warranty_no_button-announce";
    private String addedMessageText = "//*[contains(text(),'Ajouté au panier')]";
    private String container = "//body[1]/div[1]/div[2]/div[1]/div[1]/div[1]/span[1]/div[1]";

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

    public void pickThirdItemFromList() {
        selectNthElementFromList(container, 3);
    }

    public void addToCart() {
        clickElement(addToCartButton);
    }

    public void noWarranty() {
        clickElement(noWarrantyButton);
    }

    public String addedToCartMessage() {
        return textFromElement(addedMessageText);
    }

}
