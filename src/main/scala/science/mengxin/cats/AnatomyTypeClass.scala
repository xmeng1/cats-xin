package science.mengxin.cats

class AnatomyTypeClass {}

object JsonSyntax {
  implicit class JsonWriterOps[A](value: A) {
    def toJson(implicit w: JsonWriter[A]): Json =
      w.write(value)
  }
}

// Define a very simple JSON AST
sealed trait Json
final case class JsObject(get: Map[String, Json]) extends Json
final case class JsString(get: String) extends Json
final case class JsNumber(get: Double) extends Json
case object JsNull extends Json

// The "serialize to JSON" behaviour is encoded in this trait
trait JsonWriter[A] {
  def write(value: A): Json
}

final case class Person(name: String, email: String)

// any definitions marked implicit in Scala MUST BE placed inside an object or trait
object JsonWriterInstances {
  implicit val stringWriter: JsonWriter[String] =
    (value: String) => JsString(value)

  implicit val personWriter: JsonWriter[Person] =
    (value: Person) =>
      JsObject(
        Map("name" -> JsString(value.name), "email" -> JsString(value.email))
    )

  // etc...
}

object Json {
  def toJson[A](value: A)(implicit w: JsonWriter[A]): Json =
    w.write(value)
}
