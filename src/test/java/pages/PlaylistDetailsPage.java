package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class PlaylistDetailsPage {


    public PlaylistDetailsPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//button[.='DELETE PLAYLIST']")
    private WebElement deletePlaylistButton;


    public void deletePlaylist() throws InterruptedException {
        deletePlaylistButton.click();
        Driver.getDriver().switchTo().alert().accept();
        Thread.sleep(2000);

    }
}
