package com.president;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Presidentgivenyear {
	
	WebDriver driver = null;
	
	//Crossbroswer Testing
	@Test
	@Parameters(value = "browser")
	public void president(String browsername) throws Exception
	{
		if(browsername.equalsIgnoreCase("firefox")) //Mozilla Browser
		{
			driver = new FirefoxDriver();
		}
		else if(browsername.equalsIgnoreCase("chrome")) //Chrome Browser
		{
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\driver\\chromedriver.exe");
			this.driver = new ChromeDriver();
		}
	//Maximize the Browser window
	driver.manage().window().maximize();
	
	//Go to potus-ui.herokuapp.com website
	driver.get("http://potus-ui.herokuapp.com");
	//Wait for 2 seconds to stay in home page
	Thread.sleep(2000);
	
	//////////////////////////////STORY 1////////////////////////////////
	//Click the Presidents by Year Hyperlink
	driver.findElement(By.linkText("Presidents by year")).click();
	
	//Select any Year from Dropdown For Ex: 1791.
	new Select(driver.findElement(By.xpath("//*[@id='year']"))).selectByVisibleText("1791");
	
	Thread.sleep(2000);

//////////////////////////////STORY 2////////////////////////////////
	//Click the Find the President By Name Hyperlink
	driver.findElement(By.linkText("Find Presidents by name")).click();
	
	//Enter the President Name in Search box
	WebElement searchname = driver.findElement(By.id("q"));
	searchname.sendKeys("Bush");
	
	//Click the Search Button
	driver.findElement(By.id("search-btn")).click();
	
	////////////////////////////////STORY 3/////////////////////////////////////
	
	Thread.sleep(2000);
	
	//Click the PresidentParties Hyperlink and display the Chart
		driver.findElement(By.linkText("Presidential parties")).click();
	
	Thread.sleep(4000);

	//Close the Browser
		driver.quit();
	}
	
	
}
