/*  
 *  This file is part of BioScala
 *
 *  BioScala is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU General Public License as published by
 *  the Free Software Foundation, either version 3 of the License, or
 *  (at your option) any later version.
 *
 *  BioScala is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 *
 *  You should have received a copy of the GNU General Public License
 *  along with BioScala.  If not, see <http://www.gnu.org/licenses/>.
 *
 *  (c) 2009, Jean-Luc Falcone, jean-luc.falcone@unige.ch
 *
 */


package bio.sym

import Math._


/**
 * Defines a location on a SymbolList or a Sequence.
 * The location bounds are inclusive and expressed in biological coordinates
 */

case class Location( val start: Int, val end: Int ) {
  require( start > 0 )
  require( end  > 0 ) //TODO: check if requires are needed.

  /**
   * Returns the location length
   */
  def length = end - start + 1

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
  
  /**
   * Returns a new Location which is the intersection between
   * this and the location argument. If the intersection is empty,
   * throw an exception.
   */
  def intersection( that: Location ) = {
    require( this.overlaps( that ) ) 
    Location( max( this.start, that.start ), min( this.end, that.end ) )
  }

  /**
   * Return the union of this and the location argument. Throw an exception
   * if there is neither overlap nor  continguity.
   */
  def union( that: Location ) = {
    require( that.overlaps( this ) || that.isContiguous( this ) )
    Location( min( this.start, that.start ), max( this.end, that.end ) )
  }

  override lazy val toString = "Location(" +start+"-"+end+")"

}

case class PointLocation( val position: Int ) 
  extends Location( position, position ) {
    
    override val length = 1

    override lazy val toString = "PointLocation(" + position + ")"
  }
