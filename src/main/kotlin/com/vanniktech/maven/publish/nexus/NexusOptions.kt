package com.vanniktech.maven.publish.nexus

class NexusOptions {
  /**
   * Base url of the REST API of the nexus instance you are using.
   * Defaults to OSSRH ("https://oss.sonatype.org/service/local/").
   * @since 0.9.0
   */
  var baseUrl: String? = null

  /**
   * The groupId associated with your username.
   * Defaults to the GROUP Gradle Property.
   * @since 0.9.0
   */
  var groupId: String? = null

  /**
   * The username used to access the Nexus REST API.
   * Defaults to the SONATYPE_NEXUS_USERNAME Gradle property.
   * @since 0.9.0
   */
  var repositoryUsername: String? = null

  /**
   * The username used to access the Nexus REST API.
   * Defaults to the SONATYPE_NEXUS_PASSWORD Gradle property.
   * @since 0.9.0
   */
  var repositoryPassword: String? = null
}
