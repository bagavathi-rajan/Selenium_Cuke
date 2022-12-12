package StepDef3;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.en_old.Ac;
import io.opentelemetry.exporter.logging.SystemOutLogRecordExporter;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.idealized.Javascript;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class MagnetoOnlineShoppingStepDefs {

    public WebDriver driver;

    @Given("a Chrome browser is available for testing")
    public void aChromeBrowserIsAvailable() {
        System.setProperty("webdriver.chrome.driver", "driver/chromedriver.exe");
        driver = new ChromeDriver();
//        int width = 400;
//        int height = 600;
//        Dimension dimension = new Dimension(width, height);
//        driver.manage().window().setSize(dimension);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10000, TimeUnit.MILLISECONDS);
    }

    @When("the Online shopping portal is launched")
    public void theOnlineShoppingPortalIsLaunched() throws InterruptedException {
        driver.get("https://magento.softwaretestingboard.com/");
        //Thread.sleep(1000);
    }

    @Then("Click on Create an Account")
    public void clickOnCreateAnAccount() throws InterruptedException {
        driver.findElement(By.linkText("Create an Account")).click();
        //Thread.sleep(3000);
    }

    public int randomEmailGenerator (){
        Random randomGenerator = new Random();
        int randomInt = randomGenerator.nextInt(1000);
        return randomInt;
    }

    public String randomMail () throws InterruptedException {
        int randomNum = randomEmailGenerator();
        WebElement mail = driver.findElement(By.id("email_address"));
        mail.sendKeys("Sample" + randomNum + "@gmail.com");
        Thread.sleep(2000);
        String email = mail.getText();
        return email;
    }

    @And("provide all the required information and register")
    public void provideAllTheRequiredInformationAndRegisterSuccessfully() throws InterruptedException {
        clickOnCreateAnAccount();
        driver.findElement(By.id("firstname")).sendKeys("Bagavathi");
        driver.findElement(By.id("lastname")).sendKeys("Rajan");
        WebElement newsLetter = driver.findElement(By.id("is_subscribed"));

        if (!newsLetter.isSelected()) {
            newsLetter.click();
        }

        String mailId = randomMail();
        driver.findElement(By.id("email_address")).sendKeys(mailId);
        driver.findElement(By.id("password")).sendKeys("Sample@123");
        driver.findElement(By.id("password-confirmation")).sendKeys("Sample@123");
        driver.findElement(By.xpath("//*[@id=\"form-validate\"]/div/div[1]/button")).click();
        //Thread.sleep(4000);
    }

    @Then("logout from the account and close browser")
    public void logoutFromTheAccountAndCloseBrowser() throws InterruptedException {
        driver.findElement(By.xpath("/html/body/div[2]/header/div[1]/div/ul/li[2]/span/button")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("/html/body/div[2]/header/div[1]/div/ul/li[2]/div/ul/li[3]/a")).click();
        Thread.sleep(2000);
        driver.quit();
    }

    @When("the user registers and logins with correct credentials")
    public void theUserLoginsWithCorrectCredentials() throws InterruptedException {
        theOnlineShoppingPortalIsLaunched();
        //driver.findElement(By.linkText("Sign In")).click();
        Thread.sleep(2000);
        provideAllTheRequiredInformationAndRegisterSuccessfully();

    }
    public void mouseOverTheProducts () throws InterruptedException{
        Actions actions = new Actions(driver);
        WebElement menuOptions = driver.findElement(By.xpath("//*[@id=\"ui-id-5\"]/span[1]"));
        actions.moveToElement(menuOptions).perform();
        //Thread.sleep(3000);

        WebElement subMenu = driver.findElement(By.xpath("//*[@id=\"ui-id-17\"]/span[1]"));
        actions.moveToElement(subMenu).perform();
        //Thread.sleep(3000);

        WebElement finalMenu = driver.findElement(By.xpath("//*[@id=\"ui-id-19\"]"));
        finalMenu.click();
        //Thread.sleep(5000);0
    }
    @Then("user choose the selected item and added to shopping cart")
    public void userChooseTheSelectedItemAndAddedToShoppingCart() throws InterruptedException {
        mouseOverTheProducts();
        driver.findElement(By.linkText("Taurus Elements Shell")).click();
        //Thread.sleep(4000);
        driver.findElement(By.id("option-label-size-143-item-168")).click();
        driver.findElement(By.id("option-label-color-93-item-50")).click();
        driver.findElement(By.id("qty")).clear();
        driver.findElement(By.id("qty")).sendKeys("5");
        driver.findElement(By.id("product-addtocart-button")).click();
        Thread.sleep(2000);
    }

    @And("user checks out the items")
    public void userChecksOutTheItemsAndOrderIsSuccessful() throws InterruptedException{
        driver.findElement(By.xpath("/html/body/div[2]/header/div[2]/div[1]/a")).click();
        //Thread.sleep(8000);
        driver.findElement(By.id("top-cart-btn-checkout")).click();
        //Thread.sleep(5000);
        driver.findElement(By.name("street[0]")).sendKeys("17, Victoria Road");
        driver.findElement(By.name("city")).sendKeys("Ohio");
        //Thread.sleep(3000);
//        Select state = new Select(driver.findElement(By.name("shippingAddress.region_id")).findElement(By.name("region-id")));
//        state.selectByVisibleText("Alaska");
        driver.findElement(By.name("postcode")).sendKeys("99876");

        Select country = new Select(driver.findElement(By.name("country_id")));
        country.selectByIndex(25);

        driver.findElement(By.name("telephone")).sendKeys("+01 765535787");

        WebElement checkbox = driver.findElement(By.id("checkout-step-shipping_method")).findElement(By.xpath("//*[@id=\"checkout-shipping-method-load\"]/table/tbody/tr[1]/td[1]/input"));

        if (!checkbox.isSelected()) {
            checkbox.click();
        }
        driver.findElement(By.xpath("//*[@id=\"shipping-method-buttons-container\"]/div/button")).click();
        //Thread.sleep(6000);

        driver.findElement(By.xpath("//*[@id=\"shipping-method-buttons-container\"]/div/button")).click();
        //Thread.sleep(3000);

        driver.findElement(By.xpath("//*[@class='action primary checkout']")).click();
        //Thread.sleep(3000);
    }
    @Then("order is successful")
    public void order_Is_Successful() throws InterruptedException {
        WebElement title = driver.findElement(By.xpath("//*[@id=\"maincontent\"]/div[1]/h1/span"));
       String successMsg = title.getText();
       successMsg.compareTo("Thank you for your pu");

       System.out.println(successMsg);
        //Thread.sleep(3000);
    }

    @And("user choose the product type")
    public void userChooseTheProductType() throws InterruptedException {
        mouseOverTheProducts();
        //driver.findElement(By.xpath("//*[@id=\"maincontent\"]/div[3]/div[2]")).findElement(By.xpath("//*[@id=\"layered-filter-block\"]")).findElement(By.xpath("//*[@id=\"layered-filter-block\"]/div[2]")).findElement(By.id("narrow-by-list")).findElement(By.xpath("//*[@id=\"narrow-by-list\"]/div[1]/div[1]")).findElement(By.xpath("//*[@id=\"narrow-by-list\"]/div[1]/div[2]/ol/li[1]/a")).click();

    }

    @Then("sort the products with price order")
    public void sortTheProductsWithPriceOrder() throws InterruptedException {
        driver.findElement(By.id("sorter")).click();
        //Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id=\"sorter\"]/option[3]")).click();
        //Thread.sleep(2000);


    }

    @And("all the items should be displayed in price low to high order")
    public void allTheItemsShouldBeDisplayedInPriceLowToHighOrder() {
        //WebElement total = driver.findElement(By.xpath("//*[@id=\"toolbar-amount\"]/span"));
        WebElement page = driver.findElement(By.tagName("body"));
        String totalItems = page.getText();
        System.out.println(totalItems);

    }
    @Then("filter based on category")
    public void filterBasedOnCategory() throws InterruptedException{
        driver.findElement(By.xpath("//*[@id=\"layered-filter-block\"]/div[2]/strong")).findElement(By.xpath("//*[@id=\"narrow-by-list\"]/div[1]/div[1]")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id=\"narrow-by-list\"]/div[1]/div[2]/ol/li[1]/a")).click();
        //Thread.sleep(5000);
    }
    @And("all the items should be displayed as per filter")
    public void allTheItemsShouldBeDisplayedAsPerFilter() throws InterruptedException{
        WebElement totalNum = driver.findElement(By.xpath("//*[@id=\"toolbar-amount\"]"));
        String filteredItems = totalNum.getText();

        System.out.println(filteredItems);
        //Thread.sleep(2000);

        //Capture price Before filter
        List<WebElement> beforeFilter = driver.findElements(By.xpath("//*[@id=\"maincontent\"]/div[3]/div[1]/div[3]/ol/li[1]/div/div/div[1]/span/span"));

        //remove $ symbol from price
        List<Double> beforePrice = new ArrayList<>();

        for (WebElement p : beforeFilter) {
           beforePrice.add(Double.valueOf(p.getText().replace("As low as $", "")));
        }
        //Capture price after filter
        sortTheProductsWithPriceOrder();
        List<WebElement> afterFilter = driver.findElements(By.xpath("//*[@id=\"maincontent\"]/div[3]/div[1]/div[3]/ol/li[1]/div/div/div[1]/span/span"));

        //remove $ symbol from price
        List<Double> afterPrice = new ArrayList<>();

        for (WebElement p1: afterFilter) {
            afterPrice.add(Double.valueOf(p1.getText().replace("As low as $", "")));
        }

        //Compare both the prices
        Collections.reverse(beforePrice);
        Collections.sort(afterPrice);

        Assert.assertEquals(beforePrice, afterPrice);
        Thread.sleep(3000);

    }

    @Then("user searches for a product using search box")
    public void userSearchesForAProductUsingSearchBox() throws InterruptedException {
        driver.findElement(By.id("search")).sendKeys("Fitness Equipment");
        driver.findElement(By.xpath("//*[@id=\"search_mini_form\"]/div[2]/button")).click();
        Thread.sleep(2000);
    }

    @And("all the product related to search are displayed")
    public void allTheProductRelatedToSearchAreDisplayed() throws InterruptedException {
       WebElement searchProducts = driver.findElement(By.xpath("//*[@id=\"maincontent\"]/div[1]/h1/span"));
       String searchResult = searchProducts.getText();
       System.out.println(searchResult);
       Thread.sleep(2000);
    }

    @And("user to choose the added items from shopping cart and update it")
    public void userToChooseTheAddedItemsFromShoppingCartAndUpdateIt()throws InterruptedException {
        Thread.sleep(3000);
        driver.findElement(By.xpath("/html/body/div[2]/header/div[2]/div[1]/a")).click();
        driver.findElement(By.linkText("View and Edit Cart")).click();
        driver.findElement(By.xpath("//*[@id=\"shopping-cart-table\"]/tbody/tr[2]/td/div/a[2]")).click();
        driver.findElement(By.id("option-label-size-143-item-170")).click();
        driver.findElement(By.id("option-label-color-93-item-59")).click();
        driver.findElement(By.id("qty")).clear();
        driver.findElement(By.id("qty")).sendKeys("3");
        driver.findElement(By.id("product-updatecart-button")).click();

    }

    @And("user checks out the item and order is successful")
    public void userChecksOutTheItemAndOrderIsSuccessful() throws InterruptedException {
        driver.findElement(By.cssSelector("#maincontent > div.columns > div > div.cart-container > div.cart-summary > ul > li:nth-child(1) > button")).click();
        driver.findElement(By.name("street[0]")).sendKeys("17, Victoria Road");
        driver.findElement(By.name("city")).sendKeys("Ohio");
        Thread.sleep(3000);
//        Select state = new Select(driver.findElement(By.name("shippingAddress.region_id")).findElement(By.name("region-id")));
//        state.selectByVisibleText("Alaska");
        driver.findElement(By.name("postcode")).sendKeys("99876");

        Select country = new Select(driver.findElement(By.name("country_id")));
        country.selectByIndex(25);

        driver.findElement(By.name("telephone")).sendKeys("+01 765535787");

        WebElement checkbox = driver.findElement(By.id("checkout-step-shipping_method")).findElement(By.xpath("//*[@id=\"checkout-shipping-method-load\"]/table/tbody/tr[1]/td[1]/input"));

        if (!checkbox.isSelected()) {
            checkbox.click();
        }
        driver.findElement(By.xpath("//*[@id=\"shipping-method-buttons-container\"]/div/button")).click();
        Thread.sleep(3000);

        driver.findElement(By.xpath("//*[@id=\"shipping-method-buttons-container\"]/div/button")).click();
        Thread.sleep(3000);

        driver.findElement(By.xpath("//*[@class='action primary checkout']")).click();
        Thread.sleep(3000);

    }


    @When("the user registers with invalid email address")
    public void theUserRegistersWithInvalidEmailAddress()throws InterruptedException{
        theOnlineShoppingPortalIsLaunched();
        //Thread.sleep();
        clickOnCreateAnAccount();
        driver.findElement(By.id("firstname")).sendKeys("Bagavathi");
        driver.findElement(By.id("lastname")).sendKeys("Rajan");
        driver.findElement(By.id("email_address")).sendKeys("Dummy1$#gmail.com");
        driver.findElement(By.id("password")).sendKeys("Sample@123");
        driver.findElement(By.id("password-confirmation")).sendKeys("Sample@123");
        driver.findElement(By.xpath("//*[@id=\"form-validate\"]/div/div[1]/button")).click();
        Thread.sleep(2000);
    }

    @Then("there should be an error for invalid email")
    public void thereShouldBeAnErrorForInvalidEmail() throws InterruptedException {
         WebElement error = driver.findElement(By.id("email_address-error"));
         String errMsg = error.getText();
         Assert.assertEquals(errMsg, "Please enter a valid email address (Ex: johndoe@domain.com).");
         System.out.println(errMsg);
         driver.quit();
    }

    @When("the user registers with invalid password")
    public void theUserRegistersWithInvalidPassword() throws InterruptedException{
        theOnlineShoppingPortalIsLaunched();
        //Thread.sleep();
        clickOnCreateAnAccount();
        driver.findElement(By.id("firstname")).sendKeys("Bagavathi");
        driver.findElement(By.id("lastname")).sendKeys("Rajan");
        driver.findElement(By.id("email_address")).sendKeys("Dummy1@gmail.com");
        driver.findElement(By.id("password")).sendKeys("sample%*");
        driver.findElement(By.id("password-confirmation")).sendKeys("sample%*");
        driver.findElement(By.xpath("//*[@id=\"form-validate\"]/div/div[1]/button")).click();
    }

    @Then("there should be an error for invalid password")
    public void thereShouldBeAnErrorForInvalidPassword() {
       WebElement pwdError = driver.findElement(By.id("password-error"));
       String errMsg = pwdError.getText();
       Assert.assertEquals(errMsg, "Minimum of different classes of characters in password is 3. Classes of characters: Lower Case, Upper Case, Digits, Special Characters.");
       System.out.println(errMsg);
       driver.quit();
    }

    @When("user right clicks on a link")
    public void userRightClicksOnALink() throws InterruptedException {
        theOnlineShoppingPortalIsLaunched();
        WebElement sale = driver.findElement(By.id("ui-id-8"));
        Actions rightClick = new Actions(driver);
        rightClick.click(sale).perform();
    }

    @Then("right click operations are performed")
    public void rightClickOperationsArePerformed() {
        WebElement text = driver.findElement(By.tagName("body"));
        String body = text.getText();
        System.out.println(body);
        driver.quit();
    }

    @When("user clicks and hold an element")
    public void userClicksAndHoldAnElement() throws InterruptedException {
        theOnlineShoppingPortalIsLaunched();
        driver.findElement(By.xpath("//*[@id=\"ui-id-5\"]/span[1]")).click();
        WebElement click = driver.findElement(By.linkText("Hero Hoodie"));
        Actions action = new Actions(driver);
        action.clickAndHold(click).perform();
    }

    @Then("user should be able to see the actions")
    public void userShouldBeAbleToSeeTheActions() {
        WebElement product = driver.findElement(By.xpath("//*[@id=\"maincontent\"]/div[4]/div[1]/div[1]/div[3]/div/div/ol/li[2]/div/div"));
        String productItem = product.getText();
        System.out.println(productItem);
        //driver.quit();
    }

    @When("user launches browser and scrolls the page")
    public void userLaunchesBrowserAndScrollsThePage() throws InterruptedException {
        theOnlineShoppingPortalIsLaunched();
        WebElement menu = driver.findElement(By.xpath("//*[@id=\"ui-id-5\"]/span[1]"));

        Actions dropDown = new Actions(driver);
        dropDown.moveToElement(menu).perform();

        driver.findElement(By.id("ui-id-18")).click();

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("scrollBy (0,2500)");
    }

    @Then("user should be able to see the bottom of the page")
    public void userShouldBeAbleToSeeTheBottomOfThePage() {
       WebElement page =   driver.findElement(By.xpath("//*[@id=\"maincontent\"]/div[3]/div[1]/div[4]/div[2]/ul"));
       String pageScroll = page.getText();
       System.out.println(pageScroll);
       driver.quit();
    }

    @When("user launches browser and refreshes the page")
    public void userLaunchesBrowserAndRefreshesThePage() throws InterruptedException {
        theOnlineShoppingPortalIsLaunched();
        driver.navigate().refresh();
    }

    @Then("user should be able to see the page refreshed")
    public void userShouldBeAbleToSeeThePageRefreshed() {
        String page = driver.getTitle();
        System.out.println(page);
    }

    @Then("verify the successful registration message")
    public void verifyIfRegistrationIsSuccessfulOrNot() throws InterruptedException {
        Thread.sleep(2000);
        WebElement msg = driver.findElement(By.xpath("//*[@id=\"maincontent\"]/div[1]/div[2]/div/div/div"));
        String successfulMsg = msg.getText();
        System.out.println(successfulMsg);

        Assert.assertEquals("Thank you for registering with Fake Online Clothing Store.",successfulMsg);

    }
}

