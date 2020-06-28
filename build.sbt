import Dependencies._

ThisBuild / scalaVersion     := "2.13.2"
ThisBuild / version          := "0.1.0-SNAPSHOT"
ThisBuild / organization     := "io.github.yoyama.tools.http"
ThisBuild / organizationName := "TestHttpServer"

lazy val root = (project in file("."))
  .settings(
    name := "sample-http-server",
    libraryDependencies ++= Seq(
      "org.wvlet.airframe" %% "airframe-http-finagle" % "20.6.1",
	    scalaTest % Test
    )
  )

// See https://www.scala-sbt.org/1.x/docs/Using-Sonatype.html for instructions on how to publish to Sonatype.
