// default context
//import java.util.concurrent.Executors
//
//import scala.concurrent.{ExecutionContext, Future}
//import scala.io.Source
//
//val f = Future {
//    val url = "localhost:8080"
//    // the blocking part tells the context there will be blocking operation inside which will let the fork-join thread pool increase thread number
//    blocking {
//        val contents = Source.fromURL(url).mkString
//    }
//}
//
//// chaning the default thread pool
//val pool = Executors.newCachedThreadPool()
//implicit val ec = ExecutionContext.fromExecutor(pool)
