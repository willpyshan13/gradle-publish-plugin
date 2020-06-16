package com.vv.life.publish.nexus

import com.vv.life.publish.MavenPublishPluginExtension
import com.vv.life.publish.findMandatoryProperty
import com.vv.life.publish.findOptionalProperty
import org.gradle.api.DefaultTask
import org.gradle.api.tasks.TaskAction

open class CloseAndReleaseRepositoryTask : DefaultTask() {
  @SuppressWarnings("unused")
  @TaskAction
  fun closeAndReleaseRepository() {
    val mavenPublishPluginExtension = project.extensions.getByType(MavenPublishPluginExtension::class.java)
    val nexusOptions = mavenPublishPluginExtension.nexusOptions

    val baseUrl = nexusOptions.baseUrl ?: OSSRH_API_BASE_URL
    val groupId = nexusOptions.groupId ?: project.findMandatoryProperty("GROUP")
    val repositoryUsername = nexusOptions.repositoryUsername
      ?: project.findOptionalProperty("SONATYPE_NEXUS_USERNAME")
      ?: System.getenv("SONATYPE_NEXUS_USERNAME")

    requireNotNull(repositoryUsername) {
      "Please set a value for SONATYPE_NEXUS_USERNAME"
    }

    val repositoryPassword = nexusOptions.repositoryPassword
      ?: project.findOptionalProperty("SONATYPE_NEXUS_PASSWORD")
      ?: System.getenv("SONATYPE_NEXUS_PASSWORD")

    requireNotNull(repositoryPassword) {
      "Please set a value for SONATYPE_NEXUS_PASSWORD"
    }

    Nexus(repositoryUsername, repositoryPassword, groupId, baseUrl).closeAndReleaseRepository()
  }

  companion object {
    const val OSSRH_API_BASE_URL = "https://oss.sonatype.org/service/local/"
  }
}
