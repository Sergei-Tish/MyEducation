import com.hazelcast.client.config.ClientConfig;
import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.map.IMap;

import java.util.Map;

public class ClientNode {
    static IMap<Long, String> map;
    static HazelcastInstance hzClient;

    public static void main(String[] args) {
        ClientConfig config = new ClientConfig();
        config.setClusterName("dev");
        config.getSecurityConfig()
    }
}
