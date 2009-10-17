import bio.Sequence
import bio.symbols._
import bio.symbols.dna._

import org.scalatest._

class SymbolListTest extends FunSuite with BeforeAndAfter {
  
  test( "Empty List" ) {
  
    val empty = SymbolList()
    assert( 0 === empty.length )
  }
  

}
