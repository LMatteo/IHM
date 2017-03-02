package centre.admin.news;

import centre.CentrePath;
import centre.model.News;
import centre.model.NewsList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class AdminNewsController {

    @FXML ImageView v1;
    @FXML ImageView h2;
    @FXML ImageView h3;
    @FXML ImageView h4;
    @FXML ImageView h5;
    @FXML ImageView v6;

    NewsList listNews;

    private Map<Integer, ImageView> newsCorrespondance = new HashMap<>();

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

    public void placeNews() throws MalformedURLException {
        for (News n : listNews.getNewsList()) {
            if (newsCorrespondance.containsKey(n.getPosition())) {
                newsCorrespondance.get(n.getPosition()).setImage(new Image(CentrePath.getNewsPath(n.getFrench() + ".png")));
            }
        }
        for (ImageView iv : newsCorrespondance.values()) {
            if (iv.getImage() == null) {
                iv.setImage(new Image(getClass().getResource("/images/centre/add.png").toString()));
            }
        }
    }

    @FXML
    void modifyPanel(MouseEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/centre/admin/news/newSelector.fxml"));
        Parent rootNode = loader.load();
        NewsSelectorController controller = loader.getController();
        controller.bindTo(this);
        List<News> altenatives;
        if (event.getSource().equals(v1) || event.getSource().equals(v6)) {
            altenatives = listNews.getVerticalNews();
        } else {
            altenatives = listNews.getHorizontalNews();
        }
        controller.initializeContents(altenatives);
        Scene scene = new Scene(rootNode, 600, 400);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.setTitle("Choisir une promotion/actualité");
        stage.show();
    }


}
