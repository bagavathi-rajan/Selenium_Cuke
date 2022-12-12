package StepDef3;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class sauceDemo {

public WebDriver driver;

    @Given("a Chrome browser is available for test")
    public void aChromeBrowserIsAvailableForTest() {
        System.setProperty("webdriver.chrome.driver","driver/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @When("the website is successfully entered with correct credentials")
    public void theWebsiteIsSuccessfullyEntered() throws InterruptedException {
        driver.get("https://www.saucedemo.com/");
        Thread.sleep(3000);
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();
        Thread.sleep(3000);
    }

    @Then("search for filters in the screen")
    public void searchForFiltersInTheScreen() throws InterruptedException {
        driver.findElement(By.className("header_secondary_container")).findElement(By.className("right_component")).findElement(By.className("select_container")).click();
        Thread.sleep(3000);
    }
    @And("filter with ascending order")
    public void filterWithAscendingOrder() throws InterruptedException {
        Select options = new Select(driver.findElement(By.xpath("//*[@id=\"header_container\"]/div[2]/div[2]/span/select/option[1]")));
        options.selectByIndex(1);
        //driver.findElement(By.xpath("//*[@id=\"header_container\"]/div[2]/div[2]/span/select/option[1]")).click();
        Thread.sleep(4000);
    }
    @And("filter with descending order")
    public void filterWithDescendingOrder() throws InterruptedException {
        driver.findElement(By.className("header_secondary_container")).findElement(By.className("right_component")).findElement(By.className("select_container")).click();
        driver.findElement(By.xpath("//*[@id=\"header_container\"]/div[2]/div[2]/span/select/option[2]")).click();
        Thread.sleep(4000);
    }
    @And("filter with low to high order")
    public void filterWithLowToHighOrder() throws InterruptedException {
        driver.findElement(By.className("header_secondary_container")).findElement(By.className("right_component")).findElement(By.className("select_container")).click();
        driver.findElement(By.xpath("//*[@id=\"header_container\"]/div[2]/div[2]/span/select/option[3]")).click();
        Thread.sleep(4000);
    }
    @And("filter with high to low order")
    public void filterWithHighToLowOrder() throws InterruptedException {
        driver.findElement(By.className("header_secondary_container")).findElement(By.className("right_component")).findElement(By.className("select_container")).click();
        driver.findElement(By.xpath("//*[@id=\"header_container\"]/div[2]/div[2]/span/select/option[4]")).click();
        Thread.sleep(4000);
    }
    @And("logout from the session")
    public void logoutFromTheSession() throws InterruptedException {
        driver.findElement(By.id("react-burger-menu-btn")).click();
        Thread.sleep(2000);
        driver.findElement(By.id("logout_sidebar_link")).click();
        Thread.sleep(3000);
        driver.quit();
    }
}
