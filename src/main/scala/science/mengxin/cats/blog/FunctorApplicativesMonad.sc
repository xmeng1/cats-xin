// see the https://scastie.scala-lang.org/xmeng1/4eerX2FZQtmKz38SQzmXtQ/1
//<script src="https://scastie.scala-lang.org/xmeng1/4eerX2FZQtmKz38SQzmXtQ/1.js"></script>
var a = Option(2)
var b = Option.empty


def add = (x: Int) => { x + 3 }

val result = a.map(add).map(add)
val result2 = b.map(add).map(add)

import cats.instances.function._ // for Functor
import cats.syntax.functor._ // for map
val add3Twice = add.map(add)

val result3 = a.map(add3Twice)