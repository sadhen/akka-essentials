package org.akka.essentials.scala.dispatcher.example.Dispatcher
import akka.actor.ActorSystem
import com.typesafe.config.ConfigFactory
import akka.actor.Props
import akka.routing.RoundRobinPool
import org.akka.essentials.scala.dispatcher.MsgEchoActor

object Example2 {
	def main(args: Array[String]): Unit = {}
	val _system = ActorSystem.create("default-dispatcher",ConfigFactory.load().getConfig("MyDispatcherExample"))

	val actor = _system.actorOf(RoundRobinPool(5).withDispatcher("defaultDispatcher1").props(Props[MsgEchoActor]))

	0 to 25 foreach {
		i => actor ! i
	}
  Thread.sleep(3000)
	_system.terminate()
}