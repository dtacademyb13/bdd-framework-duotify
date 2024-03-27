package pages;

import lombok.Data;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

@Data
public class HomePage {

    public HomePage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//nav[@class='navBar']//span[@class='navItemLink']")
    private List<WebElement> links;

    @FindBy(tagName = "h6")
    private WebElement welcomeMessage;
}
