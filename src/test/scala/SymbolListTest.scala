import bio.Sequence
import bio.symbols._
import bio.symbols.dna._

import org.scalatest._

class SymbolListTest extends FunSuite with BeforeAndAfter {
  
  val lst = List( A, T, G, C )
  val symLst = new SymbolList( lst )

  test( "Empty List" ) {
  
    val empty = SymbolList()
    assert( 0 === empty.length )
  }

  test( "Element accessor" ) {
    for( i <- 0 until lst.length ) {
      assert( lst(i) === symLst( i + 1) )
    }
  }

  test( "Sequence string" ) {
    assert( "atgc" === symLst.seqString )
  }
  
  test( "Sublist" ) {
    assert( "tg" === symLst.subList(2,3).seqString )
  }

  test( "Value equality" ) {
    val lst2 = List( A, T, G, C )
    val symLst2 = new SymbolList( lst )
    assert( symLst2 == symLst )
  }

}
