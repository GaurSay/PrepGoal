package LowLevelDesign.AmazonLocker.Strategy;

import LowLevelDesign.AmazonLocker.DeliveryAgent;

import java.util.List;
import java.util.Random;

public class RandomAgentAssignment implements AgentAssignmentStrategy {

    private Random random = new Random();

    @Override
    public DeliveryAgent assignAgent(List<DeliveryAgent> agents) {
        if (agents == null || agents.isEmpty()) return null;
        return agents.get(random.nextInt(agents.size()));
    }
}
