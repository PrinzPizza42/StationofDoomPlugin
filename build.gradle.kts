plugins {
    id("java")
    id("com.github.johnrengelman.shadow") version "8.1.1"
    id("xyz.jpenilla.run-paper") version "2.1.0"
    id("io.papermc.paperweight.userdev") version "1.5.5"
}

group = "org.example"
version = "1.11.2"

repositories {
    mavenLocal()
}

dependencies {
    paperweightDevelopmentBundle("io.papermc.paper:dev-bundle:1.20-R0.1-SNAPSHOT")
    implementation(files("lib/Discord-Webhooks-API-WithDependencies.jar"))
    implementation("com.google.code.gson:gson:2.10.1")
}

tasks {
    withType<JavaCompile> {
        options.encoding = "UTF-8"
    }
}

java {
    toolchain.languageVersion.set(JavaLanguageVersion.of(17))
}

tasks {
    runServer {
        minecraftVersion("1.20.1")
    }
}
