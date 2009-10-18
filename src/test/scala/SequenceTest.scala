import bio.seq.Sequence
import bio.symbols._
import bio.symbols.dna._

import org.scalatest._

class SequenceTest extends FunSuite with BeforeAndAfter {

  test("Annotation") {
    val symList = new SymbolList( List( A, T, C, G ) )
    val seq = new Sequence( "machin", symList )
    val key = "XX"
    val value = "yyyyy"
    seq.annotation( key ) = value
    assert( value == seq.annotation(key) )
  }

}
