package EnuygunTest;

import MKagan.DriverChrome;


public class BaseTest {

    public DriverChrome driverChrome;

    public BaseTest(){
        String[] options ={"--start-maximized"
                ,"--disable-notifications"};

        driverChrome = new DriverChrome(options);

    }



}
