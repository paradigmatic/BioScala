import bio.Sequence
import bio.symbols._
import bio.symbols.dna._

class SequenceTest extends org.scalatest.FunSuite {
  test( "Sequence  length" ) {
    val dna = Array( G, A, T, A, T , C )
    val name = "Test sequence"
    val seq = new Sequence( name, dna )
    assert( 6 === seq.length )
  }

  test( "symbol accessor" ) {
    val dna = Array( G, A, T, A, T , C )
    val name = "Test sequence"
    val seq = new Sequence( name, dna )
    assert( dna(2) === seq(2) )
  }
}
