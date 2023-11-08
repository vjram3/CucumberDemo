package co.pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	public WebDriver ldriver;
	public LoginPage(WebDriver rDriver) {
		ldriver=rDriver;
		PageFactory.initElements(rDriver,this);
	}
	
	@FindBy(id="email")
	@CacheLookup
	WebElement txtEmail;
	
	@FindBy(id="pass")
	@CacheLookup
	WebElement txtPass;
	
	@FindBy(xpath="//button[@type='submit ")
	@CacheLookup
	WebElement login_btn;
	
    public void setUserName(String user) {
    	txtEmail.clear();
    	txtEmail.sendKeys(user);
    }
    
    public void setPassword(String pas) {
    	txtPass.clear();
    	txtPass.sendKeys(pas);
    }
    
    public void login() {
    	login_btn.click();
    }
}
