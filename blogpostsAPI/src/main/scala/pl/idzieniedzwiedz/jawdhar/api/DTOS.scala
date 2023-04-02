package pl.idzieniedzwiedz.jawdhar.api

import io.circe.{Decoder, Encoder}
import io.circe.*
import io.circe.syntax.*
import io.circe.Encoder.*
import io.circe.generic.auto.*
import io.circe.generic.AutoDerivation
import sttp.tapir.*


object DTOS {
  case class GetPostsResponse(
    metaData: Map[String, String],
    posts: List[String]
                             )

  implicit val getPostResponseEncoder: Encoder[GetPostsResponse] = response => Json.obj(
    "metadata" -> response.metaData.asJson,
    "posts" -> response.posts.asJson
  )

  implicit val getPostsResponseDecoder: Decoder[GetPostsResponse] = Decoder.forProduct2("metadata", "posts")(GetPostsResponse.apply)
  
}
