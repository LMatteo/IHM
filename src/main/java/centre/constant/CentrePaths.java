package centre.constant;

import java.io.File;
import java.net.MalformedURLException;

/**
 * Class used to store paths to the data folder, and to get files from the same
 * folder.
 */
public class CentrePaths {

    /**
     * Returns the path of a store logo with the given filename.
     *
     * @param logoName - the filename of the logo
     * @return a file containing the logo
     * @throws MalformedURLException - if failing to find the file
     */
    public static String getLogoPath(String logoName) throws MalformedURLException {
        return new File("data/centre/images/logo/" + logoName).toURI().toURL().toString();
    }

    /**
     * Returns the path of the news with the requested filename.
     *
     * @param promoName - the filename of the news
     * @return a file containing the news
      * @throws MalformedURLException - if failing to find the file
     */
    public static String getNewsPath(String promoName) throws MalformedURLException {
        return new File("data/centre/images/promo/" + promoName).toURI().toURL().toString();
    }

}
