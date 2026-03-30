package LowLevelDesign.LoggingSystem;

public class DebugLogger extends LogProcessor{

    public DebugLogger(LogProcessor nextLogger) {
        super(nextLogger);
    }

    public void log(int logLevel ,String message){
        if(logLevel == DEBUG){
            System.out.println("Info : " + message);
        }
        else{
            super.log(logLevel,message);
        }
    }
}
