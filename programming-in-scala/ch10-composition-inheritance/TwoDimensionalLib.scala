// task: build a 2 dimensional layout library 

// define abstract class
abstract class Element {
    // abstract member with no implementation
    def contents: Array[String]

    // define parameterless methods 
    def height: Int = contents.length
    def width: Int = if (height==0) 0 else contents(0).length

    // define methods as fields for parameterless methods
    // val height: Int = ...
    // access faster but memory cost more 

}

// instantiate the Element object
class ArrayElement(conts: Array[String]) extends Element {
    def contents: Array[String] = conts
}


// overriding methods with fields
// fields and methods are in the same namespace so we can override it
// fobidden in java
class SubElement(conts: Array[String]) extends Element {
    val contents: Array[String] = conts
}

// new way of avoiding new param like conts
class ArrayElement(val contents: Array[String]) extends Element


// invoking superclass constructors
class LineElement(s:String) extends Element(Array(s)) {
    val width = s.length
    val height = 1
}





