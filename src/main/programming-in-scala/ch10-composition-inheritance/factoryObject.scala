abstract class Element{
    def contents: Array[String]
    def width: Int = if(height==0) 0 else contents(0).length
    def height:Int = contents.length

    // without dot notation and without parentheses
    override def toString = contents mkString "\n"

    def above(that: Element): Element
    def beside(that: Element): Element
}

class ArrayElement(conts: Array[String]) extends Element {
    def contents:Array[String] = contents
    override def above(that: Element): Element {
        return new ArrayElement(this.contents ++ that.contents)
    }
    override def beside(that: Element): Element {
        new Array(
            for ((line1, line2) <- this.contents zip that.contents) yield line1+line2
        )
        
    }
    // which is equal to 
    // def beside(that: Element): Element = {
    //       val contents = new Array[String](this.contents.length)
    //       for (i <- 0 until this.contents.length)
    //         contents(i) = this.contents(i) + that.contents(i)
    //       new ArrayElement(contents)
    // }
}

// companion object with factory method, to invoke the factory method:
// import Element.elem
object Element {
    def elem(contents:Array[String]):Element = new ArrayElement(contents)
    def elem(chr: Char, width: Int, height:Int): Element = new UniformElement(chr, width, height)
    def elem(line: String): Element = new LineElement(line)
}
