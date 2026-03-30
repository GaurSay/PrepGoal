package projectUp;

import lombok.Builder;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

public class testEMI {

    public static void main(String[] args) {
        testEMI t = new testEMI();
        List<EMIChannelInfos> emiChannelInfos = new ArrayList<>();
        EMIChannelInfos emiChannelInfos1 = EMIChannelInfos.builder().interestRate("15").planId("1").ofMonths("3").build();
        emiChannelInfos.add(emiChannelInfos1);
        modifyList(emiChannelInfos);


//        t.populateEMIAndTotalAmount(new Amount("INR","10000"),emiChannelInfos);
//        System.out.println(emiChannelInfos1.getEmiAmount().value+" "+emiChannelInfos1.getEmiAmount().currency);
        System.out.println(emiChannelInfos1.toString());
    }

        private void populateEMIAndTotalAmount(Amount txnAmount, List<EMIChannelInfos> emiChannelInfos) {
        for(EMIChannelInfos e : emiChannelInfos){
            Double emiAmount = emiCalculation(Double.parseDouble(txnAmount.getValue()),Double.parseDouble(e.getInterestRate()),Integer.parseInt(e.getOfMonths()));
            e.setEmiAmount(Amount.builder().currency(txnAmount.getCurrency())
                        .value(String.valueOf(emiAmount)).build());
            e.setTotalAmount(Amount.builder().currency(txnAmount.getCurrency()).value(calculateTotalAmount(emiAmount,e.getOfMonths())).build());
        }
    }

    public static void modifyList(List<EMIChannelInfos> emiChannelInfos ){
      emiChannelInfos.get(0).setInterestRate("100000");

    }





    public double emiCalculation(Double p,Double r,int t){
      r  = (r/12)/100;
      return (p*r*Math.pow(1+r,t))/(Math.pow(1+r,t)-1);
    }

    public String calculateTotalAmount(Double emiAmount,String months){
      return String.format("%.2f",emiAmount*Integer.valueOf(months));
    }
}

@Data
@Builder
class Amount{
    String currency;
    String value;
}
