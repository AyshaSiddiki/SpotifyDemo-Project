package com.spotify.searchPage;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.spotify.loginPage.LogInScenarioSpotify;
import com.spotify.utils.Utils;

public class Scenario 
{
	WebDriver	driver;
	

	public Scenario(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	Utils	util;
	Logger	log	= Logger.getLogger(Scenario.class);
	
	
	@FindBy(xpath = ".//*[@id='nav-link-help']")
	WebElement	helpMadule;
	
	@FindBy(xpath = "//ul[@class='nav navbar-nav navbar-right nav-main']/li[2]/a")
	WebElement	premiumMadule;
	
	public LogInScenarioSpotify loginPage() throws Throwable{
		
		return new LogInScenarioSpotify(driver);
	}
	
	
	public SpotifyPlayPage spoty() throws Throwable{
		
		return new SpotifyPlayPage(driver);
	}
	public HelpPage search() throws Exception
	{
		util = new Utils(driver);
		util.waitForElement(3000);
		util.click(helpMadule);
		return new HelpPage(driver);
	}
	
	public PremiumPage prem() throws Exception
	{
		
		util = new Utils(driver);
		util.waitForElement(3000);
		util.click(premiumMadule);

		return new PremiumPage(driver);
	}
	
}
