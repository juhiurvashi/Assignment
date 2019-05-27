package MavenLinkedIn.LinkedIn.testRunner;

import static org.testng.Assert.assertTrue;

import java.awt.RenderingHints.Key;
import java.io.File;
import java.io.IOException;
import java.sql.Driver;
import java.util.Set;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import MavenLinkedIn.LinkedIn.util.CommonUtil;

import org.sikuli.script.App;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Match;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;

public class AddExtensionTestRunner {
	@Test
	public void leadIQAppLaunch() throws IOException, FindFailed
	{
		
		WebDriver driver=null;
		System.setProperty("webdriver.chrome.driver", ".//BrowserExe/chromedriver.exe");
		//WebDriver driver1=new ChromeDriver();
		//driver1.get("https://www.linkedin.com/in/urvashi-gupta-294001123/");
		ChromeOptions chromeOptions=new ChromeOptions();
		chromeOptions.addExtensions(new File(".//CRXFile/LeadIQ-Lead-Capture_v5.0.2.crx"));
		DesiredCapabilities dc=DesiredCapabilities.chrome();
		dc.setCapability(chromeOptions.CAPABILITY, chromeOptions);
		driver=new ChromeDriver(chromeOptions);
		
		// Creating object to the Sukali screen class
        Screen s=new Screen();

        //Finding and clicking on the Addon image
         try {
            s.find(".//CRXFile/AddOnIcon.png");
            s.click(".//CRXFile/AddOnIcon.png");
        } catch (FindFailed e) {            
            e.printStackTrace();
        }

        //Wait until new Addon popup is opened.
         WebDriverWait wait = new WebDriverWait(driver, 10);      
         wait.until(ExpectedConditions.numberOfWindowsToBe(2));

         // Switch to the Addon Pop up
         String parentWindow= driver.getWindowHandle();
         Set<String> allWindows = driver.getWindowHandles();
         for(String curWindow : allWindows){             
             if(!parentWindow.equals(curWindow))
             {
            	 System.out.println("switched to LeadIQ");
            	 driver.switchTo().window(curWindow);
             }
           String title2=driver.getTitle();
            System.out.println(driver.getTitle());
            s.find(".//CRXFile/AddOnIcon.png");
            Assert.assertEquals("not mtched", "LeadIQ", title2);
            Match img1 = s.exists(".//CRXFile/AddOnIcon.png");
            assertTrue(img1 != null);
          
         }
         
	}
	@Test
	public void extension()
	{
		
		
	}
}
