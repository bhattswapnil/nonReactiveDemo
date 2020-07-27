package com.example.nonReactiveDemo

import org.springframework.stereotype.Component

@Component
class Dosage(
        val text:String?= null,
        val timing:Timing?= null
)