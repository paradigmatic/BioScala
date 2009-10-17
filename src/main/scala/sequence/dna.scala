package bio

import bio.symbols.dna._

class DNA( name: String, dnaSeq: List[Nucleotide] )
extends Sequence[Nucleotide](name, dnaSeq) {
  
  def complement() = {
    val newName = "Complement of " + name
    val newSymList = dnaSeq.map( _.complement )
    new DNA( newName, newSymList )
  }
  
}

object DNA {

  def createFromString( name: String, seq: String ) =  {
    val symList = NucleotideAlphabet.parse( seq )
    new DNA( name, symList )
  }



}
