package bio

import bio.symbols.Symbol

class Sequence[S <: Symbol]( val name: String, private val symSeq : List[S] ) {
  
  val length = symSeq.length

  def apply(i: Int) = symSeq(i)

  def ==( that: Sequence[S] ) = that.symSeq == this.symSeq

  override def toString() = symSeq.map( _.toString ).mkString("")

  def mutate( i: Int, newSym: S ): Sequence[S] = {
    val newSymSeq = symSeq.take(2) ::: ( newSym :: symSeq.drop(3) )
    new Sequence( name, newSymSeq )
  }

  
}

import bio.symbols.dna.Nucleotide

class DNA( name: String, dnaSeq: List[Nucleotide] )
extends Sequence[Nucleotide](name,dnaSeq)
