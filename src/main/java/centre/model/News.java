package centre.model;


import java.io.File;
import java.io.IOException;

public class News {

    private long date;
    private int position;
    private String french;
    private String english;
    private String magasinId;
    private boolean horizontal;
    private String name;
    private String fileName;

    /**
     * Creates a news object with the data provided
     *
     * @param file - the file containing the data
     * @throws IOException - if failing to read the file
     */
    public News(File file) throws IOException {
        NewsParser np = new NewsParser(file);
        fileName = file.getName();
        name = np.getProperty("name");
        date = np.getDate();
        position = np.getPosition();
        french = np.getProperty("french");
        english = np.getProperty("english");
        magasinId = np.getProperty("magasinId");
        horizontal = np.horizontal();
    }

    public boolean isUsed() {
        return (position != 0);
    }

    public int getPosition() {
        return position;
    }

    public String getFrench() {
        return french;
    }

    public String getEnglish() {
        return english;
    }

    public long getDate() {
        return date;
    }

    public boolean isHorizontal() {
        return horizontal;
    }

    public String getName() {
        return name;
    }

    public void setPosition(int value) {
        position = value;
    }

    /**
     * Saves this news data in a new file in the data folder.
     */
    public void save() {
        NewsWriter nw = new NewsWriter(fileName);
        nw.addProperty("name", name);
        nw.addDate(date);
        nw.addPosition(position);
        nw.addProperty("french", french);
        nw.addProperty("english", english);
        nw.addProperty("magasinId", magasinId);
        nw.addHorizontal(horizontal);
        nw.write();
    }

}
