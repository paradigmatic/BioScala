import bio.Sequence
import bio.symbols._
import bio.symbols.dna._

import org.scalatest._

class SequenceTest extends FunSuite with BeforeAndAfter {

  val dna = List( G, A, T, A, T , C )
  val name = "Dna Fragment"
  val seq = new Sequence( name, dna )
  
  test( "Sequence  length" ) {
    assert( 6 === seq.length )
  }

  test( "symbol accessor" ) {
    assert( dna(2) === seq(2) )
  }

  test( "value equality" ) {
    val dna2 = List( G, A, T, A, T , C )
    val name2 = "Other fragment"
    val seq2 = new Sequence(  name2, dna2 )
    assert( seq == seq2 )
  }

  test( "point mutation" ) {
    var seq2 = seq.substitute( 2, G )
    assert( seq != seq2 )
    assert( seq.length === seq2.length )
    assert( seq(2) === T )
    assert( seq2(2) === G )
  }

  test( "insertion" ) {
    var seq2 = seq.insert( 1, C )
    assert( seq != seq2 )
    assert( seq.length === seq2.length - 1 )
    assert( seq2(1) === C )
    assert( seq2(2) === A )
  }

  test( "deletion" ) {
    var seq2 = seq.delete( 1 )
    println(seq2)
    assert( seq != seq2 )
    assert( seq.length === seq2.length + 1 )
    assert( seq2(1) === T )
    assert( seq2(2) === A )
  }

  test( "String representation" ) {
    assert( "gatatc" === seq.toString )
  }

  test( "Annotations" ) {
    val key = "CC"
    val name = "whatever"
    seq.setAnnotation( key, name )
    expect( name ) { seq.getAnnotation( key ) }
  }

}
