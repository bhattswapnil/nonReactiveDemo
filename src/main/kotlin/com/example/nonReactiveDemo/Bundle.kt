package com.example.nonReactiveDemo


class Bundle(
        var type: String? =null,
        var entry: MutableSet<BundleEntry>? = null,
        var resourceType: String? = null
)