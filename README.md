# springboot-issueSolver


# For the Spring MVC to run, we should start the spring boot with AppConfig
#  SpringApplication.run(AppConfig.class, args);
# Change the PORT in application.properties
# http://localhost:8080/springrest/customers. This hit the /customers end point and will list down all the customers.
# http://localhost:8080/springrest/customers/{id} endpoint. This will display details of customer for given id.
# http://localhost:8080/springrest/customers using POSTMan extension. Once you do that, the new customer will be created and same can be viewed under /customers endpoint.