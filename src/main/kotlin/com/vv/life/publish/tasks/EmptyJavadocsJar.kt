package com.vv.life.publish.tasks

import org.gradle.jvm.tasks.Jar

@Suppress("UnstableApiUsage")
open class EmptyJavadocsJar : Jar() {

    init {
        archiveClassifier.set("javadoc")
    }
}
