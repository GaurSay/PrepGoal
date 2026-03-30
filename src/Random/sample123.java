package Random;


//mport call_api



//# The method call_api() has no arguments and does not return any values
//
//# Will raise RuntimeError exception if failure
//
//
//
//if __name__ == "__main__":
//
//        # Call call_api() up to 3 times if a RuntimeError is raised.
//
//        # If successful, do nothing
//
//	# If unsuccessful, raise existing exception
public class sample123 {

    static int counter =0;

    public static void main(String[] args) {
        for(int i=0;i<4;i++){
            try{
                callApi();
            }catch (RuntimeException exception){
            counter++;
        }
        finally {
            if(counter>3){
                System.out.println("code is unsuccessful");
            }
        }

        }

    }

    public static void callApi() throws RuntimeException{
        throw new RuntimeException();


    }

}
