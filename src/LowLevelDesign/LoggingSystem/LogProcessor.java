package LowLevelDesign.LoggingSystem;

public abstract class LogProcessor {
    public static int INFO = 1;
    public static int ERROR = 2;
    public static int DEBUG = 3;

    LogProcessor nextLogger;

    public LogProcessor(LogProcessor nextLogger){
        this.nextLogger = nextLogger;
    }

    public void log(int logLevel, String message){
        if(nextLogger!=null){
            nextLogger.log(logLevel,message);
        }

    }


}
