import org.springframework.boot.gradle.tasks.bundling.BootJar
import org.springframework.boot.gradle.tasks.run.BootRun

plugins {
    war
    jacoco
    id("org.springframework.boot") version "2.2.2.RELEASE"
    id("io.spring.dependency-management") version "1.0.8.RELEASE"
}

jacoco {
    toolVersion = "0.8.4"
    reportsDir = file("$buildDir/jacoco/reports")
}

sourceSets {
    create("jmh") {
        java {
            setSrcDirs(listOf("src/jmh/java"))
        }
        resources {
            setSrcDirs(listOf("src/jmh/resources"))
        }
        compileClasspath += sourceSets["test"].runtimeClasspath + sourceSets["test"].compileClasspath
        runtimeClasspath += sourceSets["test"].runtimeClasspath + sourceSets["test"].compileClasspath
        annotationProcessorPath += sourceSets["test"].runtimeClasspath + sourceSets["test"].compileClasspath
    }
}

dependencies {
    val springBoot = "org.springframework.boot"
    val springBootV = "2.2.2.RELEASE"

    implementation(dependencyNotation = "$springBoot:spring-boot-starter:$springBootV")
    implementation(dependencyNotation = "$springBoot:spring-boot-starter-web:$springBootV")
    implementation(dependencyNotation = "$springBoot:spring-boot-starter-actuator:$springBootV")
    implementation(dependencyNotation = "$springBoot:spring-boot-starter-data-jpa:$springBootV")
    implementation(dependencyNotation = "$springBoot:spring-boot-starter-data-rest:$springBootV")

    implementation(dependencyNotation = "com.jayway.jsonpath:json-path:2.4.0")
    implementation(dependencyNotation = "mysql:mysql-connector-java:8.0.19")
    implementation(dependencyNotation = "com.h2database:h2:1.4.200")
    implementation(group = "org.apache.commons", name = "commons-lang3", version = "3.10")

    testImplementation(dependencyNotation = "org.openjdk.jmh:jmh-core:1.23")
    testAnnotationProcessor(dependencyNotation = "org.openjdk.jmh:jmh-generator-annprocess:1.23")

    testImplementation(dependencyNotation = "$springBoot:spring-boot-starter-test:$springBootV")
}

tasks.register<JavaExec>("jmh") {
    dependsOn(tasks["jmhClasses"])
    main = "com.viettel.ems.fm.BenchmarkRunner"
    classpath = sourceSets["jmh"].compileClasspath + sourceSets["jmh"].runtimeClasspath

    // To enable the built-in stacktrace sampling profiler
    // args = ['-prof', 'stack']
}

tasks.getByName<BootRun>("bootRun") {
    args?.add("--spring.profiles.active=test")
}

tasks.getByName<BootJar>("bootJar") {
    mainClassName = "com.viettel.ems.fm.FM"
}

//region JACOCO ////////////////////////////////////////////////////////////////////////////////////////////////////////
tasks.test {
    useJUnitPlatform()

    extensions.configure(JacocoTaskExtension::class) {
        setDestinationFile(file("$rootDir/jacoco/jacocoTest.exec"))
        // classDumpDir = file("$rootDir/jacoco/classpathdumps")
    }
    doLast {
        tasks["jacocoTestReport"]
    }
}

tasks.jacocoTestReport {
    reports {
        xml.isEnabled = false
        // csv.isEnabled = false
        html.destination = file("$buildDir/jacoco/html")
    }
}

tasks.jacocoTestCoverageVerification {
    violationRules {
        rule {
            limit {
                minimum = "0.5".toBigDecimal()
            }
        }

        rule {
            enabled = false
            element = "CLASS"
            includes = listOf("org.gradle.*")

            limit {
                counter = "LINE"
                value = "TOTALCOUNT"
                maximum = "0.3".toBigDecimal()
            }
        }
    }
}

//endregion JACOCO
