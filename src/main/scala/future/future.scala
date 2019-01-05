//import java.time._
//import scala.concurrent._
//// global thread pool ready for use, only for demo purpose
//import ExecutionContext.Implicits.global
//
//// code inside the Future block will be concurrent
//Future {
//    println("Hello world")
//    // how to do actual work here
//    Thread.sleep(10000)
//    println(s"This is the future at ${LocalTime.now}")
//}
//println(s"This is the present at ${LocalTime.now}")
//
//Future {
//    for (i<- 1 to 100){
//        print("A"); Thread.sleep(10)
//    }
//}
//
//Future {
//    for (i<- 1 to 100){
//        print("B"); Thread.sleep(10)
//    }
//}
//
//// wait for result
//import scala.concurrent.duration._
//var f = Future{Thread.sleep(5000);42}
//// wait for 10 seconds to finish, imported from duration package
//// if no result return after the given time, a TimeoutException will be thrown.
//val result = Await.result(f, 10.seconds)
//println(result)
//
//f = Future{
//    Thread.sleep(10000);
//    421
//}
//Await.ready(f, 10.seconds)
//// value return an Option[[T]]
//// t is an object of Try class
//val Some(t) = f.value
//
//
