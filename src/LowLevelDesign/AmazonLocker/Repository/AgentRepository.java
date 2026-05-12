package LowLevelDesign.AmazonLocker.Repository;

import LowLevelDesign.AmazonLocker.DeliveryAgent;

import java.util.*;

public class AgentRepository {

    private Map<String, DeliveryAgent> agents = new HashMap<>();
    private Map<String, List<DeliveryAgent>> zipToAgents = new HashMap<>();

    public void save(DeliveryAgent agent) {
        agents.put(agent.getAgentId(), agent);

        for (String zip : agent.getServiceableZipCodes()) {
            zipToAgents
                    .computeIfAbsent(zip, z -> new ArrayList<>())
                    .add(agent);
        }
    }

    public DeliveryAgent getById(String id) {
        return agents.get(id);
    }

    public List<DeliveryAgent> getByZip(String zip) {
        return zipToAgents.getOrDefault(zip, Collections.emptyList());
    }
}
