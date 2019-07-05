package science.mengxin.cats.blog

object FunctorApplicativesMonad extends App {

  var a = Option(2)
  var b = Option.empty

  def add3 = (x: Int) => { x + 3 }

  val result = a.map(add3)
  println(result)

  val result2 = b.map(add3)
  println(result2)

  import cats.instances.function._ // for Functor
  import cats.syntax.functor._ // for map

  def add3and2 = add3.map(x ⇒ x + 2)

  val result3 = a.map(add3and2)
  println(result3)

//  import cats.implicits._

  val f: (Int, Char) => Double = (i, c) => (i + c).toDouble

  val int: Option[Int] = Some(5)
  val char: Option[Char] = Some('a')
  val result4 = int.map(i => (c: Char) => f(i, c))
  println(result4)
}
