/*
package science.mengxin.cats.monoid

class MonoidDemo {}

//trait Monoid[A] {
//  def combine(x: A, y: A): A
//  def empty: A
//
//  def associativeLaw[B](x: B, y: B, z: B)(implicit m: Monoid[B]): Boolean = {
//    m.combine(x, m.combine(y, z)) ==
//      m.combine(m.combine(x, y), z)
//  }
//
//  def identityLaw[B](x: B)(implicit m: Monoid[B]): Boolean = {
//    (m.combine(x, m.empty) == x) &&
//    (m.combine(m.empty, x) == x)
//  }
//}

trait Semigroup1[A] {
  def combine(x: A, y: A): A
}

trait Monoid1[A] extends Semigroup1[A] {
  def empty: A
}

object IntSemiGroup extends Semigroup1[Int] {
  def combine(a: Int, b: Int): Int = a + b
}
*/
