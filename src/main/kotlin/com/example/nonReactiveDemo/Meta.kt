package com.example.nonReactiveDemo

import org.springframework.stereotype.Component
import java.time.ZoneId
import java.time.ZonedDateTime

@Component
class Meta(
        id: String? = null,
        var versionId: String? = "1",
        var lastUpdated: ZonedDateTime? = null,
        var source: String? = null,
        var profile: MutableSet<String>? = null,
        var security: MutableSet<out Coding>? = null,
        var tag: MutableSet<Coding>? = null,
        var whenDeleted: String? = null
)