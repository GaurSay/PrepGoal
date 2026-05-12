package LowLevelDesign.AmazonLocker;

import lombok.Data;

import java.util.List;

@Data
public class DeliveryAgent {
    private String agentId;
    private String name;
    private List<String> serviceableZipCodes;

    public DeliveryAgent(String agentId, String name, List<String> zipCodes) {
        this.agentId = agentId;
        this.name = name;
        this.serviceableZipCodes = zipCodes;
    }
}