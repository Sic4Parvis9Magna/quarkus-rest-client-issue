package org.acme.rest.client

import io.smallrye.common.annotation.Blocking
import io.smallrye.mutiny.Uni
import jakarta.ws.rs.GET
import jakarta.ws.rs.Path
import java.util.concurrent.CompletionStage


@Path("/extension")
class ExtensionsResource(val coService: CoService) {

    @GET
    @Path("/id/{id}")
    @Blocking
    fun id(id: String?): Set<Extension?>? {
        return coService!!.getById(id)
    }

    @GET
    @Path("/id-async/{id}")
    fun idAsync(id: String?): CompletionStage<Set<Extension?>?>? {
        return coService.getByIdAsync(id)
    }

    @GET
    @Path("/id-uni/{id}")
    fun idUni(id: String?): Uni<Set<Extension>> {
        return coService.getByIdAsUni(id)
    }

    @GET
    @Path("/id-co/{id}")
    suspend fun idCoroutine(id: String?): List<Extension> {
        return coService.getExtensions(id)
    }
}