package science.mengxin.cats.eq

import cats.kernel.Eq

object EqMain extends App {
  //List(1, 2, 3).map(Option(_)).filter(item ⇒ item.get == 1)

  // After use the cat eq, if the type is different, compile error
  import cats.instances.int._
  val eqInt = Eq[Int]
  List(1, 2, 3).map(Option(_)).filter(item ⇒ eqInt.eqv(item.get, 1))
  import cats.syntax.eq._
  List(1, 2, 3).map(Option(_)).filter(item ⇒ item.get === 1)

  import cats.instances.option._ // for Eq
  // Some(1) === None
  (Some(1): Option[Int]) === (None: Option[Int])
  Option(1) === Option.empty[Int]
  import cats.syntax.option._
  1.some === none[Int]
  1.some =!= none[Int]

  import java.util.Date
  import cats.instances.long._ // for Eq

  implicit val dateEq: Eq[Date] =
    Eq.instance[Date] { (date1, date2) =>
      date1.getTime === date2.getTime
    }

  val x = new Date() // now
  val y = new Date() // a bit later than now

  x === x // res13: Boolean = true

  x === y // res14: Boolean = false
}
