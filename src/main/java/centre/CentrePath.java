package centre;

import java.io.File;
import java.net.MalformedURLException;

public class CentrePath {

    public static String getLogoPath(String logoName) throws MalformedURLException {
        return new File("data/centre/images/logo/" + logoName).toURI().toURL().toString();
    }

    public static String getNewsPath(String promoName) throws MalformedURLException {
        return new File("data/centre/images/promo/" + promoName).toURI().toURL().toString();
    }
}
