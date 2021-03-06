package compilation

import org.scalatest.{FlatSpec, Matchers}

class ReadOnlyPropertySpec extends FlatSpec with Matchers {
  behavior of "[property].observe() extension method"

  it should "support ScalaFX read-only object properties" in {
    """
       import monix.reactive._
       import scalafx.beans.property._
       import fx.tools.monix._

       val prop: ReadOnlyObjectProperty[List[Int]] = ObjectProperty[List[Int]](Nil)
       val result: Observable[List[Int]] = prop.observe()
    """ should compile
  }

  it should "support ScalaFX read-only boolean properties" in {
    """
      import monix.reactive._
      import scalafx.beans.property._
      import fx.tools.monix._

      val prop: ReadOnlyBooleanProperty = BooleanProperty(false)
      val result: Observable[Boolean] = prop.observe()
    """ should compile
  }

  it should "support JavaFX read-only object properties" in {
    """
       import monix.reactive._
       import javafx.beans.property._
       import fx.tools.monix._

       val prop: ReadOnlyObjectProperty[List[Int]] = new SimpleObjectProperty[List[Int]](Nil)
       val result: Observable[List[Int]] = prop.observe()
    """ should compile
  }

  it should "support JavaFX read-only boolean properties" in {
    """
      import monix.reactive._
      import javafx.beans.property._
      import fx.tools.monix._

      val prop: ReadOnlyBooleanProperty = new SimpleBooleanProperty(false)
      val result: Observable[Boolean] = prop.observe()
    """ should compile
  }
}
