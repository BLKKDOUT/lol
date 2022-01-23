package sample;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    @FXML
    private ImageView logo;
    @FXML
    private Button exitButton;
    @FXML
    private TextField usernameField;
    @FXML
    private TextField passwordField;
    @FXML
    public static Button loginButton;
    private int songNumber;
    private MediaPlayer mediaPlayer;

    @FXML
    void closeNote() {
        System.out.println("Note Closed");
    }

    @FXML
    void saveNote() {
        System.out.println("Note Saved");
    }

    @FXML
    void pauseMusic() {
        mediaPlayer.pause();
        System.out.println("Music Paused");
    }

    @FXML
    void playMusic() {
        double volume = 0.1;
        mediaPlayer.setVolume(volume);
        mediaPlayer.play();
    }

    @FXML
    void exit(){
        Stage window = (Stage) exitButton.getScene().getWindow();
        window.close();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        ArrayList<File> songs = new ArrayList<>();
        File directory = new File("music");
        File[] files = directory.listFiles();

        if(files != null){
            for(File file : files){
                songs.add(file);
                //songNumber++;
                System.out.println(songNumber + ". " + file);
            }
        }else System.out.println("No music found!");

        Media media = new Media(songs.get(songNumber).toURI().toString());
        mediaPlayer = new MediaPlayer(media);
    }

    public void loginAction(){
        login.setUsername(usernameField.getText());
        login.checkPair(usernameField.getText(), passwordField.getText());
        //System.out.println("Username: "+ usernameField.getText() + "\nPassword: " + passwordField.getText());
        Stage window = (Stage) usernameField.getScene().getWindow();
        window.close();
    }

}
