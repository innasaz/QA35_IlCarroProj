package manager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.Calendar;
import java.util.Date;

public class HelperSearch extends HelperBase{
    public HelperSearch(WebDriver wd) {
        super(wd);
    }

    public void openSearchForm() {
        pause(500);
        click(By.cssSelector("[href='/search']"));
    }

    public void searchCurrentMonth(String city, String dataFrom, String dataTo) {

        typeCity(city);
        click(By.id("dates"));
        //   "10/25/2022"
        // "aaa/fff/r"   ["aaa"] ["fff"] ["r"]
        String[] from =dataFrom.split("/");  /// ["10"] ["25"] ["2022"]  from[1] ="25"

        // String locator1 ="//div[text()=' 25 ']";
        String locator = "//div[text()=' "+from[1]+" ']";

        ///  "how are you, Dolli?"      names [Dolli] [Molli] [lis]
        //  "how are you, "+names[2]+"?"      how are you, lis?

        click(By.xpath(locator));




        // "10/30/2022"
        String [] to = dataTo.split("/");   /// to[1]
        String locator2 = "//div[text()=' "+to[1]+" ']";

        click(By.xpath(locator2));

    }
    public void searchCurrentMonth2(String city, String dataFrom, String dataTo) {

        typeCity(city);
        click(By.id("dates"));

        String[] from =dataFrom.split("/");


        //String locator = "//div[text()=' "+from[1]+" ']";
        String locator = String.format("//div[text()=' %s ']",from[1]) ;
        click(By.xpath(locator));


        // 10/30/2022 -> ["10", "30", "2022"]
        String [] to = dataTo.split("/");

        String locator2 =  String.format("//div[text()=' %s ']", to[1]);

        click(By.xpath(locator2));

    }

    private void selectDate(String date) { // "11/30/2022"
        WebElement prevMonthButton = wd.findElement(By.cssSelector("button.mat-calendar-previous-button"));
        WebElement nextMonthButton = wd.findElement(By.cssSelector("button.mat-calendar-next-button"));

        Calendar rightNow = Calendar.getInstance();
        int currentMonth = rightNow.get(Calendar.MONTH) + 1;

        String[] dateValues = date.split("/");
        int dateMonth = Integer.parseInt(dateValues[0]);
        int dateDay = Integer.parseInt(dateValues[1]);
        int dateYear = Integer.parseInt(dateValues[2]);

        int deltaMonth = dateMonth - currentMonth;

        if (deltaMonth > 0) {
            for (int i = 0; i < deltaMonth; i++) {
                nextMonthButton.click();
            }
        } else if (deltaMonth < 0) {
            for (int i = 0; i > deltaMonth; i--) {
                prevMonthButton.click();
            }
        }

        String locator =  String.format("//div[text()=' %s ']", dateDay);

        click(By.xpath(locator));
    }

    public void searchCityAndDates(String city, String dateFrom, String dateTo) {
        typeCity(city);
        WebElement datesInput;
        if (wd.findElements(By.id("dates")).size() > 0) {
            datesInput = wd.findElement(By.id("dates"));
        } else {
            datesInput = wd.findElement(By.cssSelector("input[formcontrolname='dates']"));
        }
        datesInput.click();

        selectDate(dateFrom);
        selectDate(dateTo);
    }

    private void typeCity(String city) {
        type(By.id("city"),city);
        click(By.cssSelector("div.pac-item"));
        //pause(500);
    }
}