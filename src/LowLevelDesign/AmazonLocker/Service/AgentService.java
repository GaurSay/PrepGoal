package LowLevelDesign.AmazonLocker.Service;

import LowLevelDesign.AmazonLocker.DeliveryAgent;
import LowLevelDesign.AmazonLocker.Locker;
import LowLevelDesign.AmazonLocker.Package;
import LowLevelDesign.AmazonLocker.PackageStatus;
import LowLevelDesign.AmazonLocker.Repository.AgentRepository;
import LowLevelDesign.AmazonLocker.Strategy.AgentAssignmentStrategy;

import java.util.List;

public class AgentService {

    private AgentRepository agentRepository;
    private AgentAssignmentStrategy strategy;
    private NotificationService notificationService;

    public AgentService(AgentRepository repo,
                        AgentAssignmentStrategy strategy,
                        NotificationService notificationService) {
        this.agentRepository = repo;
        this.strategy = strategy;
        this.notificationService = notificationService;
    }

    public void registerAgent(DeliveryAgent agent) {
        agentRepository.save(agent);
    }

    public DeliveryAgent assignAgentForDelivery(Locker locker, Package pkg) {

        // STEP 1: Fetch agents by zip
        List<DeliveryAgent> agents =
                agentRepository.getByZip(locker.getZipCode());

        if (agents.isEmpty()) {
            throw new RuntimeException("No agents available");
        }

        // STEP 2: Strategy decides
        DeliveryAgent assignedAgent = strategy.assignAgent(agents);

        if (assignedAgent == null) {
            throw new RuntimeException("Agent assignment failed");
        }

        // STEP 3: Update package
        pkg.setAgentId(assignedAgent.getAgentId());
        pkg.setStatus(PackageStatus.ASSIGNED_TO_AGENT);

        // STEP 4: Notify agent
        notificationService.notifyAgent(assignedAgent, pkg);

        return assignedAgent;
    }
}
