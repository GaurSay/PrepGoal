package LowLevelDesign.AmazonLocker.Service;

import LowLevelDesign.AmazonLocker.DeliveryAgent;
import LowLevelDesign.AmazonLocker.Package;

public class NotificationService {

    public void notifyAgent(DeliveryAgent agent, Package pkg) {
        System.out.println("Notifying agent " + agent.getAgentId() +
                " for package " + pkg);
    }
}