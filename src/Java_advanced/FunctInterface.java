package Java_advanced;
import java.io.IOException;
import java.math.BigInteger;
import java.util.*;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class FunctInterface {

public static final int End = Integer.MAX_VALUE;
public static final int start = End-100;


    public static void main(String[] args) {

        // CONSUMER FI
        //accept object , process and return nothing

//        List<Integer> list = Arrays.asList(1,2,3,4,5);
//
//        Consumer<Integer> consumerFI= (t)-> System.out.print(t+" ");
//        list.stream().forEach(consumerFI);
//
//        consumerFI.accept(1);
//
//
//        //PREDICATE FI - used for conditional check ( T/F )
//        Predicate<Integer> predicate = (t) -> t%2 == 0;
//
//        List<Integer> evenList = list.stream().filter(predicate).collect(Collectors.toList());
//
//        // SUPPLIER FI - no input but output is accepted
//        Supplier<String> supplier = ()-> "HI";
//        Supplier<Integer> supplier2 = ()-> 1;
//        System.out.println(supplier.get());
//
//        list.stream().filter(predicate).findAny().orElseGet(supplier2);

//        BigInteger f = new BigInteger("5000");
//      BigInteger f1 = new BigInteger("50000");
//      BigInteger f2 = new BigInteger("500000");
//      BigInteger total = BigInteger.ZERO;
//      total.add(f);
//      total.add(f1);
//      total.add(f2);
//      total.add(total);
//        int count =0;
//        for(int i=start;i<=End;i++) {
//            count++;
//            System.out.println(count);
//        }
//        System.out.println(count);

//      final String pig ="length 10";
//      final String dog = "length "+ pig.length();
//        System.out.println(pig ==dog);
    }

}
