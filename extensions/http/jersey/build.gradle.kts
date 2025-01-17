/*
 *  Copyright (c) 2021 Copyright Holder (Catena-X Consortium)
 *
 *  This program and the accompanying materials are made available under the
 *  terms of the Apache License, Version 2.0 which is available at
 *  https://www.apache.org/licenses/LICENSE-2.0
 *
 *  SPDX-License-Identifier: Apache-2.0
 *
 *  Contributors:
 *      Catena-X Consortium - initial API and implementation
 *
 */

plugins {
    `java-library`
}

val jakartaValidationApi: String by project
val jerseyVersion: String by project
val okHttpVersion: String by project
val restAssured: String by project
val rsApi: String by project

dependencies {
    api(project(":spi:common:web-spi"))
    api(project(":extensions:http:jetty"))

    implementation("org.glassfish.jersey.core:jersey-server:${jerseyVersion}")
    implementation("org.glassfish.jersey.containers:jersey-container-servlet-core:${jerseyVersion}")
    implementation("org.glassfish.jersey.core:jersey-common:${jerseyVersion}")
    implementation("org.glassfish.jersey.media:jersey-media-json-jackson:${jerseyVersion}")
    implementation("org.glassfish.jersey.media:jersey-media-multipart:${jerseyVersion}")
    implementation("org.glassfish.jersey.inject:jersey-hk2:${jerseyVersion}")
    implementation("org.glassfish.jersey.containers:jersey-container-servlet:${jerseyVersion}")

    implementation("org.eclipse.jetty.toolchain:jetty-jakarta-servlet-api:5.0.2")

    testImplementation(project(":extensions:junit"))

    testImplementation("com.squareup.okhttp3:okhttp:${okHttpVersion}")
    testImplementation("io.rest-assured:rest-assured:${restAssured}")
    testImplementation("org.glassfish.jersey.ext:jersey-bean-validation:${jerseyVersion}") //for validation
}

publishing {
    publications {
        create<MavenPublication>("jersey") {
            artifactId = "jersey"
            from(components["java"])
        }
    }
}
