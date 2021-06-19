package com.test.praneetha;

import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.Before;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;

public class stepdefs {
    WebDriver driver;

    @Before
    public void setup(Scenario Name) {
        System.out.println("************Before Test*******");
        driver = utilities.Open("Chrome");
        driver.get("http://automationpractice.com/index.php");
        driver.manage().window().maximize();
        System.out.println("Name: " + Name.getName());
        System.out.println("Status : " + Name.getStatus());
    }


    @Given("the user lands on t-shirt page home page")
    public void the_user_lands_on_t_shirt_page_home_page() {
        System.out.println("testing");
    }

    @Given("the user adds a t-shirt to the cart")
    public void the_user_adds_a_t_shirt_to_the_cart() {
        System.out.println(driver.getTitle());
        driver.findElement(By.xpath("//*[@id=\"block_top_menu\"]/ul/li[3]/a")).click();
    }

    @When("and the user checks out the T-shirt")
    public void and_the_user_checks_out_the_t_shirt() throws InterruptedException, AWTException {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,500)");
        addToCart();
        checkout();
    }

    @When("the user verifies the order history")
    public void the_user_verifies_the_order_history() {
        orderHistory();
    }

    @Then("the page should display (.*) message on the page$")
    public void the_page_should_display_message_on_the_page(String expectedMsg) {
        String historyMsg = driver.findElement(By.xpath("//*[@id=\"center_column\"]/p")).getText();
        Assert.assertEquals(expectedMsg, historyMsg);
    }

    @Given("the user signsIn to the account")
    public void the_user_signs_in_to_the_account() {
      driver.findElement(By.xpath("/html/body/div/div[1]/header/div[2]/div/div/nav/div[1]/a")).click();
        signIn();
    }

    @Given("user clicks My Personal Information tab")
    public void user_clicks_my_personal_information_tab() {
        driver.findElement(By.xpath("/html/body/div/div[2]/div/div[3]/div/div/div[1]/ul/li[4]/a")).click();
    }

    @Given("user lands on Your personal Information page")
    public void user_lands_on_your_personal_information_page() {
       String personalPageTitle = "YOUR PERSONAL INFORMATION";
       String pageTitle = driver.findElement(By.xpath("//*[@id=\"center_column\"]/div/h1")).getText();
    Assert.assertEquals(personalPageTitle,pageTitle);
    }

    @When("user edits and enters (.*) on first name and fills restof information$")
    public void user_edits_and_enters_on_first_name_and_fills_restof_infomation(String diffName) {
        driver.findElement(By.id("firstname")).clear();
        driver.findElement(By.id("firstname")).sendKeys(diffName);
        driver.findElement(By.id("old_passwd")).sendKeys("123456");
    }

    @When("user clicks save")
    public void user_clicks_save() {
       driver.findElement(By.xpath("//*[@id=\"center_column\"]/div/form/fieldset/div[11]/button")).click();
    }

    @Then("the user can see (.*) message on the page$")
    public void the_user_can_see_message_on_the_page(String actualMsg) {
        String successMsg = driver.findElement(By.xpath("//*[@id=\"center_column\"]/div/p")).getText();
        Assert.assertEquals(successMsg,actualMsg);
    }

    public void addToCart() throws AWTException, InterruptedException {
        Actions actions = new Actions(driver);
        WebElement image = driver.findElement(By.xpath("//*[@id=\"center_column\"]/ul/li/div/div[1]/div/a[1]"));
        //Mouse hover on the image
        actions.moveToElement(image).perform();
        System.out.println("Done Mouse hover on image");
        WebElement subMenuOption = driver.findElement(By.xpath("//*[@id=\"center_column\"]/ul/li/div/div[2]/div[2]/a[1]"));
        subMenuOption.click();
        Thread.sleep(5000);
        driver.findElement(By.xpath("/html/body/div/div[1]/header/div[3]/div/div/div[4]/div[1]/div[2]/div[4]/a")).click();
    }

    public void checkout() throws InterruptedException {
        driver.findElement(By.xpath("/html/body/div/div[2]/div/div[3]/div/p[2]/a[1]")).click();
        signIn();
        driver.findElement(By.xpath("//*[@id=\"center_column\"]/form/p/button")).click();
        driver.findElement(By.id("cgv")).click();
        driver.findElement(By.xpath("//*[@id=\"form\"]/p/button")).click();
        driver.findElement(By.xpath("/html/body/div/div[2]/div/div[3]/div/div/div[3]/div[2]/div/p/a")).click();
        driver.findElement(By.xpath("//*[@id=\"cart_navigation\"]/button")).click();
        String confirmMsg = driver.findElement(By.xpath("//*[@id=\"center_column\"]/p[1]")).getText();
        System.out.println(confirmMsg);
        Assert.assertEquals("Your order on My Store is complete.", confirmMsg);
    }

    public void register() {
        driver.findElement(By.xpath("/html/body/div/div[1]/header/div[2]/div/div/nav/div[1]/a")).click();
        driver.findElement(By.id("email_create")).sendKeys("praneethatest.n@gmail.com");
        driver.findElement(By.id("SubmitCreate")).click();
        driver.findElement(By.id("id_gender2")).click();
        driver.findElement(By.id("customer_firstname")).sendKeys("praneetha");
        driver.findElement(By.id("customer_lastname")).sendKeys("neyyala");
        driver.findElement(By.id("passwd")).sendKeys("123456");

// Create object of the Select class
        Select days = new Select(driver.findElement(By.xpath("//*[@id='days']")));
        Select months = new Select(driver.findElement(By.xpath("//*[@id='months']")));
        Select years = new Select(driver.findElement(By.xpath("//*[@id='years']")));

        days.selectByValue("3");
        months.selectByValue("7");
        years.selectByValue("1992");
        driver.findElement(By.id("firstname")).sendKeys("praneetha");
        driver.findElement(By.id("lastname")).sendKeys("neyyala");
        driver.findElement(By.id("company")).sendKeys("Testing");
        driver.findElement(By.id("address1")).sendKeys("34 Northroad");
        driver.findElement(By.id("city")).sendKeys("spearCity");
        driver.findElement(By.id("postcode")).sendKeys("00000");
        driver.findElement(By.id("phone")).sendKeys("9988776655");
        driver.findElement(By.id("register")).click();
    }

    public void signIn() {
        driver.findElement(By.id("email")).sendKeys("praneethatest.n@gmail.com");
        driver.findElement(By.id("passwd")).sendKeys("123456");
        driver.findElement(By.id("SubmitLogin")).click();
    }

    public void orderHistory() {
        driver.findElement(By.xpath("/html/body/div/div[1]/header/div[2]/div/div/nav/div[1]/a")).click();
        driver.findElement(By.xpath("//*[@id=\"center_column\"]/div/div[1]/ul/li[1]/a")).click();

    }


}
