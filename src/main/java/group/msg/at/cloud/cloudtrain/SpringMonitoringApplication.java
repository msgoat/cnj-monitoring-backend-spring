package group.msg.at.cloud.cloudtrain;

import group.msg.at.cloud.common.observability.CommonObservability;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Point of entry for this Spring Boot application.
 */
@SpringBootApplication(scanBasePackageClasses = {SpringMonitoringApplication.class, CommonObservability.class})
public class SpringMonitoringApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringMonitoringApplication.class, args);
    }
}
