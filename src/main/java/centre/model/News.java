package centre.model;


import centre.model.json.parser.NewsParser;
import centre.model.json.writer.NewsWriter;

import java.io.File;
import java.io.IOException;
import java.time.Instant;

/**
 * An announcement picture to be displayed in the news screen.
 */
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
     * Creates a news object from an existing file.
     *
     * @param file - the file containing the data
     * @throws IOException - if failing to read the file
     */
    public News(File file) throws IOException {
        NewsParser np = new NewsParser(file);
        fileName = file.getName().substring(0, file.getName().lastIndexOf('.'));
        name = np.getProperty("name");
        date = np.getDate();
        position = np.getInt("position");
        french = np.getProperty("french");
        english = np.getProperty("english");
        magasinId = np.getProperty("magasinId");
        horizontal = np.horizontal();
    }

    /**
     * Creates a new announcement from the specified arguments.
     *
     * @param name        - the name of this news
     * @param extensionFR - the file extension of the french picture
     * @param extensionEN - the file extension for the english picture
     * @param horizontal  - whether this news should be displayed horizontally or not
     */
    public News(String name, String extensionFR, String extensionEN, boolean horizontal) {
        this.fileName = name.trim();
        this.name = name;
        this.date = (Instant.now().toEpochMilli()) / 1000;
        this.position = 0;
        this.french = fileName + "FR" + extensionFR;
        this.english = fileName + "EN" + extensionEN;
        this.magasinId = "undefined";
        this.horizontal = horizontal;
    }

    /**
     * Checks whether this announcement is already displayed elsewhere or not.
     *
     * @return true if already displayed, false otherwise
     */
    public boolean isUsed() {
        return (position != 0);
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int value) {
        position = value;
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

    /**
     * Saves this news data in a new file in the data folder.
     *
     * @throws IOException - if failing to save the file
     */
    public void save() throws IOException {
        NewsWriter nw = new NewsWriter(fileName);
        nw.addProperty("name", name);
        nw.addDate(date);
        nw.addInt("position", position);
        nw.addProperty("french", french);
        nw.addProperty("english", english);
        nw.addProperty("magasinId", magasinId);
        nw.addHorizontal(horizontal);
        nw.save();
    }

}
