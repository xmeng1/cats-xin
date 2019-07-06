package science.mengxin.cats.monad

import cats.Eval

object EvalDemo extends App {

  val x = {
    println("Computing X")
    math.random
  }

  println(x)
  println(x)

  def y = {
    println("Computing Y")
    math.random
  }

  println(y)
  println(y)

  lazy val z = {
    println("Computing Z")
    math.random
  }
  println(z)
  println(z)

  val now = Eval.now(math.random + 1000)
  val later = Eval.later(math.random + 2000)
  val always = Eval.always(math.random + 3000)

  println(now)
  println(later)
  println(always)

  val greeting = Eval.always { println("Step 1"); "Hello" }.map { str =>
    println("Step 2"); s"$str world"
  }

  println(greeting.value)
}
