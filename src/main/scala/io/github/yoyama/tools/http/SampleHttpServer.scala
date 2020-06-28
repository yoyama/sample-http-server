package io.github.yoyama.tools.http
import com.twitter.finagle.http.{Response}
import wvlet.airframe.http.{Endpoint, HttpMethod, Router}
import wvlet.airframe.http.finagle.Finagle

object SampleHttpServer extends App {
  val router = Router.add[DigdagWfApi]

  Finagle.server
    .withPort(8080)
    .withRouter(router)
    .start { server =>
      server.waitServerTermination
    }
}


@Endpoint(path="/digdag")
trait DigdagWfApi {
  @Endpoint(method = HttpMethod.GET, path = "/wf1")
  def wf1: Response = {
    val response = Response()
    response.contentType = "application/x-yaml"
    response.contentString =
      """
        |+t1:
        |  echo>: Test http_call> by YAML
        |""".stripMargin
    response
  }

  @Endpoint(method = HttpMethod.GET, path = "/wf2")
  def wf2: Response = {
    val response = Response()
    response.contentType = "application/json"
    response.contentString =
      """
        |{ "+t1" : {
        |    "echo>" : "Test http_call> by JSON"
        |  }
        |}
        |""".stripMargin
    response
  }
}