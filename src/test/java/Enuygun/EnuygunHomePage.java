package Enuygun;

import lombok.Data;
import org.openqa.selenium.By;

@Data
public class EnuygunHomePage extends Enuygun{

    By flight = By.xpath("//header/nav[1]/div[1]/div[2]/a[1]");
}
