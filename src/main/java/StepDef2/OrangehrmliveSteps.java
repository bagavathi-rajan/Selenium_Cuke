package StepDef2;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class OrangehrmliveSteps {
    public WebDriver driver;

    @Given("Chrome browser is available")
    public void chrome_browser_available () throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","driver/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        Thread.sleep(3000);
    }
//
//    @When("login with correct credentials")
//    public void loginWithCorrectCredentials() throws InterruptedException {
//        driver.findElement(By.name("username")).sendKeys("Admin");
//        driver.findElement(By.name("password")).sendKeys("admin123");
//        driver.findElement(By.xpath("//button[@type='submit']")).click();
//        Thread.sleep(6000);
//    }

    @And("click on logout")
    public void clickOnLogout() throws InterruptedException{
        Thread.sleep(2000);
        driver.quit();
    }

    @Then("access the timesheet menu and click employee record dropdown")
    public void accessTheTimesheetMenuAndClickEmployeeRecordDropdown() throws InterruptedException {
        driver.findElement(By.xpath("//button[@class='oxd-icon-button orangehrm-quick-launch-icon']")).findElement(By.xpath("//button[@title='Timesheets']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//span[@class='oxd-topbar-body-nav-tab-item']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//i[@class='oxd-icon bi-chevron-down']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[1]/header/div[2]/nav/ul/li[1]/ul/li[2]/a")).click();
        Thread.sleep(3000);
    }

    @And("choose name from employee list and click on view")
    public void chooseNameFromEmployeeListAndClickOnView() throws InterruptedException {
        //Select name = new Select( driver.findElement(By.xpath("//div[@class='oxd-autocomplete-text-input--before']")));
        //Select name = new Select( driver.findElement(By.xpath("//label[@class='oxd-autocomplete-text-input oxd-autocomplete-text-input--active']")));
        Select name = new Select(driver.findElement(By.partialLinkText("Employee Name")));
        //Select name = new Select( driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[1]/form/div[1]/div/div/div/div[1]/select")));
        name.selectByVisibleText("Paul Collings");
        Thread.sleep(6000);
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        Thread.sleep(5000);
    }
}



