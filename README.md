# Enjekt-Microservice
OSGi MicrowebServices

The intent of this project is to allow developers to install bundles and, using a simple blueprint OSGi service registration, have an interface exposed as REST and SOAP URIs.  

After downloading the project run the build pom which will install the major pieces and run a variety of OSGi, SOAP and REST tests against the provided echo service.

Part of the reason for creating this project is I've found many cases where bundles a web-base microservices make a lot of sense.  Having common defaults for interceptors and provdiers and addresses is the usual case.  But it also is commonly necessary to override or provide additional information - such as the relative URI, exception handlers, or new/different interceptors.

I've also had projects lately where different divisions use different ports while everything else in the configuration is identical. And being able to simply install and uninstall bundles and have them automatically get exposed or removed as web services is quite beneficial.  Additionally, since many of the properties are exposed via configuration files and the update strategy is reload, a bundle that needs to be moved from one port to another or to have its relative URI(s) changed can be done trivially by editing a cfg file in karaf.

As time goes on I hope to add more functionality to the project including the ability to monitor and configure bundle endpoint data.
