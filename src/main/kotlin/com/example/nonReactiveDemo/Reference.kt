package com.example.nonReactiveDemo

import org.springframework.stereotype.Component

@Component
class Reference<Class>(
        //val id: String? = null,
        var reference: String? = null,
        var type: String? = null,
        var identifier: Identifier? = null
) {


}