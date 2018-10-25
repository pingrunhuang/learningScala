import scala.concurrent.duration._
import java.time._
import scala.concurrent._
import scala.concurrent.ExecutionContext.Implicits.global
import scala.util._

// basic form

// t match {
//     case Success(v) => ...
//     case Failure(ex) => ...
// }
// OR
// if (t.isSuccess) ...
// if (t.isFailure) ...

// both are time consuming operation
val future1 = Future{getData1()}
val future2 = Future{getData2()}

def getData1():Int={Thread.sleep(1000);1}
def getData2():Int={Thread.sleep(1000);2}

// onComplete: non blocking way of passing back the callback function
// chain different tasks
future1.onComplete{
    case Success(n1) => future2 onComplete {
        case Success(n2) => {
            val n = n1 + n2
            println(s"Result : $n")
        }
        case Failure(ex) => println("Future2 failed")
    }
    case Failure(ex) => println("Future1 failed")
}

val combined1 = future1.map(n1 => n1+getData2())

val combined2 = future1.map(n1 => future2.map(n2 => n1 + n2))
// solve the Future[Future[Int]]
val combined3 = future1.map(n1 => future2.map(n2 => n1 + n2))

val combined4 = for (n1 <- future1; n2 <- future2) yield n1 + n2

// transform Set[Future[T]] into Future[Set[T]]
val futures = parts.map(p=>Future { for(i<-1 to 10) p })
val result = Future.sequence(futures)
// equal to 
val result = Future.traverse(parts)(p=>Future{for(i<-1 to 10) p})