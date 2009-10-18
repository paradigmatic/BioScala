package bio.sym

/**
 * Defines a location on a SymbolList or a Sequence.
 * The location bounds are inclusive and expressed in biological coordinates
 */

class Location( val start: Int, val end: Int ) {
  require( start > 0 )
  require( end  > 0 ) //TODO: check if requires are needed.

  /**
   * Returns true if the location argument is totally included in this location
   */
  def includes( that: Location ) = 
    that.start >= this.start && that.end <= this.end

  /**
   * Returns true if the argument overlaps with this location
   * (partially or totaly)
   */
  def overlaps( that: Location ) =
    ( this.end >= that.start && this.end <= that.end ) ||
    ( that.end >= this.start && that.end <= this.end )
  

  /**
   * Return true if the argument location si contiguous but does not
   * overlap this location
   */
  def isContiguous( that: Location ) =
    this.end == that.start  - 1  ||  this.start == that.end + 1
  

  override def toString() = "Location(" +start+"-"+end+")"

}

class PointLocation( val position: Int ) extends Location( position, position )
