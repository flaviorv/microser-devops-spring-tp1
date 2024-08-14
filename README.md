## Registering a Supplier service in a Eureka server
### Eureka server
* Dependency
<p align="center">
  <img src="./ex_eurekaServer/src/main/resources/static/prints/eureka_dependency.png"/>
</p>

* Annotation in Application Main
<p align="center">
  <img src="./ex_eurekaServer/src/main/resources/static/prints/eurekaapplication.png"/>
</p>

* Definning a port and making self-registration unbable
<p align="center">
  <img src="./ex_eurekaServer/src/main/resources/static/prints/app-properties-eureka.png"/>
</p>

### Supplier service
* Dependency
<p align="center">
  <img src="./supplier_service/src/main/resources/static/prints/eureka-client-dependency.png"/>
</p>

* Annotation in Application Main
<p align="center">
  <img src="./supplier_service/src/main/resources/static/prints/supplier-application-main.png"/>
</p>

* Connecting to Eureka server and enabling the registration
<p align="center">
  <img src="./supplier_service/src/main/resources/static/prints/app-propterties-supplier.png"/>
</p>

* Registered Supplier service
<p align="center">
  <img src="./supplier_service/src/main/resources/static/prints/registering_in_eureka.png"/>
</p>
