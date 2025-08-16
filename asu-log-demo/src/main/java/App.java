import me.asu.log.Log;

public class App {
    public static void main(String[] args) {
        Log.trace("Trace message");
        Log.debug("Debug message");
        Log.info("Hello from asu-log!");
        Log.warn("Warning message");
        Log.error("Error message");


        // 需要把其它的输出通过slf4j的输出，
        // asu-log-slf4j/asu-log-slf4j2
        // Log.setLogger(new Slf4jAdapter());
    }
}
