class Logger {
    private static Logger instance;

    private Logger() {
    }

    public static Logger getInstance() {
        if (instance == null) {
            instance = new Logger();
        }
        return instance;
    }

    public void log(String message) {
        System.out.println("[LOG] " + message);
    }
}

public class SingletonTest {
    public static void main(String[] args) {
        Logger firstLogger = Logger.getInstance();
        Logger secondLogger = Logger.getInstance();

        firstLogger.log("Initializing application");
        secondLogger.log("Sending test message");

        System.out.println("Same instance: " + (firstLogger == secondLogger));
    }
}
