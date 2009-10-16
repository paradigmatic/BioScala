import bio.Sequence
import bio.symbols._
import bio.symbols.dna._

import org.scalatest._

class SequenceTest extends FunSuite with BeforeAndAfter {

  val dna = List( G, A, T, A, T , C )
  val name = "Test sequence"
  val seq = new Sequence( name, dna )
  
  test( "Sequence  length" ) {
    assert( 6 === seq.length )
  }

  test( "symbol accessor" ) {
    assert( dna(2) === seq(2) )
  }

  test( "value equality" ) {
    val dna2 = List( G, A, T, A, T , C )
    val name2 = "Test sequence"
    val seq2 = new Sequence( name, dna2 )
    assert( seq == seq2 )
  }

  test( "point mutation" ) {
    var seq2 = seq.mutate( 2, G )
    assert( seq != seq2 )
    assert( seq.length === seq2.length )
    assert( seq(2) == T )
    assert( seq2(2) == G )
  }

  test( "String representation" ) {
    assert( "gatatc" === seq.toString )
  }

}
