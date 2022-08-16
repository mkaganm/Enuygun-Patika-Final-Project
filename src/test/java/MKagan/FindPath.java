package MKagan;

import java.nio.file.Path;
import java.nio.file.Paths;

import static MKagan.DriverType.*;

public class FindPath {

    // * You can use this method to find driver path.
    // * Bu metodu driver yolunu bulmak için kullanabilirsiniz.
    public static String driverPath(Enum driverType){
        Path resourceDirectory = Paths.get("src","test","java", "MKagan","bin");
        String path = resourceDirectory.toFile().getAbsolutePath();

        if(driverType.equals(CHROME)){              // * add to path chromedriver
            path += "/chromedriver.exe";

        } else if (driverType.equals(FIREFOX)) {    // * add to path firefoxdriver (geckodriver)
            path += "/geckodriver.exe";

        } else if (driverType.equals(EDGE)) {       // * add to path edgedriver (msedgedriver)
            path += "/msedgedriver.exe";

        } else {    // * ERROR MESSAGE
            path = "YOUR DRIVER TYPE NOT FOUND...\n" +
                    "You can use only this drivers\n" +
                    "CHROME\nFIREFOX\nEDGE\n";
            System.out.println(path);
        }

        return path;
    }

    public static String returnAppPath(){
        String path;
        Path resourceDirectory = Paths.get("src","test","resources","apps","ContactManager.apk");
        path = resourceDirectory.toFile().getAbsolutePath();
        return path;
    }
}
