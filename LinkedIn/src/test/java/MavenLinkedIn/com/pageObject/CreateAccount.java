package MavenLinkedIn.com.pageObject;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class CreateAccount {
	private WebDriver driver = null;

	public CreateAccount(WebDriver driver) {
		this.driver = driver;
	}

	public void enterFirstName(String fn) {
		
		driver.findElement(By.xpath("//input[@placeholder='First Name']")).sendKeys(fn);
		
	}
	public void enterLastName(String ln) {
		
		driver.findElement(By.xpath("//input[@placeholder='Last Name']")).sendKeys(ln);
		
	}
	public void enterEmail(String email) {
	
		driver.findElement(By.xpath("//input[@placeholder='Email']")).sendKeys(email);
	
	}
	public void cName(String cn) {
	
		driver.findElement(By.xpath("//input[@placeholder='Company Name']")).sendKeys(cn);
	
	}
	public void enterPass(String pass) {
	
		driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys(pass);
	
	}
	public void enterCPass(String cPass) {
	
		driver.findElement(By.xpath("//input[@placeholder='Confirm Password']")).sendKeys(cPass);
	
	}
	public void clickSubmit() {
		
		driver.findElement(By.xpath("//div[@class='iq-button action-button action-button accent strong xl']")).click();
	
	}
	public void clickInstall()

	{
		
		driver.findElement(By.xpath("//div[@class='iq-button action-button action-button accent strong xl']//div[@class='container flex-center' and contains(text(),'Install')]")).click();
		//new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(install));
		
	}
	public void clickOnAddToChrome()
	{
		driver.findElement(By.xpath("//div[@class='g-c-R  webstore-test-button-label']//div[@class='g-c-R  webstore-test-button-label' and contains(text(),'Add to Chrome')]")).click();
	}

}
