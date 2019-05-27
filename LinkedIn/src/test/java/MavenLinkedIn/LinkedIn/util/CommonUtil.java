package MavenLinkedIn.LinkedIn.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class CommonUtil {
	public static String getPropertyValue(String fn,String key) throws IOException
	{
		FileInputStream fis=new FileInputStream("./TestData/"+fn+".properties");
		Properties p=new Properties();
		p.load(fis);
		return p.getProperty(key);
	}
/*	public static void takeScreenshot(WebDriver driver) throws IOException
	{
		File scrFile=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(scrFile, new File("C:\\\\Users\\\\IBM_ADMIN\\\\Desktop\\\\selenium\\\\SaveFiles\\\\screenshot.png\""));
	}*/
}

