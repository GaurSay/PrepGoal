package LowLevelDesign.LoggingSystem;

public class ErrorLogger extends LogProcessor {


    public ErrorLogger(LogProcessor nextLogger) {
        super(nextLogger);
    }

    public void log(int logLevel , String message){
        if(logLevel == ERROR){
            System.out.println("Error : " + message);
        }
        else{
            super.log(logLevel,message);
        }
    }
}
