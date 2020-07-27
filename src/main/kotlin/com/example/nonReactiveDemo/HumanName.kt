package com.example.nonReactiveDemo

import org.springframework.stereotype.Component


@Component
class HumanName(
        //id: String? = null,
        var family: String? = null,
        var text: String?= null,
        var given: MutableSet<String>? = null
) {
}