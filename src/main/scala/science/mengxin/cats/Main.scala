package science.mengxin.cats

import cats.instances.string._
import cats.syntax.semigroup._

object Main extends App {
  println("Hello " |+| "Cats!")

  import JsonWriterInstances._
  Json.toJson(Person("Dave", "dave@example.com"))

  import JsonWriterInstances._
  import JsonSyntax._

  Person("Dave", "dave@example.com").toJson
}
