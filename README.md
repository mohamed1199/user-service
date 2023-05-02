## This microservice is designed to be run on AWS infrastructure, specifically using ECS Fargate, Service Discovery, and a CI/CD pipeline with Jenkins.

This is a basic Spring Boot microservice created to test AWS infrastructure with services like ECS Fargate, Service Discovery with service connect, and CI/CD pipeline with Jenkins. This project is a good starting point for learning how to work with Spring Boot microservices in AWS.

![Alt text](images/arch.png?raw=true "Optional Title")

## The full CDK project for provisioning this infrastructure can be found here.
### [CDK Project](https://github.com/peaqock-financials/cdk-fargate-alb-project.git)



## CI/CD Pipeline with Jenkins

This microservice is built and deployed using a CI/CD pipeline with Jenkins. Jenkins is a popular open-source automation server that can be used to automate various stages of the software delivery process. The pipeline includes stages for building, testing, and deploying the microservice.

![Alt text](images/pipe.png?raw=true "Optional Title")
