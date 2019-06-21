package science.mengxin.cats.monoid

import cats.kernel.{Monoid, Semigroup}

class MonoidCats {}

object MonoidCats extends App {

  import cats.instances.string._
  Monoid[String].combine("Hi ", "there")
  Monoid[String].empty

  Semigroup[String].combine("Hi ", "there")

  import cats.instances.int._ // for Monoid

  Monoid[Int].combine(32, 10)

  import cats.instances.option._ // for Monoid

  val a = Option(22)
  // a: Option[Int] = Some(22)

  val b = Option(20)
  // b: Option[Int] = Some(20)

  Monoid[Option[Int]].combine(a, b)
  // res6: Option[Int] = Some(42)

  import cats.syntax.semigroup._ // for |+|

  val stringResult = "Hi " |+| "there" |+| Monoid[String].empty
  // stringResult: String = Hi there

  import cats.instances.int._ // for Monoid

  val intResult = 1 |+| 2 |+| Monoid[Int].empty
  // intResult: Int = 3

  def add(items: List[Int]): Int = items.foldLeft(Monoid[Int].empty)(_ |+| _)

  import cats.syntax.semigroup._ // for |+|
  import cats.Monoid
  def add[A: Monoid](items: List[A]): A =
    items.foldLeft(Monoid[A].empty)(_ |+| _)

  add(List(Some(1), None, Some(2), None, Some(3)))

  import cats.instances._
//  add(List(Some(1), Some(2), Some(3)))
  // all element is Some, we don't have Some implicit instance
  import cats.instances.long._
  add(List(Some(1L), None, Some(2L), None, Some(3L)))
}
