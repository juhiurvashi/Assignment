package MavenLinkedIn.LinkedIn.testRunner;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import MavenLinkedIn.LinkedIn.util.BrowserFactory;
import MavenLinkedIn.LinkedIn.util.CommonUtil;
import MavenLinkedIn.com.pageObject.CreateAccount;

public class CreateAccountTestRunner {
	WebDriver driver;
	CreateAccount ca;
	
	@BeforeMethod
	public void preCondition() throws IOException
	{
		
		String bn=CommonUtil.getPropertyValue("config", "bname");
		String rn=CommonUtil.getPropertyValue("config", "rmode");
		String url=CommonUtil.getPropertyValue("config", "url");
		System.out.println(bn+" "+rn+" "+url);
		this.driver=BrowserFactory.openBrowser(bn, rn);
		ca=PageFactory.initElements(driver, CreateAccount.class);
		BrowserFactory.openURL(url);
		
	}
	
	@Test
	public void createAccount() throws IOException
	{
		String fn=CommonUtil.getPropertyValue("createAccountPage", "fn");
		String ln=CommonUtil.getPropertyValue("createAccountPage", "ln");
		String email=CommonUtil.getPropertyValue("createAccountPage", "email");
		String cName=CommonUtil.getPropertyValue("createAccountPage", "cName");
		String pass=CommonUtil.getPropertyValue("createAccountPage", "pass");
		String cPass=CommonUtil.getPropertyValue("createAccountPage", "cPass");
		ca.enterFirstName(fn);		
		ca.enterLastName(ln);
		ca.enterEmail(email);
		ca.cName(cName);
		ca.enterPass(cPass);		
		ca.enterCPass(cPass);
		ca.clickSubmit();
		ca.clickInstall();
	}
}
