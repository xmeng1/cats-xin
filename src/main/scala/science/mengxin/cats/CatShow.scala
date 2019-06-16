package science.mengxin.cats

import cats.Show
import cats.syntax.show._
class CatShow {}

object CatShowMain extends App {

  implicit val catShow = Show.show[Cat] { cat =>
    import cats.instances.int._ // for Show
    import cats.instances.string._ // for Show
    val name = cat.name.show
    val age = cat.age.show
    val color = cat.color.show
    s"$name is a $age year-old $color cat."
  }
  println(Cat("Garfield", 38, "ginger and black").show)
  println(Cat("Garfield", 38, "ginger and black").show)
}
