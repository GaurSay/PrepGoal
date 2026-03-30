package projectUp;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class EMIChannelInfos {
    private String planId;
    private String interestRate;
    private String ofMonths;
    private Amount minAmount;
    private Amount maxAmount;
    private Amount emiAmount;
    private Amount totalAmount;
}
