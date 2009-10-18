package bio.seq

import bio.sym._
import bio.sym.dna._

class DNA( name: String, dnaSeq: SymbolList[Nucleotide] )
extends Sequence[Nucleotide](name, dnaSeq) {
  
  def complement() = {
    val newName = "Complement of " + name
    val newSymList = new SymbolList( dnaSeq.map( _.complement ).toList ) //TODO: ugly
    new DNA( newName, newSymList )
  }
  
}

object DNA {

  def createFromString( name: String, seq: String ) =  {
    val symList = NucleotideAlphabet.parse( seq )
    new DNA( name, symList )
  }



}
