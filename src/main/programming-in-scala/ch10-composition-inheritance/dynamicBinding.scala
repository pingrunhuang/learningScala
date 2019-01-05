abstract class Element {
    def demo(){
        println("Element's implementation invoked")
    }
}

class ArrayElement extends Element {
    override def demo(){
        println("ArrayElement's implementation invoked")
    }
}

class LineElement extends ArrayElement {
    override def demo() {
        println("LineElement's implementation invoked")
    }
}

// inherits with no implementation
class UniformElement extends Element{
    def invokeDemo(e: Element){
        // the implementation is determined by runtime
        e.demo()
    }
}

val e = new UniformElement
e.invokeDemo(new UniformElement) // Element's implementation invoked

