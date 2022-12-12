package StepDefinition;


//import org.junit.Test;
import net.bytebuddy.utility.RandomString;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.Random;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.support.ui.Select;


import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.en.And;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;



public class Steps {

    private WebDriver driver;

    @BeforeTest
    @Given("Open the Chrome and launch the application")
    public void open_the_Chrome_and_launch_the_application () throws Throwable
    {
        System.setProperty("webdriver.chrome.driver","driver/chromedriver.exe");
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://gateways-toolbox-dev.cf-ssb-z3-dev.discoverfinancial.com/#!/login");
        //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        sleep(1000);

    }
    private void sleep(long millisecs) {
        try {
            Thread.sleep(millisecs);
        } catch (InterruptedException e){
            e.printStackTrace();
        }
    }

    @When("Enter the Username and Password")
    public void enter_the_Username_and_Password () throws Throwable
    {
        driver.findElement(By.id("username")).sendKeys("wseng09");
        driver.findElement(By.id("password")).sendKeys("wordpass");
    }

    @AfterTest
    @Then("Click on Sign in")
    public void click_on_signin () throws Throwable {
        driver.findElement(By.className("login-submit")).click();
        //driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        sleep(10000);
    }
    @And("Navigate to client node ID page")
    public void navigate_to_channels_page () throws Throwable {
        driver.findElement(By.id("connectionsDropdown")).click();
        driver.findElement(By.id("clientNodeID")).click();
        sleep(3000);
    }
    @And("Filter with client node ID")
    public void filter_with_local_port () throws Throwable {
        driver.findElement(By.id("filterButton")).click();
        sleep(3000);
        driver.findElement(By.id("clientNodeId")).click();
        sleep(5000);

        Select clientNodeId = new Select(driver.findElement(By.id("clientNodeId")));
        clientNodeId.selectByVisibleText("[11B1] Windcave");
        driver.findElement(By.id("searchButton")).click();
        sleep(3000);
        clientNodeId.selectByIndex(5);
        driver.findElement(By.id("searchButton")).click();
        sleep(3000);
    }
    @Test
    @And("Click on logout")
    public void click_on_logout () throws Throwable {
        driver.findElement(By.id("logout")).click();
        sleep(5000);
        driver.quit();
    }

    @Given("Chrome browser is available")
    public void chromeBrowserIsAvailable() {
        System.setProperty("webdriver.chrome.driver","driver/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://gateways-toolbox-dev.cf-ssb-z3-dev.discoverfinancial.com/#!/login");
        sleep(3000);
    }

    @When("credentials are entered and signed in")
    public void correctCredentialsAreEnteredAndSignedIn() {
        driver.findElement(By.id("username")).sendKeys("wseng09");
        driver.findElement(By.id("password")).sendKeys("wordpass");
        driver.findElement(By.className("login-submit")).click();
        sleep(3000);
    }

    @Then("Navigate to Channels page")
    public void navigateToChannelsPage() {
        driver.findElement(By.id("connectionsDropdown")).click();
        driver.findElement(By.id("channels")).click();
        driver.findElement(By.id("filterButton")).click();
    }

    @And("Filter with Local Port and click on search")
    public void filterWithLocalPortAndClickOnSearch() {
        Select swimlaneName = new Select(driver.findElement(By.id("swimlane")));
        swimlaneName.selectByVisibleText("YELLOW1 [Static Swimlane]");
        driver.findElement(By.id("serverPort")).sendKeys("7949");
        sleep(3000);

        WebElement checkbox = driver.findElement(By.id("inactive"));
        if (!checkbox.isSelected()){
            checkbox.click();
        }
        sleep(2000);

        WebElement uncheckbox = driver.findElement(By.id("active"));
         if (uncheckbox.isSelected()){
             uncheckbox.click();
         }
        sleep(1000);
//        else {
//            checkbox.clear();
//        }
        driver.findElement(By.id("searchButton")).click();
        sleep(3000);
    }

    @Then("Navigate to IICGroup page")
    public void navigateToIICGroupPage() {
        driver.findElement(By.id("connectionsDropdown")).click();
        driver.findElement(By.id("iICGroup")).click();
        sleep(3000);
    }

    @And("add new record in IICGroup and save")
    public void addNewRecordInIICGroupAndSave() {
        driver.findElement(By.id("addButton")).click();
        sleep(2000);
        driver.findElement(By.id("groupName")).sendKeys("TEST999");
        sleep(2000);
        driver.findElement(By.id("newIIC")).sendKeys("00765432111");
        sleep(2000);
        driver.findElement(By.tagName("button")).findElement(By.xpath("//button[@data-ng-click='addIIC()']")).click();
        sleep(2000);
        driver.findElement(By.id("save")).click();
        sleep(2000);
    }

    @And("verify if newly added record is visible in main page")
    public void verifyIfNewlyAddedRecordIsVisibleInMainPage() {
        driver.findElement(By.id("groupName")).sendKeys("TEST999");
        driver.findElement(By.id("searchButton")).click();
        sleep(3000);

    }

    @Then("delete the newly added entry using action menu")
    public void deleteTheNewlyAddedEntryUsingActionMenu() {
        driver.findElement(By.id("actionsMenu")).click();
        sleep(2000);
        driver.findElement(By.xpath("//span[@class='glyphicon glyphicon-remove']")).click();
        sleep(2000);
        Alert alert = driver.switchTo().alert();
        alert.accept();
        sleep(3000);
        driver.quit();
    }

}

