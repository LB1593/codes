// C:/scalaExamples/listExample.scala

package bounds.abbrevlist

sealed abstract class AbbrevList[+A] {

  def isEmpty: Boolean
  def head: A
  def tail: AbbrevList[A]

  def ::[B >: A] (x: B): AbbrevList[B] = new bounds.abbrevlist.::(x, this)

  final def foreach(f: A => Unit) = {
    var these = this
    while (!these.isEmpty) {
      f(these.head)
      these = these.tail
    }
  }
}

// La AbbrevList vuota.

case object AbbrevNil extends AbbrevList[Nothing] {
  override def isEmpty = true

  def head: Nothing =
    throw new NoSuchElementException("testa della AbbrevList vuota")

  def tail: AbbrevList[Nothing] =
    throw new NoSuchElementException("coda della AbbrevList vuota")
}

// Una AbbrevList non vuota caratterizzata da una testa e una coda.

final case class ::[B](private var hd: B,
    private[abbrevlist] var tl: AbbrevList[B]) extends AbbrevList[B] {

  override def isEmpty: Boolean = false
  def head : B = hd
  def tail : AbbrevList[B] = tl
}