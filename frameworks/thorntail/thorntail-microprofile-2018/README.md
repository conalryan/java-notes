# [Thorntail A Micro Implementation of Eclipse MicroProfile](https://www.youtube.com/watch?v=eJBqo8iKBHI&list=PLSqfisWkiKJhCB03OvWvcY3vKzkglByvd&index=5&t=0s)

https://github.com/kenfinnigan/thorntail-microprofile-2018

- Formerly WildFly Swarm
- Red Hat's implementation of Eclipse MicroProfile

# MicroProfile
- Microservices specifications for Enterprise Java.
- Industry collaboration within the Eclipse Foundation
- 8 implementations
- Rapid (predicatable) release cadence

# MicroProfile 2.1
- Open Tracing 1.2
- Open API 1.0
- Rest Client 1.1
- Config 1.3
- Fault Tollerance 1.1
- Metrics 1.1
- JWT Propagation 1.1
- Health Check 1.0
- CDI 2.0
- JSON P 1.1
- JAX RS 2.1
- JSON B 1.0

## SmallRye
- Implements Eclipse MicroProfile specifications
- Extracts common elements from Thorntail to allow other vendors to use them and collaborate
- Utilized by Thorntail and WildFly today

## Open API Tracing
- Thorntail uses **Jaeger** implementation
- Add Jaeger
````xml
<dependency>
  <groupId>io.thorntail</groupId>
  <artifactId>jaeger</artifactId>
</dependency>
````
- Add Jaeger configuration in yml
````yaml
jaeger:
    service-name: 'greeting'
    sampler-type: 'const'
    sampler-parameter: 1
    remote-reporter-http-endpoint: 'http://localhost:14268/api/traces'
````
- Start Docker container for Jaeger
````bash
docker run -p5775:5775/udp -p6831:6831/udp -p6832:6832/udp -p5778:5778 -p16686:16686 -p14268:14268 -p9411:9411 jaegertracing/all-in-one:latest
````
- Go to URL http://localhost:16686/

