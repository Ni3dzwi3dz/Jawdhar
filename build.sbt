val defaultScalaVersion = "3.2.0"
val scalaVersions = Seq(defaultScalaVersion)

val betterV = "3.9.2"
val circeV = "0.14.5"
val derevoV = "0.13.0"
val Http4sVersion = "1.0.0-M29"
val MunitVersion = "0.7.29"
val LogbackVersion = "1.2.6"
val MunitCatsEffectVersion = "1.0.6"
val sttpApiSpecV = "0.3.2"
val tapirV = "1.2.11"

lazy val commonSettings = Seq(
  organization := "pl.idzieniedzwiedz",
  version := "0.0.1-SNAPSHOT",
  crossScalaVersions := scalaVersions,
  ideSkipProject := (scalaVersion.value != defaultScalaVersion) || thisProjectRef.value.project
    .contains("JS") || thisProjectRef.value.project.contains("Native"),
  scalaVersion := defaultScalaVersion,
  scalacOptions := Seq(
    "-unchecked",
    "-deprecation",
    "-feature",
    "-language:postfixOps",
    "-language:existentials",
    "-language:_",
    "-encoding",
    "UTF-8"
  )
)

lazy val commonDependencies = Seq(
  libraryDependencies ++= Seq(
    "org.scalameta" %% "munit" % MunitVersion % Test,
    "org.typelevel" %% "munit-cats-effect-3" % MunitCatsEffectVersion % Test,
    "ch.qos.logback" % "logback-classic" % LogbackVersion
  )
)

lazy val root = (project in file("server"))
  .settings(commonDependencies)
  .settings(commonSettings)
  .settings(
    name := "jawdhar",
    libraryDependencies ++= Seq(
      "org.http4s" %% "http4s-ember-server" % Http4sVersion,
      "org.http4s" %% "http4s-ember-client" % Http4sVersion,
      "org.http4s" %% "http4s-circe" % Http4sVersion,
      "org.http4s" %% "http4s-dsl" % Http4sVersion
    ),
    testFrameworks += new TestFramework("munit.Framework")
  )

lazy val blogpostsapi = (project in file("blogpostsAPI"))
  .settings(name := "blogPostsAPI")
  .settings(commonDependencies)
  .settings(commonSettings)
  .settings(
    libraryDependencies ++= Seq(
      "com.github.pathikrit" %% "better-files" % betterV,
      "io.circe" %% "circe-core" % circeV,
      "io.circe" %% "circe-generic" % circeV,
      "com.softwaremill.sttp.apispec" %% "openapi-circe-yaml" % sttpApiSpecV,
      "com.softwaremill.sttp.tapir"   %% "tapir-openapi-docs" % tapirV,
      "com.softwaremill.sttp.tapir" %% "tapir-core" % tapirV,
      "com.softwaremill.sttp.tapir" %% "tapir-json-circe" % tapirV
    )
  )
