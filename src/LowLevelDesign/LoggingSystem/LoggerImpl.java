package LowLevelDesign.LoggingSystem;


public class LoggerImpl {
    public static void main(String[] args) {
        LogProcessor logProcessor = new InfoLogger(new DebugLogger(new ErrorLogger(null)));
        logProcessor.log(LogProcessor.ERROR,"Exception occurred");
//        logProcessor.log(LogProcessor.DEBUG,"need to debug");
//        logProcessor.log(LogProcessor.INFO,"just for info");
    }
}
