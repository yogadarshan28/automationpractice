plugins {
    id("java")
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    // TestNG
    testImplementation("org.testng:testng:7.10.2")

    // ✅ Compatible versions
    implementation("org.seleniumhq.selenium:selenium-java:4.16.1")
    testImplementation("io.appium:java-client:9.1.0")

    // Apache POI
    implementation("org.apache.poi:poi:5.2.5")
    implementation("org.apache.poi:poi-ooxml:5.2.5")

    implementation("io.jsonwebtoken:jjwt-api:0.11.5")
    runtimeOnly("io.jsonwebtoken:jjwt-impl:0.11.5")
    runtimeOnly("io.jsonwebtoken:jjwt-jackson:0.11.5")
}

tasks.test {
    useTestNG()
}
