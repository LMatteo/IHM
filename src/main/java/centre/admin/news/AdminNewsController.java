package centre.admin.news;

import centre.model.News;
import centre.user.NewsController;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.List;
import java.util.Map;


public class AdminNewsController extends NewsController {

    @Override
    public void placeNews() {
        super.placeNews();
        for (ImageView iv : newsCorrespondance.values())
            if (!bindedNews.contains(iv)) {
                iv.setImage(new Image(getClass().getResource("/images/centre/add.png").toString()));
        }
    }

    @FXML
    void modifyPanel(MouseEvent mouseEvent) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/centre/admin/news/newSelector.fxml"));
        Parent rootNode = loader.load();
        NewsSelectorController controller = loader.getController();
        List<News> altenatives;
        Object source = mouseEvent.getSource();
        int sourceId = newsCorrespondance.entrySet()
                .stream()
                .filter(entry -> entry.getValue().equals(source))
                .map(Map.Entry::getKey)
                .findFirst().orElse(0);
        if (source.equals(v1) || source.equals(v6)) {
            altenatives = listNews.getVerticalNews();
        } else {
            altenatives = listNews.getHorizontalNews();
        }
        controller.initializeContents(this, altenatives, sourceId);
        Scene scene = new Scene(rootNode, 600, 500);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.setTitle("Choisir une promotion/actualité");
        stage.show();
    }


}
