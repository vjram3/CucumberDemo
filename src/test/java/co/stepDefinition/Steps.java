package co.stepDefinition;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import co.pageFactory.AddCustomerPage;
import io.cucumber.java.en.*;

public class Steps extends BaseClass{
	

	public WebDriver driver;
	
	@Given("User launches the chrome browser")
	public void user_launches_the_chrome_browser() {
	    System.setProperty("webdriver.chrome.driver", "C:\\Users\\manoj\\eclipse-workspace\\Cucumber_practice\\drivers\\chromedriver.exe");
	    driver=new ChromeDriver();
	    
	}

	@When("User opens the url {string}")
	public void user_opens_the_url(String string) {
	    driver.get(string);
	    
	}

	@When("User enters the ID as {string} and password as {string}")
	public void user_enters_the_id_as_and_password_as(String user, String pass) {
	    WebElement id = driver.findElement(By.id("Email"));
	    id.clear();
	    id.sendKeys(user);
	    WebElement pw = driver.findElement(By.id("Password"));
	    pw.clear();
	    pw.sendKeys(pass);
	    driver.manage().window().maximize();
	}

	@When("Click on Login")
	public void click_on_login() throws InterruptedException {
	    driver.findElement(By.xpath("//button[@type='submit']")).click();
	    Thread.sleep(3000);
	    
	}

	@Then("User can view the dashboard")
	public void user_can_view_the_dashboard() {
		addCust=new AddCustomerPage(driver);
		Assert.assertEquals("Dashboard / nopCommerce administration",addCust.getPageTitle());
	    /*String cUrl = driver.getCurrentUrl();
	    Assert.assertTrue(cUrl.equals("https://admin-demo.nopcommerce.com/Admin"));*/
	    System.out.println("Successfully Logged");
	}

	@When("User clicks on a customers menu")
	public void user_clicks_on_a_customers_menu() {
	    addCust.clickCustomerMenu();
	}

	@When("Click on customers items")
	public void click_on_customers_items() throws InterruptedException {
	    addCust.clickCustomerItemMenu();
	    Thread.sleep(2000);
	}

	@When("Click on Add new button")
	public void click_on_add_new_button() throws InterruptedException {
	    addCust.addNwBtn();
	    Thread.sleep(2000);
	}

	@Then("User can view Add new Customer Page")
	public void user_can_view_add_new_customer_page() {
		addCust=new AddCustomerPage(driver);
		Assert.assertEquals("Add a new customer / nopCommerce administration",addCust.getPageTitle());
	    System.out.println("Currently in Sign Up Page");
	}

	@When("User enter info")
	public void user_enter_info() throws InterruptedException {
		String email=randomString()+"@gmail.com";
		addCust.setEmail(email);
		addCust.setPasswd("test123");
		addCust.setFirstName("Vijay");
		addCust.setLastName("Katupilla");
		addCust.setDob("4/21/1996");
		addCust.genderBtn("Male");
		addCust.setCompanyName("Wipro");
		addCust.setCustomerRoles("Guests");
		Thread.sleep(2000);
		addCust.setManagerVendor("Vendor 1");
		addCust.setAdminComment("this is for testing");
		
	}

	@When("Click on save")
	public void click_on_save() throws InterruptedException {
	    addCust.savBtn();
	    Thread.sleep(2000);
	}

	@Then("user can view confirmation message {string}")
	public void user_can_view_confirmation_message(String text) {
	    Assert.assertTrue(driver.findElement(By.tagName("body")).getText().contains(text));
	}

	@Then("Close the page")
	public void close_the_page() {
	    driver.close();
	}


}
