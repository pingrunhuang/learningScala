/**
  * This snippet illestrate the use case of @transient lazy val pattern
  *
  *
  * lazy val is telling scala that a field should be seriablizable, but with @transient, we are telling scala this field should not be serializable. This is to say we can create the "recalculate rather than serialize logic"
  *
  * What does it mean we want the field to be serializable and also not serializable?
  * For the following code, if we ignore the lazy syntax, we will eventually get a null value from the foo2.baz statement. This is because after deserialized, we did not initialize the foo object. However, with the lazy val syntax, we actually tell scala, ok, the field is not serializable, what do we do now? we can recreate it once we call it.
  *
  * Good for lower the cost of network transfering of object but also be able to transmit the object
  * */

object TransientLazyVal extends App{

    class Foo(val bar:String) extends Serializable {
        lazy val baz: String = {
            println("Calculate baz")
            bar+"world"
        }
    }

    // Create object of class Foo
    val foo = new Foo("Hello")

    // baz field is only calculated once
    println(foo.baz)
    println(foo.baz)
    // Serialize foo
    import java.io._
    val bo = new ByteArrayOutputStream
    val o = new ObjectOutputStream(bo)
    o.writeObject(foo)
    val bytes = bo.toByteArray

    // Deserialize foo
    val bi = new ByteArrayInputStream(bytes)
    val i = new ObjectInputStream(bi)
    val foo2 = i.readObject.asInstanceOf[Foo]

    // baz field is recalculated once and only once
    println(foo2.baz)
    println(foo2.baz)
}
