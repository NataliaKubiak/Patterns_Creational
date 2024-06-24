package task2;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Logger {

    private static Logger logger;
    protected int num = 1;

    private Logger() {
    }

    public static Logger getInstance() {
        if (logger == null) {
            logger = new Logger();
        }
        return logger;
    }

    public void log(String msg) {
        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        String formattedDate = formatter.format(date);

        System.out.println("[" + formattedDate + " " + num++ + "] " + msg);
    }
}
