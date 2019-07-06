package science.mengxin.cats.monad

import cats.Monad

object IdentityMonadDemo extends App {

  import cats.instances.int._

  // Important for comprehension
  import cats.syntax.flatMap._ // for first <-, flatMap in Monad
  import cats.syntax.functor._ // for second <-, map in functor

  def sumSquare2[F[_]: Monad](a: F[Int], b: F[Int]): F[Int] =
    for {
      x ← a
      y ← b
    } yield x * x + y * y

  // error
//  val r = sumSquare2(2, 3)

  import cats.Id
  val r = sumSquare2(3: Id[Int], 4: Id[Int])
  val r2 = sumSquare2(Monad[Id].pure(3), Monad[Id].pure(4))
}
