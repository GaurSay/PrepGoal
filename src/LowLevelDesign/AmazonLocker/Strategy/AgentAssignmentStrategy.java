package LowLevelDesign.AmazonLocker.Strategy;

import LowLevelDesign.AmazonLocker.DeliveryAgent;

import java.util.List;

public interface AgentAssignmentStrategy {
    DeliveryAgent assignAgent(List<DeliveryAgent> agents);
}
