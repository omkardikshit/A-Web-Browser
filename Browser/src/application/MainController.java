package application;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;

public class MainController implements Initializable {
	@FXML private WebView webView;
	@FXML private TextField input;
	@FXML private Button back;
	@FXML private Button forward;
	@FXML private Button search;
	@FXML private Button reload;
	private WebEngine engine;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		engine = webView.getEngine();
		engine.load("https://www.google.com");
		Image back_img = new Image(getClass().getResourceAsStream("back.png"));
		back.setGraphic(new ImageView(back_img));
		Image forward_img = new Image(getClass().getResourceAsStream("forward.png"));
		forward.setGraphic(new ImageView(forward_img));	
		Image search_img = new Image(getClass().getResourceAsStream("Search.png"));
		search.setGraphic(new ImageView(search_img));	
		Image reload_img = new Image(getClass().getResourceAsStream("Reload.png"));
		reload.setGraphic(new ImageView(reload_img));	
	}
	
	public void Reload(ActionEvent event) {
		engine.reload();
	}
	
	public void Search(ActionEvent event) {
		engine.load(input.getText());	
	}

	public void Back(ActionEvent event) {
			int currentIndex=engine.getHistory().getCurrentIndex();
			if(currentIndex  == 0) {
				
			}else {
				engine.getHistory().go(-1);
			}
	}
	
	public void Forward(ActionEvent event) {
			engine.executeScript("window.history.go(1);");
			
	}	
	
}
