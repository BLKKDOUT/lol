package sample;

import javafx.stage.Stage;
import java.security.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class login {
    static String loginUser;
    private static final File targetFile;
    private static final Properties properties;
    public static boolean doesTheKeyValuePairExist;
    static {
        targetFile = new File("src/sample/config.ini");

        properties = new Properties();

        try
        {
            properties.load(
                    new FileInputStream(
                            targetFile.getAbsolutePath()));
        }

        catch(IOException ioe)
        {
            System.err.println(
                    "Unable to read file.");
        }
    }

    public static void checkPair(String usernameField, String passwordField){
        try {
            doesTheKeyValuePairExist = checkIfKeyValuePairExists(usernameField, passwordField);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static String get_SHA_1_SecurePassword(String passwordToHash) {
        String generatedPassword = null;
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-512");
            byte[] bytes = md.digest(passwordToHash.getBytes());
            StringBuilder sb = new StringBuilder();
            for (byte aByte : bytes) {
                sb.append(Integer.toString((aByte & 0xff) + 0x100, 16)
                        .substring(1));
            }
            generatedPassword = sb.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return generatedPassword;
    }



    private static Boolean checkIfKeyValuePairExists(String username, String password) throws Exception {
    String securePassword = get_SHA_1_SecurePassword(password);
        //System.out.println(securePassword);
        for(String key:properties.stringPropertyNames())

            if(key.equals(username) && properties.getProperty(key).equals(securePassword)){
                Stage noteStage = new Stage();
                Main.noteStage(noteStage);
                return true;
            }
        System.out.println("Argh... That Hurts!");
        return false;
    }

    public static void setUsername(String username){
        loginUser = username;
    }

    public static String getUsername(){
        return loginUser;
    }
}
