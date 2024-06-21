package org.acme.rest.client

import io.smallrye.mutiny.Uni
import jakarta.inject.Named
import jakarta.ws.rs.GET
import jakarta.ws.rs.Path
import java.util.concurrent.CompletionStage
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient
import org.jboss.resteasy.reactive.RestQuery


@Path("/extensions")
@Named("ExtensionsService")
@RegisterRestClient(configKey = "extensions-api")
interface ExtensionsService {
    @GET
    fun getById(@RestQuery id: String?): Set<Extension?>?

    @GET
    fun getByIdAsync(@RestQuery id: String?): CompletionStage<Set<Extension?>?>?

    @GET
    fun getByIdAsUni(@RestQuery id: String?): Uni<Set<Extension>>

    @GET
    fun c(@RestQuery id: String?): Set<Extension>
}