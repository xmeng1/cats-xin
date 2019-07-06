package science.mengxin.cats.monad

object EitherDemo extends App {

  val either1: Either[String, Int] = Right(10)
  val either2: Either[String, Int] = Right(32)

  val r1 = for {
    a ← either1.right
    b ← either2.right
  } yield a + b
  println(r1)

  val r2 = for {
    a ← either1
    b ← either2
  } yield a + b
  println(r2)

  import cats.syntax.either._ // for map and flatMap
  val r3 = for {
    a ← either1
    b ← either2
  } yield a + b
  println(r3)

  import cats.syntax.either._ // for map and flatMap

  val a = 3.asRight[String]
  val b = 4.asRight[String]

  val r4 = for {
    x ← a
    y ← b
  } yield x * x + y * y
  println(r4)

//  def countPositive(nums: List[Int]) =
//    nums.foldLeft(Right(0)) { (accumulator, num) ⇒
//        if (num > 0) {
//          accumulator.map(_ + 1)
//        } else {
//          Left("Negative. Stopping")
//        }
//    }

  def countPositive(nums: List[Int]) =
    nums.foldLeft(0.asRight[String]) { (accumulator, num) ⇒
      if (num > 0) {
        accumulator.map(_ + 1)
      } else {
        Left("Negative. Stopping")
      }
    }

  val r5 = countPositive(List(1, 2, 3))

  val r6 = countPositive(List(1, -2, 3))
  println(r5)
  println(r6)

  Either.catchOnly[NumberFormatException]("foo".toInt)
  Either.catchNonFatal(sys.error("Badness"))
  Either.fromTry(scala.util.Try("foo".toInt)) // Left(java.lang.NumberFormatException: For input string: "foo")
  Either.fromOption[String, Int](None, "Badness") // Left(Badness)

  "Error".asLeft[Int].getOrElse(0)
  "Error".asLeft[Int].orElse(2.asRight[String])

  (-1).asRight[String].ensure("Must be non-negative!")(_ > 0)

  "error".asLeft[Int].recover { case str: String => -1 }
}
