package org.acme.rest.client

import io.quarkus.runtime.Startup
import jakarta.enterprise.context.ApplicationScoped
import kotlinx.coroutines.Dispatchers


@ApplicationScoped
class EagerAppBean {
    @Startup
    fun init() {
        val properTccl = Thread.currentThread().contextClassLoader
        println("Current classloader: ${properTccl.name}")
        properTccl.loadClass("org.acme.rest.client.Extension") // loading ok
        val parent = properTccl.parent
        println("Current classloader: ${parent.name}")
//        parent.loadClass("org.acme.rest.client.Extension") // class not found
    }
}