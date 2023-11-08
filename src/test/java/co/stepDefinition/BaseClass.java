package co.stepDefinition;

import co.pageFactory.AddCustomerPage;
import co.pageFactory.LoginPage;
import org.apache.commons.lang3.RandomStringUtils;

public class BaseClass {
	
public LoginPage lp;
public AddCustomerPage addCust;

public static String randomString() {
	String randomAlphabetic1 = RandomStringUtils.randomAlphabetic(5);
	return randomAlphabetic1;
}

}
