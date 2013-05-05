package org.elasticmq.msg

import org.elasticmq.data.{QueueAlreadyExists, QueueData}
import akka.actor.ActorRef
import org.elasticmq.actor.reply.Replyable

sealed trait QueueManagerMsg[T] extends Replyable[T]

case class CreateQueue(queueData: QueueData) extends QueueManagerMsg[Either[QueueAlreadyExists, ActorRef]]
case class DeleteQueue(queueName: String) extends QueueManagerMsg[Unit]
case class LookupQueue(queueName: String) extends QueueManagerMsg[Option[ActorRef]]
case class ListQueues() extends QueueManagerMsg[Seq[String]]