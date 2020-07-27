package com.example.nonReactiveDemo

import org.bson.types.Code
import java.net.URI
import java.util.*

open class Coding(
        val system: String?= null,
        val version: String?= null,
        val code: String?= null,
        val display: String?= null,
        val userSelected: Boolean? =null

)