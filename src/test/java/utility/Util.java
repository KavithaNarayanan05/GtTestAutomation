package utility;

import org.openqa.selenium.WebElement;
import java.util.List;
import java.util.Random;

public class Util {
    public static void clickDropdownElementByValue(List<WebElement> dropdown, String value)throws Throwable {
        for (int i = 0; i < dropdown.size(); i++) {
            // System.out.println("DROPDOWN SIZE IS: " +dropdown.size());
            //Fetching the dropdown item by value
            if (dropdown.get(i).getText().contains(value)) {
                //System.out.println(dropdown.get(i).getText());
                dropdown.get(i).click();
            }
        }
    }

    public static void clickRandomAdFromList(List<WebElement> adsList)throws Throwable {
        if (adsList.size() > 1) {
            //System.out.println("ADSLIST SIZE IS: " + adsList.size());
            Random rand = new Random();
            //Getting a random value that is between 0 and (list size)-1
            int randomValue = rand.nextInt(adsList.size());
            // System.out.println("RANDOM VALUE IS :" + randomValue);
            //Selecting random list item
            adsList.get(randomValue).click();
        }
    }

    public static boolean verifyIfItemsPresent(List<WebElement> slideableAds)throws Throwable {
        if(slideableAds.size() > 0)
            return true;
        else
            return false;
    }
}
