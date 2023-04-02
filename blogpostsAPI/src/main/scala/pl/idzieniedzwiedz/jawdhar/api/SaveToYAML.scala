package pl.idzieniedzwiedz.jawdhar.api

import better.files.File
import sttp.apispec.openapi.circe.yaml._

private[api] object SaveToYAML extends App {
   
    val file = File("server/src/main/resources/blogposts-api-swagger.yaml")
    file.overwrite(Endpoints.openApi.toYaml)
}
