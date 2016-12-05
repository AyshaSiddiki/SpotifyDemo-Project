package com.spotify.loginPage;



import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.sikuli.script.Screen;
import org.testng.Assert;

import com.spotify.utils.Utils;




public class LogInScenarioSpotify 
{

	WebDriver	driver;
	

	public LogInScenarioSpotify(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	Utils	util;
	Logger	log	= Logger.getLogger(LogInScenarioSpotify.class);
	
	
	@FindBy(xpath = "//li[@class='alternate sidepanel-item-small']/a/span")
	WebElement	LogInButton;
	
	@FindBy(xpath = "//div[@class='content']/form/div/div/input[@id='login-username']")
	WebElement	UserNameTextBox;

	@FindBy(xpath = "//div[@class='content']/form/div/div/input[@id='login-password']")
	WebElement	PasswordTextBox;
	
	@FindBy(xpath = "//div[@class='col-xs-12 col-sm-6']/div/label/span")
	WebElement	RememberMeCheckBox;
	
	@FindBy(xpath = "//span[text()='spotifydemo01']")
	WebElement	UserText;
	
	@FindBy(xpath = "//div[@class='row row-submit']/div[@class='col-xs-12 col-sm-6']/button")
	WebElement	LogIn;
	
	@FindBy(xpath = "//span[text()='Incorrect username or password.']")
	WebElement	ErrorMessage;
	
	@FindBy(xpath = "//li[@class='dropdown alternate hidden-sidepanel open']/a/div")
	WebElement	Name;
	
	@FindBy(xpath = "//ul[@class='dropdown-menu dropdown-menu-right']/li[2]/a[text()='Log Out']/")
	WebElement	logOut;
	
	
	
	public void validLogin() throws Throwable
	{
		
		util = new Utils(driver);
		util.waitForElement(3000);
		Screen s = new Screen();
		s.doubleClick("/SpotifyDemo/videoImage/login.png");
		log.info("Clicked login with sikuli");
		util.handleElement(UserNameTextBox).sendKeys("SpotifyDemo01@gmail.com");
		util.handleElement(PasswordTextBox).sendKeys("spotifydemo12");
		util.click(RememberMeCheckBox);
		util.handleElement(LogIn).click();
		Assert.assertTrue(util.handleElement(UserText).isDisplayed());
		log.info("User name displaied");
		util.click(Name);
		util.waitForElement(3000);
		util.click(logOut);
		
		
	}
	
	public void validInvalidLogin()
	{
		util = new Utils(driver);
		util.click(LogInButton);
		util.handleElement(UserNameTextBox).sendKeys("AyshaSiddiki");
		util.handleElement(PasswordTextBox).sendKeys("selenium");
		util.handleElement(LogIn).click();
		Assert.assertTrue(util.handleElement(ErrorMessage).isDisplayed());
		
		
	}
	
}
