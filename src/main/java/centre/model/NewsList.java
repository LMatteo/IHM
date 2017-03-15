package centre.model;


import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class NewsList {

    private List<News> newsList;

    /**
     * Initialize News data from file
     *
     * @throws IOException        - if failing to load one of the files
     * @throws URISyntaxException - if failing to find one of the folders
     */
    public NewsList() throws IOException, URISyntaxException {
        File[] storeFolder = new File("data/centre/news/").listFiles();
        if (storeFolder == null) {
            System.out.println("Could not find stored data.");
            return;
        }
        newsList = new ArrayList<>();
        for (File file : storeFolder) {
            newsList.add(new News(file));
        }
        sort();
    }

    public void add(News n) {
        newsList.add(n);
        sort();
    }

    public List<News> getNewsList() {
        return newsList;
    }

    public List<News> getHorizontalNews() {
        List<News> res = new ArrayList<>();
        for (News n : newsList) {
            if (n.isHorizontal()) res.add(n);
        }
        return res;
    }

    public List<News> getVerticalNews() {
        List<News> res = new ArrayList<>();
        for (News n : newsList) {
            if (!n.isHorizontal()) res.add(n);
        }
        return res;
    }

    public List<News> getByPosition(int pos) {
        List<News> res = new ArrayList<>();
        for (News n : newsList) {
            if (n.getPosition() == pos) {
                res.add(n);
            }
        }
        return res;
    }

    public boolean nameExists(String name) {
        for (News n : newsList) {
            if (n.getName().equals(name)) {
                return true;
            }
        }
        return false;
    }

    private void sort() {
        Collections.sort(newsList, (n1, n2) -> (int) (n2.getDate() - n1.getDate()));
    }
}
