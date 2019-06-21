package science.mengxin.cats.functors

class FunctorsDemo extends App {

  import cats.instances.function._ // for Functor
  import cats.syntax.functor._ // for map
  val func =
    ((x: Int) => x.toDouble).map(x => x + 1).map(x => x * 2).map(x => x + "!")

  func(123)

  List(3)
}
