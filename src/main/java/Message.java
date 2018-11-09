import java.io.*;
import java.util.Date;
import java.util.Locale;
import java.util.Properties;
import java.util.logging.Logger;


public class Message {

private static int time = new Date().getHours();

    //this method compares the current time and returns the value (string type) of the time of day.
    public static String getMessage(int hours){
        if ((hours >= 6) && (hours < 9)) {
            return "morning";
        } else if ((hours >= 9) && (hours < 19)) {
            return "day";
        } else if ((hours >= 19) && (hours < 23)) {
            return "evening";
        } else if ((hours == 23) || ((hours < 6) && (hours >= 0))) {
            return "night";
        }
        return null;
    }

    public static void main(String[] args) throws IOException {

        PrintStream logfile = null;
        try {
            logfile = new PrintStream(new FileOutputStream("log.txt"));
        }
        catch (FileNotFoundException e) {
            System.err.println("File no found!");
        }
        logfile.println("First note to logfile");

        FileInputStream fis=null;
        Properties property = new Properties();
        //language selection for the message.
        try {
            if (Locale.getDefault().toString().equals("ru_RU")) {
                fis = new FileInputStream("src\\main\\resources\\messageRussian.properties");
            } else {
                fis = new FileInputStream("src\\main\\resources\\messageEnglish.properties");
            }
            property.load(fis);
        //Exception handling and thread closing.
        } catch (IOException e) {
            System.err.println("Error.Property file missing locale not found!");
        } catch (Exception e) {
            System.out.println("Мы затрудняемся ответить какого собственно рожна, но ваша жалоба нам очень важна:)");
        }  finally {
            fis.close();
        }
        // Print message depending on time and language.
        System.out.println(property.getProperty(getMessage(time)));
    }
}



