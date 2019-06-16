package science.mengxin.cats

trait Printable[A] {
  def format(value: A): String
}

object PrintableInstances {
  implicit val stringPrintable = new Printable[String] {
    override def format(input: String): String = input
  }

  implicit val intPrintable = new Printable[Int] {
    override def format(input: Int): String = input.toString
  }
}

object Printable {
  def format[A](input: A)(implicit p: Printable[A]): String =
    p.format(input)

  def print[A](input: A)(implicit p: Printable[A]): Unit =
    println(format(input))
}

object PrintableSyntax {
  implicit class PrintableOps[A](value: A) {
    def format(implicit p: Printable[A]): String =
      p.format(value)

    def print(implicit p: Printable[A]): Unit =
      println(format(p))
  }
}

object PrintableMain extends App {
  import PrintableInstances._

  implicit val catPrintable = new Printable[Cat] {
    def format(cat: Cat) = {
      val name = Printable.format(cat.name)
      val age = Printable.format(cat.age)
      val color = Printable.format(cat.color)
      s"$name is a $age year-old $color cat."
    }
  }

  val cat = Cat("Garfield", 38, "ginger and black")
  // cat: Cat = Cat(Garfield,38,ginger and black)

  Printable.print(cat)
  // Garfield is a 38 year-old ginger and black cat.

  import PrintableSyntax._
  cat.print
}
