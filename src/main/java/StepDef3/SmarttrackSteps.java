package StepDef3;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Random;

public class SmarttrackSteps {

    public WebDriver driver;
    @BeforeMethod
    @Given("a Chrome browser is available")
    public void chrome_Browser_is_available () throws InterruptedException {
     System.setProperty("webdriver.chrome.driver","driver/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://na1.ccw.coupahost.com/Login");
        //driver.get("http://uitestingplayground.com/");
        sleep(3000);
    }

    public void sleep(int sleep) throws InterruptedException {
        Thread.sleep(sleep);
    }
    @Test(priority = 1)
    @When("login with correct credentials")
    public void login_with_Correct_Credentials () throws InterruptedException {
        driver.findElement(By.id("username")).sendKeys("bagavathi.rajan@capgemini.com");
        driver.findElement(By.xpath("//div[@class='col-sm-6 text-right']")).findElement(By.xpath("//button[@type='submit']")).click();
        sleep(2000);
        driver.findElement(By.id("password")).sendKeys("Barclays@2000");
        driver.findElement(By.xpath("//div[@class='col-sm-6 text-right']")).findElement(By.xpath("//button[@type='submit']")).click();
        sleep(10000);
    }
    @AfterMethod
    @And("logout and close the browser")
    public void logout_And_Close_The_Browser () throws InterruptedException {
        driver.findElement(By.xpath("//ul[@class='nav navbar-nav navbar-right']"));
        sleep(3000);
        driver.findElement(By.xpath("//span[@class='userName']")).findElement(By.xpath("//span[@class='caret']")).click();
        sleep(3000);
        driver.findElement(By.xpath("//span[@class='svgBg svg-logout pull-left']")).click();
        sleep(3000);
        driver.quit();
    }
    @Test(priority = 2)
    @Then("click on Create Timesheet and fill entry for a day")
    public void click_On_Creat_Timesheet_Fill_Entry () throws InterruptedException {
        //login_with_Correct_Credentials();
        driver.findElement(By.id("landingPage")).findElement(By.xpath("//a[@class='ng-tns-c1-0 animated bounceInDown shortCut time']")).click();
        sleep(6000);
        driver.findElement(By.id("tdddl1")).findElement(By.id("txtGen1")).sendKeys("DCI UK Testing - BAU");
        sleep(2000);

        Select dropDown = new Select(driver.findElement(By.id("DefaultContent_CboHoursType")));
        sleep(2000);
        dropDown.selectByVisibleText("Regular Hours");
        sleep(2000);
        driver.findElement(By.id("DefaultContent_btnAddTask")).click();
        sleep(4000);
        //driver.findElement(By.id("DefaultContent_divMain")).findElement(By.id("DefaultContent_trgrid")).findElement(By.xpath("//tr[@class='rowStyle odd']"));
        //sleep(2000);
        driver.findElement(By.id("txtH22")).sendKeys("08:00");
        sleep(10000);
        driver.findElement(By.id("txtH32")).sendKeys("08:00");
        sleep(4000);
        driver.findElement(By.id("txtH42")).sendKeys("08:00");
        sleep(10000);
        driver.findElement(By.id("txtH52")).sendKeys("08:00");
        sleep(4000);
        driver.findElement(By.id("txtH62")).sendKeys("08:00");
        sleep(4000);

    }
    @And("save the timesheet")
    public void save_Timesheet () throws InterruptedException {
        driver.findElement(By.id("tdSave")).findElement(By.id("DefaultContent_btnSave")).click();
        sleep(3000);
        driver.findElement(By.cssSelector("body > div.ui-dialog.ui-widget.ui-widget-content.ui-draggable.ui-resizable.dialogTop > div.ui-dialog-buttonpane.ui-widget-content.ui-helper-clearfix > div > button")).click();
        sleep(3000);
    }


    @When("the website is launched")
    public void theWebsiteIsLaunched() throws InterruptedException {
        driver.get("http://uitestingplayground.com/");
        sleep(3000);

    }

    @Then("click on Scrollbar hyperlink")
    public void clickOnScrollbarHyperlink() throws InterruptedException {
        driver.findElement(By.id("overview")).findElement(By.xpath("//*[@id=\"overview\"]/div/div[3]")).findElement(By.linkText("Scrollbars")).click();
        sleep(3000);
    }

    @And("on new window search for hidden button and click")
    public void onNewWindowSearchForHiddenButtonAndClick() throws InterruptedException {
        driver.findElement(By.id("hidingButton")).click();
        sleep(4000);
        driver.quit();
    }
}
