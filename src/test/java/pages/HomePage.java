package pages;

import lombok.Data;
import org.openqa.selenium.By;
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

    @FindBy(tagName = "h1")
    private WebElement welcomeMessage;

    @FindBy(xpath = "//div[@class='gridViewContainer']//div[@class='gridViewInfo']")
    private List<WebElement> allAlbums;


    public void clickOnAlbum(String name){
        Driver.getDriver().findElement(By.xpath("//div[@class='gridViewContainer']//div[@class='gridViewInfo'][.='"+name+"']")).click();
    }


}
