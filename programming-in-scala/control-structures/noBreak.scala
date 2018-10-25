
// there is no break in scala. instead, transform the for loop into while 

var i = 0 
var found = false
while (i < args.length && !found){
    if (!args(i).startsWith("-")) {
        if(args(i).endWith(".scala"))
            found = true
    }
    i+=1
}

// built-in function for break which is actually throwing an exception
import scala.util.control.Breaks._
import java.io._
val in = new BufferedReader(new InputStreamReader(System.in))
breakable {
    while (true) {
        println("? ")
        if (in.readLine() == "") break
    }
}
