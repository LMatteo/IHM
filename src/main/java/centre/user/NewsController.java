package centre.user;

import centre.CentrePath;
import centre.model.News;
import centre.model.NewsList;
import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class NewsController {

    @FXML protected ImageView v1;
    @FXML protected ImageView h2;
    @FXML protected ImageView h3;
    @FXML protected ImageView h4;
    @FXML protected ImageView h5;
    @FXML protected ImageView v6;

    protected NewsList listNews;
    protected List<ImageView> bindedNews;

    protected Map<Integer, ImageView> newsCorrespondance = new HashMap<>();

    public void initializeContent(NewsList listNews) throws IOException, URISyntaxException {
        this.listNews = listNews;
        newsCorrespondance.put(1, v1);
        newsCorrespondance.put(2, h2);
        newsCorrespondance.put(3, h3);
        newsCorrespondance.put(4, h4);
        newsCorrespondance.put(5, h5);
        newsCorrespondance.put(6, v6);
        placeNews();
    }

    public void placeNews() {
        bindedNews = new ArrayList<>();
        for (News n : listNews.getNewsList()) {
            if (newsCorrespondance.containsKey(n.getPosition())) {
                try {
                    bindedNews.add(newsCorrespondance.get(n.getPosition()));
                    newsCorrespondance.get(n.getPosition()).setImage(new Image(CentrePath.getNewsPath(n.getFrench() + ".png")));
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
