package LowLevelDesign.LoggingSystem;

public class InfoLogger extends LogProcessor{


    public InfoLogger(LogProcessor nextLogger) {
        super(nextLogger);
    }

    public void log(int logLevel ,String message){
        if(logLevel == INFO){
            System.out.println("Info : " + message);
        }
        else{
            super.log(logLevel,message);
        }
    }
}
