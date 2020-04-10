trait Publisher {
  private var subscribers: Set[Subscriber] = Set()
  def subscribe(subscriber: Subscriber): Unit =
    subscribers += subscriber
  def unsubscribe(subscriber: Subscriber): Unit =
    subscribers -= subscriber
  def publish(): Unit =
    subscribers.foreach(_.handler(this))
}

trait Subscriber {
  def handler(pub: Publisher)
}

class BankAccount extends Publisher {
  private var balance = 0
  def currentBalance: Int = balance
  def deposit(amount: Int): Unit = {
    if (amount > 0) balance = balance + amount
    publish()
  }
  def withdraw(amount: Int): Unit = {
    if (0 < amount && amount <= balance) {
      balance = balance - amount
      publish()
    } else throw new Error("insufficient funds")
  }
}

class Consolidator(observed: List[BankAccount]) extends Subscriber {
  observed.foreach(_.subscribe(this))
  // initially uninitialized
  private var total: Int = _
  compute()
  private def compute() =
    total = observed.map(_.currentBalance).sum
  def handler(pub: Publisher) = compute()
  def totalBalance = total
}