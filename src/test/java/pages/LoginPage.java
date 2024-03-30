package pages;

import lombok.Data;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.ConfigReader;
import utilities.Driver;
@Data
public class LoginPage {

    public LoginPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy (id = "loginUsername")
    private WebElement usernameField;

    @FindBy (id = "hideLogin")
    private WebElement signUpLink;


    public void login(){
       usernameField.
                sendKeys(ConfigReader.getProperty("username"),
                        Keys.TAB,
                        ConfigReader.getProperty("password"),
                        Keys.ENTER);
    }

    public void login(String username, String password){
        usernameField.
                sendKeys(username,
                        Keys.TAB,
                        password,
                        Keys.ENTER);
    }


}
