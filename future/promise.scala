import scala.concurrent.duration._
import scala.concurrent._
import scala.concurrent.ExecutionContext.Implicits.global
import scala.util._

// TODO

def doSomething(arg:String):Int={
    arg.toInt
}

def computeAnswer(arg: String) = Future {
    val n = work(arg)
    n
}

def computeAnswer_promis(arg:String) = {
    val p = Promise[Int]()
    Future {
        val n = doSomething(arg)
        p.success(n)
        println("Finished doing something")
    }
    p.future
}

