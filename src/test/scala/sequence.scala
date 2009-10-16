import bio.Sequence
import bio.symbols._
import bio.symbols.dna._

class SequenceTest extends org.scalatest.FunSuite {
  test( "Sequence  length" ) {
    val dna = List( G, A, T, A, T , C )
    val name = "Test sequence"
    val seq = new Sequence( name, dna )
    assert( 6 === seq.length )
  }

  test( "symbol accessor" ) {
    val dna = List( G, A, T, A, T , C )
    val name = "Test sequence"
    val seq = new Sequence( name, dna )
    assert( dna(2) === seq(2) )
  }

  test( "value equality" ) {
    val dna = List( G, A, T, A, T , C )
    val name = "Test sequence"
    val seq = new Sequence( name, dna )
    val dna2 = List( G, A, T, A, T , C )
    val name2 = "Test sequence"
    val seq2 = new Sequence( name, dna2 )
    assert( seq == seq2 )
  }
}
