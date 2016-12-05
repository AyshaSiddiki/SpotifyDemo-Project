package com.spotify.searchPage;

import java.util.Set;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.sikuli.script.Screen;
import org.testng.Assert;

//import org.sikuli.script.Screen;
import com.spotify.utils.Utils;




public class SpotifyPlayPage {
	WebDriver driver;

	public SpotifyPlayPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
		log.info("Elements initialized");
	}

	Utils util	= new Utils(driver);
	Logger	log		= Logger.getLogger(SpotifyPlayPage.class);
	
	@FindBy(xpath = ".//*[@id='carousel-tour']/ol/li[4]")
	WebElement	playStation;
	@FindBy(xpath = ".//*[@id='carousel-tour']/div/div[4]/a")
	WebElement	learnMore;
	@FindBy(xpath = "html/body/div[2]/div[13]/div/div/div/div[2]/a")
	WebElement	scrollDN;
	
	@FindBy(xpath = ".//*[@id='body']/div[4]/div/div/div[2]/div/div/div[1]/a/div[1]")
	WebElement	img;
	
	@FindBy(xpath = ".//*[@id='has-account']")
	WebElement	account;
	
	@FindBy(xpath = ".//*[@id='email']")
	WebElement	UserNameFB;

	@FindBy(xpath = ".//*[@id='pass']")
	WebElement	PasswordFB;
	
	@FindBy(xpath = ".//*[@id='recaptcha-anchor']/div[5]")
	WebElement	robotBox;
	
	@FindBy(xpath = ".//*[@id='sp-login-form']/div/button")
	WebElement	loginBox;
	
	@FindBy(xpath = ".//*[@id='u_0_2']")
	WebElement	loginButton;
	
	@FindBy(xpath = ".//*[@id='fb-signup-btn']")
	WebElement	signFacebook;
	
	@FindBy(xpath = ".//*[@id='email']")
	WebElement	UserNameTextBox;

	@FindBy(xpath = ".//*[@id='pass']")
	WebElement	PasswordTextBox;
	
	@FindBy(xpath = ".//*[@id='platformDialogForm']/div[3]/div/table/tbody/tr/td[2]/button[1]")
	WebElement	notNow;
	@FindBy(xpath = ".//*[@id='header']/header/section[1]/div[2]/div/button[1]")
	WebElement	playButton;
	@FindBy(xpath = ".//*[@id='nav-browse']")
	WebElement	browse;
	public void loginWithFacebook() throws Exception{
		
		util.click(playStation);
		util.waitForElement(1000);
		util.click(learnMore);
		util.waitForElement(3000);
		util.scrollDown(scrollDN);
		util.waitForElement(2000);
		util.click(scrollDN);
		util.click(img);
		String window = driver.getWindowHandle();
		util.click(signFacebook);	
		Set<String> moreWindow=driver.getWindowHandles();
		
		for(String newWindow : moreWindow){
			
			if(!newWindow.equals(window)){
				driver.switchTo().window(newWindow);
				util.waitForElement(2000);
				util.handleElement(UserNameFB).sendKeys("spotifydemo");
				util.waitForElement(1000);
				util.handleElement(PasswordFB).sendKeys("mina1234");
				util.waitForElement(1000);
				util.click(loginButton);
				util.waitForElement(1000);
				util.click(notNow);
				util.waitForElement(3000);
				
				util.click(browse);
				util.waitForElement(2000);
			
				try{
				Assert.assertTrue(driver.getTitle().contains("Web Player"));
				System.out.println("Title verify");
				}catch(Exception e){
					log.info("Title not verify");
				}
				//util.click(playButton);
			}			
		}
	}
	
	public void run() throws Throwable{
		
		Screen s = new Screen();
		
		util.click(playStation);
		
		util.click(learnMore);

		util.scrollDown(scrollDN);

		util.click(scrollDN);
		
		util.click(img);
		
		util.click(account);
		
		util.handleElement(UserNameTextBox).sendKeys("SpotifyDemo01@gmail.com");
			
		util.handleElement(PasswordTextBox).sendKeys("spotifydemo12");
				
		s.doubleClick("./videoImage/image.png");
			
		util.click(loginBox);
		
		
		
		
	}

}
