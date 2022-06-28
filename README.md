# cnj-monitoring-backend-spring

Cloud native Spring Boot backend with support of cluster monitoring using MicroMeter.

## Status

![Build status](https://drone.cloudtrain.aws.msgoat.eu/api/badges/msgoat/cnj-monitoring-backend-spring/status.svg)

## Release information

Check [changelog](changelog.md) for latest version and release information.

## HOW-TO expose Prometheus metrics with Micrometer

### Step 1: Add dependency to Spring Boot Actuator

Make sure you have added the dependency to Spring Boot Actuator to your POM file 
(which should be the case anyway for Kubernetes health probes to work):
````xml
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-actuator</artifactId>
        </dependency>
````

### Step 2: Add dependency to Micrometer Prometheus Registry

Make sure you have added the dependency to Micrometer Prometheus Registry to your POM file:
````xml
        <dependency>
            <groupId>io.micrometer</groupId>
            <artifactId>micrometer-registry-prometheus</artifactId>
            <version>${micrometer.version}</version>
        </dependency>
````

> __Attention__: The version of the io.micrometer:micrometer-registry-prometheus library must match the version of
> io.micrometer:micrometer-core provided by the Spring Boot runtime!

### Step 3: Activate the prometheus endpoint in Spring Boot Actuator

Make sure you have activated the prometheus endpoint of Spring Boot Actuator in your `application.properties` file:
````properties
management.endpoints.web.exposure.include=prometheus,health,info,metric
````

### Step 4: (if using Tomcat) Activate Tomcat's MBean Registry

If you are using Tomcat as Spring Boot's servlet engine (which is the default), 
make sure you have activated Tomcat's MBean registry in your `application.properties` file 
in order to have all Tomcat metrics available:
````properties
server.tomcat.mbeanregistry.enabled=true
````

### Checkpoint

* If you run your Spring Boot application, the URI `/actuator/prometheus` should return metrics in Prometheus format
which look like this:
````text
# HELP tomcat_global_received_bytes_total  
# TYPE tomcat_global_received_bytes_total counter
tomcat_global_received_bytes_total{name="http-nio-8080",} 0.0
# HELP jvm_memory_max_bytes The maximum amount of memory in bytes that can be used for memory management
# TYPE jvm_memory_max_bytes gauge
jvm_memory_max_bytes{area="nonheap",id="CodeHeap 'profiled nmethods'",} 1.22912768E8
jvm_memory_max_bytes{area="heap",id="G1 Survivor Space",} -1.0
jvm_memory_max_bytes{area="heap",id="G1 Old Gen",} 1.073741824E9
jvm_memory_max_bytes{area="nonheap",id="Metaspace",} -1.0
jvm_memory_max_bytes{area="nonheap",id="CodeHeap 'non-nmethods'",} 5832704.0
jvm_memory_max_bytes{area="heap",id="G1 Eden Space",} -1.0
jvm_memory_max_bytes{area="nonheap",id="Compressed Class Space",} 1.073741824E9
jvm_memory_max_bytes{area="nonheap",id="CodeHeap 'non-profiled nmethods'",} 1.22912768E8
[..]
````


