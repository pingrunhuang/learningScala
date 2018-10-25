/*
currying is applied to multiple argument lists
*/
// bunch of function literal

// non-curried
def sum1(x:Int, y:Int) = x+y
// curried
def sum2(x:Int, y:Int) = x+y
// equal to 
def sum3(x:Int) = (y:Int) => x+y
// moreover, to get a secend functions
def onePlus(x:Int) = sum3(1)_



/*To refactor the filematch code*/


/*loan pattern: a control abstraction funcion opens resource and loan to inner funcion and close the resource*/

def withPrintWriter(file:File, op: PrintWriter => Unit) {
    val writer = new PrintWriter(file)
    try {
        op(writer)
    } finally {
        writer.close()
    }
}

// currying version
def withPrintWriterCurry(file:File)(op: PrintWriter => Unit){
    // ...

    // remember to close the resources
}

/*
with currying, the implementation of the open resource action could be differed to different resources.
*/

// invocation
val file = new File("date.txt")
withPrintWriterCurry(file) {
    writer => writer.println()
}

