package game.balancingact.backend.apicontrollers;

import java.util.Map;import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * This controller is responsible for handling health check requests to the backend service. 
 * It provides a simple endpoint that returns the current status of the service, which can be used for monitoring and alerting purposes.
 */
@RestController
public class HealthController 
{    
    /**
     * @return Health endpoint returns a simple JSON response indicating the status of the service.
     */
    @GetMapping("/api/health")    
    public Map<String, String> health() 
    {        
        return Map.of("status", "ok");    
    }
}