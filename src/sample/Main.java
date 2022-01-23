package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.Objects;

public class Main extends Application{

    public static void noteStage(Stage noteStage) throws Exception {
        Parent noteSceneLayout = FXMLLoader.load(Objects.requireNonNull(Main.class.getResource("noteSceneLayout.fxml")));
        Scene noteScene = new Scene(noteSceneLayout, 720, 480);

        noteStage.setTitle("CODEX Noter");
        //noteScene.getStylesheets().add("sample/style.css");
        switch (login.getUsername()) {
            case "codex":
                System.out.println("Logged as " + login.getUsername());
                noteScene.getStylesheets().add("sample/codexStyle.css");
                break;
            case "andrewflowenheld":
                System.out.println("Logged as " + login.getUsername());
                noteScene.getStylesheets().add("sample/andrewStyle.css");
                break;
            case "smista":
                System.out.println("Logged as " + login.getUsername());
                noteScene.getStylesheets().add("sample/smistaStyle.css");
                break;
            default:
                System.out.println("No CSS found for user " + login.getUsername());

        }
        noteStage.setResizable(false);
        noteStage.setScene(noteScene);
        noteStage.show();
    }

    public void loginStage(Stage loginStage) throws Exception{
        Parent loginSceneLayout = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("loginSceneLayout.fxml")));
        loginStage.setTitle("USER LOGIN");
        Scene loginScene = new Scene(loginSceneLayout, 360, 240);
        loginStage.setScene(loginScene);
        loginStage.setResizable(false);
        loginScene.getStylesheets().add("sample/loginStyle.css");
        loginStage.show();
    }

    @Override
    public void start(Stage stage) throws Exception{
        Stage loginStage = new Stage();
        loginStage(loginStage);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
