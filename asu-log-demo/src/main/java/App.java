import me.asu.log.Log;

public class App {
    public static void main(String[] args) {
        Log.trace("Trace message");
        Log.debug("Debug message");
        Log.info("Hello from asu-log!");
        Log.warn("Warning message");
        Log.error("Error message");


        //
        Log.setLogger(new Slf4jAdapter());
    }
}
