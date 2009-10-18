import bio.seq.Sequence
import bio.sym._
import bio.sym.dna._

import org.scalatest._

class LocationTest extends FunSuite with BeforeAndAfter {

  val min = 4
  val max = 10
  val location = Location( min, max )
  val point = PointLocation( (min+max)/2 )

  test( "Inclusion" ) {
    assert( location.includes( point ) )
    val loc2 = Location( min+1, max-1 )
    assert( location.includes( loc2 ) )
    assert( location.includes( location ) )
  }

  test( "Overlaps" ) {
    assert( location.overlaps( location ) )
    assert( location.overlaps( point ) )
    assert( point.overlaps( location ) )
    val loc2 = Location( min+2, max+4) 
    assert( loc2.overlaps( location ) )
    assert( location.overlaps( loc2 ) )
    val loc3 = Location( max+1, max+3)
    assert( ! location.overlaps( loc3 ) )
  }

  test( "Contiguous" ) {
    val loc2 = Location( max+1, max +3 )
    assert( loc2.isContiguous(location) )
    val loc3 = Location( min - 3, min - 1 )
    assert( loc3.isContiguous(location) )
    val loc4 = Location( min, max+1 )
    assert( ! loc4.isContiguous(location) )
    val point2 = PointLocation( max + 1 )
    assert( point2.isContiguous(location) )
  }
  
  test( "Intersection" ) {
    val location2 = Location( max-2, max+3 )
    val intersection = location.intersection( location2 )
    assert( intersection.start == max-2 )
    assert( intersection.end == max )
    assert( intersection == location2.intersection( location ) )
    //TODO: test for exception
  }

  test( "Union" ) {
    val location2 = Location( max-2, max+3 )
    val union = location.union( location2 )
    assert( union.start == min )
    assert( union.end == max+3 )
    //TODO: test for exception
    assert( union == location2.union( location ) )
  }

}
