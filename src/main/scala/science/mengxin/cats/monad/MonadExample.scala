package science.mengxin.cats.monad

import scala.concurrent.Future

object MonadExample extends App {

  import cats.Monad
  import cats.instances.option._ // for Monad
  import cats.instances.list._ // for Monad

  val opt1 = Monad[Option].pure(3)
  println(opt1)

  val opt2 = Monad[Option].flatMap(opt1)(a ⇒ Some(a + 2))
  println(opt2)

  val opt3 = Monad[Option].map(opt2)(a => 100 * a)

  val list1 = Monad[List].pure(3)

  val list2 = Monad[List].flatMap(List(1, 2, 3))(a => List(a, a * 10))

  val list3 = Monad[List].map(list2)(a => a + 123)

  import scala.concurrent.ExecutionContext.Implicits.global
  import cats.instances.future._ // for Monad
  import scala.concurrent._
  import scala.concurrent.duration._

  val fm = Monad[Future]

  val future = fm.flatMap(fm.pure(1))(x => fm.pure(x + 2))

  Await.result(future, 1.second)

  import cats.instances.option._ // for Monad
  import cats.instances.list._ // for Monad
  import cats.syntax.applicative._ // for pure

  1.pure[Option]

  1.pure[List]

  import cats.syntax.functor._
  import cats.syntax.flatMap._

  // we define Monad as type, and input two parameters with Monad Type!
  def sumSquare[F[_]: Monad](a: F[Int], b: F[Int]): F[Int] =
    a.flatMap(x ⇒ b.map(y ⇒ x * x + y * y))

  import cats.instances.option._ // for Monad
  sumSquare(Option(3), Option(4))

  sumSquare(List(1, 2, 3), List(4, 5))

  // F[_] is high kind type, so we can specific any type in the F, such as here we specific it as Int.
  def sumSquare2[F[_]: Monad](a: F[Int], b: F[Int]): F[Int] =
    for {
      x ← a
      y ← b
    } yield x * x + y * y

  sumSquare2(Option(3), Option(4))

  sumSquare2(List(1, 2, 3), List(4, 5))
  // get compile error, before the type in F[_] not match  String - Int
//  val r = sumSquare2(List("xxx", "xxx", "xxx"), List("xxx", "xxx"))
//  println(r)

}
