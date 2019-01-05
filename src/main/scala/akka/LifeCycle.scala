package akka

import akka.actor.{Actor, ActorSystem, Props}

/**
  * @ author Frank Huang
  * @ date 2018/12/12 
  */
object LifeCycle extends App {

  case object ForceRestart

  class Person extends Actor {

    /**
      * Since an ActorRef object is immutable, so there are only 3 ways to set the attribute of an actor
      * 1. preStart
      * 2. when instantiation
      * 3. sending message to an actor
      * */
    override def preStart{println(self.toString() + "pre-start")}

    override def postStop{println()}

    override def postRestart(reason: Throwable): Unit = {
      println(self.toString() + "post-restart")
      println(s"Reason: ${reason.getMessage}")
      super.postRestart(reason)
    }

    override def preRestart(reason: Throwable, message: Option[Any]): Unit = {
      println(s"${self.toString()}: pre-restart" )
      println(s"Message: ${message.getOrElse("")}")
      println(s"Reason: ${reason.getMessage}")

      super.preRestart(reason, message)
    }


    override def receive: Receive = {
      case ForceRestart => throw new Exception("Boom!")
      case _ =>
        println("Received a message")
        Thread.sleep(1000)
    }
  }

  val system = ActorSystem("LifeCycle")
//  instantiate an ActorRef object
  val frank = system.actorOf(Props[Person], name = "Frank")
  /*Sends a one-way asynchronous message. E.g. fire-and-forget semantics.*/
  frank ! "hello"


  println("restart frank")
  frank ! ForceRestart
  Thread.sleep(2000)

  println("stop frank")
  system.stop(frank)

  println("shut down system")
//  system.terminate()

}
