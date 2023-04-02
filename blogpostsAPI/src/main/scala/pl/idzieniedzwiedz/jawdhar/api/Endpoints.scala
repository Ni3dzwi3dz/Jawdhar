package pl.idzieniedzwiedz.jawdhar.api

import pl.idzieniedzwiedz.jawdhar.api.DTOS.*
import io.circe.Encoder.AsObject.importedAsObjectEncoder
import io.circe.Encoder.AsArray.importedAsArrayEncoder
import io.circe.Encoder.AsRoot.importedAsRootEncoder
import sttp.apispec.openapi.OpenAPI
import sttp.tapir.*
import sttp.tapir.json.circe.*
import sttp.tapir.generic.auto.*
import sttp.tapir.docs.openapi.{OpenAPIDocsInterpreter, OpenAPIDocsOptions}


object Endpoints {
  
  val basePath = "/v1/blogposts"
  private val openApiOptions = OpenAPIDocsOptions.default

  val getPosts: PublicEndpoint[Unit,Unit,GetPostsResponse,Any] = endpoint
    .in(basePath)
    .out(getPostsResponse)

  def getPostsResponse: EndpointIO[GetPostsResponse] = jsonBody[GetPostsResponse] 

  val openApi: OpenAPI =
    OpenAPIDocsInterpreter(openApiOptions).toOpenAPI(
      List(getPosts),
      title = "Jawdhar Blog Posts API",
      version = "1.0.0",
    )
}
