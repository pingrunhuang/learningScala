// adding up all the component

object Element{
    // put the abstract field as a class parameter
    private class ArrayElement(val contents: Array[String]) extends Element

    private class LineElement(l:String) extends Element {
        val contents = Array(l)
        override def width = l.length
        override def height = 1
    }

    private class UniformElement(
        chr: Char, 
        override width: Int,
        override height: Int
    ) extends Element {
        private val line = ch.toString * width
        def contents = Array.fill(height)(line)
    }

    // factory methods
    def elem(contents:Array[String]):Element = new ArrayElement(contents)
    def elem(chr: Char, width: Int, height:Int): Element = new UniformElement(chr, width, height)
    def elem(line: String): Element = new LineElement(line)
}


import Element.elem

abstract class Element {
    def contents: Array[String]
    def width:Int = contents.length
    def height:Int = if (contents.length==0) 0 else contents(0).length

    def widen(w: Int): Element = 
    if(w <= width) this else {
        val left = elem(' ', (w-width)/2, )
    }


    def above(that:Element): Element = {
        val this1 = 
    }
}