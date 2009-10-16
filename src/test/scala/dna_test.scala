import bio.Sequence
import bio.DNA
import bio.symbols._
import bio.symbols.dna._

import org.scalatest._

class DNATest extends FunSuite with BeforeAndAfter {

  val dna = List( G, A, T, A, T , C )
  val name = "Test sequence"
  val seq = new DNA( name, dna )
  
  test( "String representation" ) {
    assert( "gatatc" === seq.toString )
  }

}
