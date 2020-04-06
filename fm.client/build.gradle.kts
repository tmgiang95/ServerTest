dependencies {
    implementation("org.springframework.boot:spring-boot-starter-web:2.2.2.RELEASE")
    // implementation("org.springframework.boot:spring-boot-autoconfigure:2.2.2.RELEASE")

    implementation("com.fasterxml.jackson.core:jackson-databind:2.10.1")
    implementation(dependencyNotation = "org.openjdk.jmh:jmh-core:1.23")
    annotationProcessor(dependencyNotation = "org.openjdk.jmh:jmh-generator-annprocess:1.23")
    testImplementation("com.bigsonata.swarm:locust-swarm:1.1.1")
}
