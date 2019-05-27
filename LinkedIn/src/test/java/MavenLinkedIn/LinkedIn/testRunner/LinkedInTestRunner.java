package MavenLinkedIn.LinkedIn.testRunner;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.reporters.Files;

import MavenLinkedIn.LinkedIn.util.BrowserFactory;
import MavenLinkedIn.LinkedIn.util.CommonUtil;
import MavenLinkedIn.com.pageObject.CreateAccount;

public class LinkedInTestRunner {
		WebDriver driver;
		CreateAccount hp;
		
		@BeforeMethod
		public void preCondition() throws IOException
		{
			
			String bn=CommonUtil.getPropertyValue("config", "bname");
			String rn=CommonUtil.getPropertyValue("config", "rmode");
			String url=CommonUtil.getPropertyValue("config", "url");
			System.out.println(bn+" "+rn+" "+url);
			this.driver=BrowserFactory.openBrowser(bn, rn);
			hp=PageFactory.initElements(driver, CreateAccount.class);
			BrowserFactory.openURL(url);
			
		}
		
		@Test
		public void CheckTitle() throws IOException
		{
			String exp_title=CommonUtil.getPropertyValue("config", "exp_title");
			System.out.println(exp_title);
			if(exp_title.equalsIgnoreCase("Urvashi Gupta-Singapore|Professional Profile|LinkedIn"));
			{
				System.out.println("Pass");
			}
			System.out.println("Actual title= "+driver.getTitle());
			//Assert.assertEquals(exp_title, driver.getTitle());
			driver.findElement(By.xpath("//a[contains(text(),'Sign in')]")).click();
			WebElement uname=driver.findElement(By.xpath("//input[@id='username']"));
			uname.sendKeys("juhiurvashi@gmail.com");
			WebElement pass=driver.findElement(By.xpath("//input[@id='password']"));
			pass.sendKeys("juhi0903");
			driver.findElement(By.xpath("//button[contains(@type,'submit')]")).click();
			driver.findElement(By.xpath("//span[@class='nav-item__title' and contains(text(),'Jobs')]")).click();
			WebElement searchJobs=driver.findElement(By.xpath("//input[contains(@aria-label,'Search jobs')]"));
			searchJobs.click();
			searchJobs.sendKeys("Test Analyst");
			WebElement searchLoc=driver.findElement(By.xpath("//input[contains(@aria-label,'Search location')]"));
			searchLoc.click();
			searchLoc.sendKeys("Singapore");
		    driver.findElement(By.xpath("//button[contains(@text,'Search')]")).click();
		    /*File scrFile=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		    FileUtils.copyFile(scrFile,new File(""));*/
		
			
		}
		@Test
		public void xpath()
		{
			
		}
		@Test
		public void css()
		{
			
		}
		@AfterMethod
		public void closeBrow()
		{
			//driver.close();
		}
	}
