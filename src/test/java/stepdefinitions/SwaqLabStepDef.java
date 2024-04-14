package stepdefinitions;

import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utilities.Driver;

public class SwaqLabStepDef {
    @Given("Go to this webpage {string}")
    public void go_to_this_webpage(String webpage) {
        Driver.getDriver().get(webpage);
    }
    @Then("User enter the {string} and  {string}")
    public void user_enter_the_and(String username, String password) {
        WebElement usernameField = Driver.getDriver().findElement(By.id("user-name"));
        usernameField.sendKeys(username);

        WebElement passwordField = Driver.getDriver().findElement(By.id("password"));
        passwordField.sendKeys(password);
    }
    @Then("User click on Login button")
    public void user_click_on_login_button() {
        WebElement loginButton = Driver.getDriver().findElement(By.id("login-button"));
        loginButton.click();
    }
    @Then("Click on Add to cart button of {string}")
    public void click_on_add_to_cart_button_of(String itemName) {
        WebElement addToCartButton = Driver.getDriver().findElement(By.xpath("//*[contains(@id,'"+itemName+"')]"));
        addToCartButton.click();
    }
    @Then("Select {string} from the sort container")
    public void select_from_the_sort_container(String sortType) {
        WebElement sortSelect = Driver.getDriver().findElement(By.tagName("select"));
        Select select = new Select(sortSelect);
        select.selectByVisibleText(sortType);
    }
    @Then("Click on the {string} item")
    public void click_on_the_item(String numOfItem) {
        WebElement itemLink = Driver.getDriver().findElement(By.xpath("(//*[@class='inventory_item_name '])["+numOfItem+"]"));
        itemLink.click();
    }
    @Then("Click on Remove Button")
    public void click_on_remove_button() {
        WebElement removeButton = Driver.getDriver().findElement(By.xpath("//button[text()='Remove']"));
        removeButton.click();
    }
    @When("Add to cart button is clicked")
    public void add_to_cart_button_is_clicked() {
        WebElement addToCartButton = Driver.getDriver().findElement(By.id("add-to-cart"));
        addToCartButton.click();
    }
    @Then("Click on Back to products button")
    public void click_on_back_to_products_button() {
        WebElement backToProductsButton = Driver.getDriver().findElement(By.id("back-to-products"));
        backToProductsButton.click();
    }
    @Then("Click on shopping cart container")
    public void click_on_shopping_cart_container() {
        WebElement shoppingCartContainerButton = Driver.getDriver().findElement(By.id("shopping_cart_container"));
        shoppingCartContainerButton.click();
    }
    @Then("Click on Checkout button")
    public void click_on_checkout_button() {
        WebElement checkoutButton = Driver.getDriver().findElement(By.id("checkout"));
        checkoutButton.click();
    }
    @Then("Fill the {string} and {string} and {string} and Click on Continue button")
    public void fill_the_and_and(String firstName, String lastName, String postalCode) {
        WebElement firstnameField = Driver.getDriver().findElement(By.id("first-name"));
        firstnameField.sendKeys(firstName);

        WebElement lastnameField = Driver.getDriver().findElement(By.id("last-name"));
        lastnameField.sendKeys(lastName);

        WebElement postalCodeField = Driver.getDriver().findElement(By.id("postal-code"));
        postalCodeField.sendKeys(postalCode);

        WebElement continueButton = Driver.getDriver().findElement(By.id("continue"));
        continueButton.click();

    }

    @When("Finish button is clicked")
    public void finishButtonIsClicked() {
        WebElement finishButton = Driver.getDriver().findElement(By.id("finish"));
        finishButton.click();
    }

    @Then("Verify {string} message displayed")
    public void verifyMessageDisplayed(String message) {
        WebElement ThankYouMessage = Driver.getDriver().findElement(By.xpath("//*[@class='complete-header']"));
        Assert.assertTrue(ThankYouMessage.isDisplayed());
        Assert.assertEquals(message,ThankYouMessage.getText());
    }

    @And("Click on logout button from menu button")
    public void clickOnLogoutButtonFromMenuButton() {
        WebElement menuButton = Driver.getDriver().findElement(By.id("react-burger-menu-btn"));
        menuButton.click();

        WebElement logoutButton = Driver.getDriver().findElement(By.id("logout_sidebar_link"));
        logoutButton.click();
    }

    @Then("Verify error message is displayed")
    public void verifyErrorMessageIsDisplayed() {
        WebElement errorMessage = Driver.getDriver().findElement(By.xpath("//*[@class='error-message-container error']"));
        Assert.assertTrue(errorMessage.isDisplayed());
    }

    @Then("Verify inventory page is opend")
    public void verifyInventoryPageIsOpend() {
        String inventoryPagr = Driver.getDriver().getCurrentUrl();
        Assert.assertTrue(inventoryPagr.contains("inventory"));
    }

    @And("Verify an alert is dispalayed")
    public void verifyAnAlertIsDispalayed() {
        Alert alert = Driver.getDriver().switchTo().alert();
        Assert.assertTrue(alert.getText().contains("Sorting is broken"));
    }

    @And("Verify the product is not removed")
    public void verifyTheProductIsNotRemoved() {
        WebElement item = Driver.getDriver().findElement(By.xpath("//*[@class='inventory_item_name']"));
        Assert.assertTrue(item.isDisplayed());
    }
}
