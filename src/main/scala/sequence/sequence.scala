package bio

import bio.symbols.Symbol

class Sequence[S <: Symbol]( val name: String, private val symSeq : List[S] ) {
  
  val length = symSeq.length

  def apply(i: Int) = symSeq(i)

  def ==( that: Sequence[S] ) = that.symSeq == this.symSeq
  
}
