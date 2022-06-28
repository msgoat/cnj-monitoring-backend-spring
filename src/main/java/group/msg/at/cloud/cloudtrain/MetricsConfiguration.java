package group.msg.at.cloud.cloudtrain;

import io.micrometer.core.aop.CountedAspect;
import io.micrometer.core.aop.TimedAspect;
import io.micrometer.core.instrument.MeterRegistry;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * {@code Configuration} for support of Micrometer's annotations
 * which does not seem to work out-of-the-box.
 */
@Configuration
public class MetricsConfiguration {

    /**
     * Name prefix for all metrics related to business operation invocations.
     */
    public static final String BUSINESS_OPERATION_METRIC_PREFIX = "business_operation";

    /**
     * Extra metric tag specifying the business operation's name.
     */
    public static final String BUSINESS_OPERATION_NAME_TAG = "operation";

    @Bean
    public CountedAspect countedAspect(MeterRegistry registry) {
        return new CountedAspect(registry);
    }

    @Bean
    public TimedAspect timedAspect(MeterRegistry registry) {
        return new TimedAspect(registry);
    }
}
