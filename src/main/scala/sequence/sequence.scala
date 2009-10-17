package bio

import bio.symbols.Symbol

class Sequence[S <: Symbol]( private val symSeq : List[S] ) extends Annotable {
  
  val length = symSeq.length

  def apply(i: Int) = symSeq(i)

  def ==( that: Sequence[S] ) = that.symSeq == this.symSeq

  override def toString() = symSeq.map( _.toString ).mkString("")

  def mutate( i: Int, newSym: S ): Sequence[S] = {
    val newSymSeq = symSeq.take(2) ::: ( newSym :: symSeq.drop(3) )
    new Sequence( newSymSeq )
  }

  
}


