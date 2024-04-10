package pages;

import io.cucumber.java.bs.A;
import lombok.Data;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;


@Data
public class UserDetailsPage {

    public UserDetailsPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }



    @FindBy (name =  "email")
    private WebElement emailField;

    @FindBy (xpath =  "//button[.='SAVE']")
    private WebElement saveButton;

    @FindBy (xpath =  "//span[.='Update successful']")
    private WebElement successMessage;





    public void updateEmail(String newEmail) throws InterruptedException {

        new Actions(Driver.getDriver()).
                click(emailField).
                click(emailField).
                click(emailField).
                sendKeys(Keys.BACK_SPACE).perform();


        emailField.sendKeys(newEmail);



        saveButton.click();



    }






}
