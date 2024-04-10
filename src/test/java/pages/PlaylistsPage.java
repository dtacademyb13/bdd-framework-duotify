package pages;

import lombok.Data;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;
import utilities.SeleniumUtils;

@Data
public class PlaylistsPage {


    public PlaylistsPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//button[.='NEW PLAYLIST']")
    private WebElement newPlaylistButton;


    public void createPlaylist(String playlistName) throws InterruptedException {
        newPlaylistButton.click();

        Alert alert = Driver.getDriver().switchTo().alert();
        alert.sendKeys(playlistName);
        alert.accept();
        Thread.sleep(2000);
    }



    public void clickOnPlaylist(String name){
        SeleniumUtils.jsClick(Driver.getDriver().findElement(By.xpath("//div[@class='gridViewInfo'][.='"+name+"']")));
    }
}
