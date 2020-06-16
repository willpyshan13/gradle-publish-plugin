package com.vv.life.publish

import com.vv.life.publish.MavenPublishPluginExtension.Companion.DEFAULT_TARGET
import com.vv.life.publish.MavenPublishPluginExtension.Companion.LOCAL_TARGET
import org.assertj.core.api.Assertions.assertThat
import org.junit.Test

class MavenPublishTargetTest {

  @Test
  fun uploadArchivesTaskName() {
    assertThat(_root_ide_package_.com.vv.life.publish.MavenPublishTarget(DEFAULT_TARGET).taskName).isEqualTo("uploadArchives")
  }

  @Test
  fun installArchivesTaskName() {
    assertThat(_root_ide_package_.com.vv.life.publish.MavenPublishTarget(LOCAL_TARGET).taskName).isEqualTo("installArchives")
  }

  @Test
  fun customTaskName() {
    assertThat(_root_ide_package_.com.vv.life.publish.MavenPublishTarget("myRepo").taskName).isEqualTo("uploadArchivesMyRepo")
  }
}
