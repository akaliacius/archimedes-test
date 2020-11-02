plugins {
    java
    application
}

java {
    sourceCompatibility = JavaVersion.VERSION_11
    targetCompatibility = JavaVersion.VERSION_11
}

tasks.withType<JavaCompile>() {
    options.compilerArgs.add("-Xlint:unchecked")
    options.compilerArgs.add("-Xlint:deprecation")
}

repositories {
    jcenter()
}

dependencies {
    implementation("org.springframework:spring-context:5.2.7.RELEASE")
    implementation("com.fasterxml.jackson.core:jackson-databind:2.11.3")
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.6.2")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.6.2")
}

application {
    mainClassName = "archimedes.test.App"
}

val test by tasks.getting(Test::class) {
    useJUnitPlatform()
}
