import bio.seq.Sequence
import bio.seq.DNA
import bio.symbols._
import bio.symbols.dna._

import org.scalatest._

class DNATest extends FunSuite with BeforeAndAfter {

  val dna = new SymbolList( List( G, A, T, A, T , C ) ) //TODO: ugly
  val name = "Dna fragment"
  val seq = new DNA( name, dna )
  
  test( "String representation" ) {
    assert( "gatatc" === seq.toString )
  }

  test( "String to Symbol list" ) {
    val string = "gatatc"
    val lst = NucleotideAlphabet.parse(string)
    println( lst.getClass() )
    println( dna.getClass() )
    assert( lst == dna )
    //TODO: add exception test
  }

  test( "complement" ) {
    assert( seq.complement.toString === "ctatag" )
  }

}
