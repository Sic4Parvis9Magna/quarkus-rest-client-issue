package org.acme.rest.client

import io.smallrye.mutiny.Uni
import io.smallrye.mutiny.coroutines.awaitSuspending
import jakarta.enterprise.context.ApplicationScoped
import jakarta.inject.Named
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import org.eclipse.microprofile.rest.client.inject.RestClient
import java.util.concurrent.CompletionStage

@ApplicationScoped
class CoService(
    @Named("ExtensionsService")
    @field:RestClient
    val extensionsService: ExtensionsService
) {

    suspend fun getExtensions(id: String?) : List<Extension>{
//        val properTccl = Thread.currentThread().contextClassLoader
        return withContext(Dispatchers.IO) {
//            Thread.currentThread().contextClassLoader = properTccl
            extensionsService.getByIdAsUni(id)
        }.awaitSuspending().toList()
    }

    fun getById(id: String?): Set<Extension?>? {
        return extensionsService.getById(id)
    }

    fun getByIdAsync(id: String?): CompletionStage<Set<Extension?>?>? {
        return extensionsService.getByIdAsync(id)
    }

    fun getByIdAsUni(id: String?): Uni<Set<Extension>> {
        return extensionsService.getByIdAsUni(id)
    }
}