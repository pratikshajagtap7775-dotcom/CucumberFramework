package stepDefinitions;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import Utils.TestContextSetUp;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Scenario;

public class Hooks {
	TestContextSetUp testContextSetUp;
	
	public Hooks(TestContextSetUp testContextSetUp)
	{
		this.testContextSetUp = testContextSetUp;
	}
	
	@After
	public void AfterScenario()
	{
		testContextSetUp.testBase.driver.quit();
	}
	
	@AfterStep
	public void AddScreenshot(Scenario scenario) throws IOException
	{
		WebDriver driver = testContextSetUp.testBase.WebDriverManager();
		if(scenario.isFailed())
		{
			File srcpath = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			byte[] fileContent = FileUtils.readFileToByteArray(srcpath);
			scenario.attach(fileContent, "image/png", "image");
		}
	}

}
