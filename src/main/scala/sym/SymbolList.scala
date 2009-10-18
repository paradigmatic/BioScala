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

class SymbolList[S <: Symbol] (private val lst: List[S]) extends Iterable[S] {

  val length = lst.length
  override val hasDefiniteSize = true
  
  // Biological index notation
  def apply( i: Int ): S = lst(i-1)
  /**
   * Retrives a sing Symbol using a PointLocation object
   */
  def apply( point: PointLocation ): S = apply( point.position ) 

  override def elements() = lst.elements
  override def toList() = lst

  def subList( start: Int, end: Int ): SymbolList[S] = new SymbolList( lst.slice( start-1, end ) )
  /**
   * Returns a sub symbol list by passing a location object
   */
  def subList( location: Location ): SymbolList[S] = subList( location.start, location.end )

  def seqString() = lst.mkString("")

  override def toString() = seqString

  def ==(that: SymbolList[S]) =
    if (this.length != that.length ) {
      println("Different size")
      false
    } else {
      println("Same size")
      (1 to length).forall( i => this(i) == that(i) )
    }

  override def hashCode() = lst.hashCode

}



object SymbolList {

  def apply() = new SymbolList( List[Symbol]() )

}
