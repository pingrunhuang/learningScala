abstract class Element {
    // abstract member with no implementation
    def contents: Array[String]

    // define parameterless methods 
    val height: Int = contents.length
    def width: Int = if (height==0) 0 else contents(0).length

    // define methods as fields for parameterless methods
    // val height: Int = ...
    // access faster but memory cost more 

}

// create a new form of element that has a given width and height and is filled everywhere with a given char
class UniformElement(
    ch: Char,
    // using override modifiers
    override val width: Int,
    override val height: Int
) extends Element {
    private val line = ch.toString * width,
    def contents = Array.fill(height)(line)
}

