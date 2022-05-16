plugins {
    id("java")
    id("org.springframework.boot") version "2.6.7"
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-web:2.6.7")
    implementation("com.azure.spring:spring-cloud-azure-starter-keyvault-secrets:4.1.0")
}

description = "test-app"

repositories {
    maven {
        url = uri("https://repo.maven.apache.org/maven2/")
    }
}