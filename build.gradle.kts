plugins {
    id("java")
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    // TestNG for testing
    testImplementation("org.testng:testng:7.10.2")

    // Selenium Java
    implementation("org.seleniumhq.selenium:selenium-java:4.20.0")

    // Apache POI (both core and OOXML for Excel support)
    implementation("org.apache.poi:poi:5.2.5")
    implementation("org.apache.poi:poi-ooxml:5.2.5")
}

tasks.test {
    useTestNG()
}