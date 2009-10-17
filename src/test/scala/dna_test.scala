import bio.Sequence
import bio.DNA
import bio.symbols._
import bio.symbols.dna._

import org.scalatest._

class DNATest extends FunSuite with BeforeAndAfter {

  val dna = List( G, A, T, A, T , C )
  val name = "Dna fragment"
  val seq = new DNA( name, dna )
  
  test( "String representation" ) {
    assert( "gatatc" === seq.toString )
  }

  test( "String to Symbol list" ) {
    val string = "atcgat"
    val lst = NucleotideAlphabet.parse(string)
    assert( lst === List( A, T, C, G, A, T ) )
    //TODO: add exception test
  }

  test( "string to Dna Sequence ") {
    val string = seq.toString
    val seq2 = DNA.createFromString( "Dna frag 2", string )
    assert( seq == seq2 )
  }

  test( "complement" ) {
    assert( seq.complement.toString === "ctatag" )
  }

}
