 package co.pageFactory;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class AddCustomerPage {
	public WebDriver ldriver;
	public AddCustomerPage(WebDriver rDriver) {
		ldriver=rDriver;
		PageFactory.initElements(rDriver,this);
	}
	
	By lnkCustomers= By.xpath("//a[@href='#']//p[contains(text(),'Customers')]");
	By lnkCustomers_menu= By.xpath("//li[@class='nav-item']//p[text()[normalize-space()='Customers']]");
    By addNewBtn= By.xpath("//a[@class='btn btn-primary']");
    By emailBlock= By.id("Email");
    By pwdBlock= By.id("Password");
    By firstName= By.id("FirstName");
    By lastName= By.id("LastName");
    By male= By.id("Gender_Male");
    By female= By.id("Gender_Female");
    By companyName= By.id("Company");
    By dob= By.id("DateOfBirth");
    
    By customerRoles= By.xpath("(//div[@class='k-multiselect-wrap k-floatwrap'])[2]");
    By administrationRole= By.xpath("//li[contains(text(),'Administrators')]");
    By forumRole= By.xpath("//li[contains(text(),'Forum Moderators')]");
    By guestRole= By.xpath("//li[contains(text(),'Guests')]");
    By registerRole= By.xpath("//li[contains(text(),'Registered')]");
    By vendorRole= By.xpath("//li[contains(text(),'Vendor')]");
    
    By vendorSelect= By.id("VendorId");
    By adminComment= By.id("AdminComment");
    By saveBtn= By.xpath("(//button[@type='submit'])[2]");
    
    public String getPageTitle() {
    	
		return ldriver.getTitle();
    }
    
    public void clickCustomerMenu() {
    	ldriver.findElement(lnkCustomers).click();
    }
    
    public void clickCustomerItemMenu() {
    	ldriver.findElement(lnkCustomers_menu).click();
    }
    
    public void addNwBtn() {
    	ldriver.findElement(addNewBtn).click();
    }
    
    public void setEmail(String email) {
    	ldriver.findElement(emailBlock).sendKeys(email);
    }
    
    public void setPasswd(String pass) {
    	ldriver.findElement(pwdBlock).sendKeys(pass);
    }
    
    public void setFirstName(String fstName) {
    	ldriver.findElement(firstName).sendKeys(fstName);
    }
    
    public void setLastName(String lstName) {
    	ldriver.findElement(lastName).sendKeys(lstName);
    }
    
    public void setDob(String Dob) {
    	ldriver.findElement(dob).sendKeys(Dob);
    }
    
    public void genderBtn(String value) {
    	if(value.equals("Male")) {
    		ldriver.findElement(male).click();
    	}
    	else if(value.equals("Female")) {
    		ldriver.findElement(female).click();
    	}
    	else {
    		ldriver.findElement(male).click();
    	}
    }
    
    public void setCompanyName(String comp) {
    	ldriver.findElement(companyName).sendKeys(comp);
    }
    
    public void setCustomerRoles(String role) {
    	if(!role.equals("Vendor")) {
    		ldriver.findElement(By.xpath("//span[@title='delete']")).click();
    	}
    	ldriver.findElement(customerRoles).click();
    	
    	WebElement listItems;
    	if(role.equals("Administrators")) {
    		listItems= ldriver.findElement(administrationRole);
    	}
    	else if(role.equals("Forum Moderators")) {
    		listItems= ldriver.findElement(forumRole);
    	}
    	else if(role.equals("Guests")) {
    		listItems= ldriver.findElement(guestRole);
    	}
    	else if(role.equals("Registered")) {
    		listItems= ldriver.findElement(registerRole);
    	}
    	else {
    		listItems= ldriver.findElement(vendorRole);
    	}
    	
    	listItems.click();
    }
    
    public void setManagerVendor(String value) {
    	Select s=new Select(ldriver.findElement(vendorSelect));
    	s.selectByVisibleText(value);
    }
    
    public void setAdminComment(String cmnt) {
    	ldriver.findElement(adminComment).sendKeys(cmnt);
    }
    
    public void savBtn() {
    	ldriver.findElement(saveBtn).click();
    }
    

}
