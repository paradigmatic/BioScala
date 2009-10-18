import bio.seq.Sequence
import bio.sym._
import bio.sym.dna._

import org.scalatest._

class LocationTest extends FunSuite with BeforeAndAfter {

  val min = 4
  val max = 10
  val location = new Location( min, max )
  val point = new PointLocation( (min+max)/2 )

  test( "Inclusion" ) {
    assert( location.includes( point ) )
    val loc2 = new Location( min+1, max-1 )
    assert( location.includes( loc2 ) )
    assert( location.includes( location ) )
  }

  test( "Overlaps" ) {
    assert( location.overlaps( location ) )
    assert( location.overlaps( point ) )
    assert( point.overlaps( location ) )
    val loc2 = new Location( min+2, max+4) 
    assert( loc2.overlaps( location ) )
    assert( location.overlaps( loc2 ) )
    val loc3 = new Location( max+1, max+3)
    assert( ! location.overlaps( loc3 ) )
  }

  test( "Contiguous" ) {
    val loc2 = new Location( max+1, max +3 )
    assert( loc2.isContiguous(location) )
    val loc3 = new Location( min - 3, min - 1 )
    assert( loc3.isContiguous(location) )
    val loc4 = new Location( min, max+1 )
    assert( ! loc4.isContiguous(location) )
    val point2 = new PointLocation( max + 1 )
    assert( point2.isContiguous(location) )
  }

}
