package bio

import bio.symbols.Symbol

class Sequence[S <: Symbol]( val name: String, private val symSeq : List[S] ) extends Annotable {
  
  val length = symSeq.length

  def apply(i: Int) = symSeq(i)

  def ==( that: Sequence[S] ) = that.symSeq == this.symSeq

  override def toString() = symSeq.map( _.toString ).mkString("")

  def substitute( i: Int, newSym: S ): Sequence[S] = {
    val newSymSeq = symSeq.take(i) ::: ( newSym :: symSeq.drop(i+1) )
    new Sequence( name, newSymSeq )
  }

  def insert( i: Int, newSym: S ): Sequence[S] = {
    val newSymSeq = symSeq.take(i) ::: ( newSym :: symSeq.drop(i) )
    new Sequence( name, newSymSeq )
  }

  def delete( i: Int ): Sequence[S] = {
    val newSymSeq = symSeq.take(i) ::: symSeq.drop(i+1)
    new Sequence( name, newSymSeq )
  }

  
}


