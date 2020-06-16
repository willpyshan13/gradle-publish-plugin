package com.vv.life.publish.tasks

import org.gradle.jvm.tasks.Jar

@Suppress("UnstableApiUsage")
open class EmptySourcesJar : Jar() {

    init {
        archiveClassifier.set("sources")
    }
}
