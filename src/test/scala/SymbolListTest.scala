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


import bio.seq.Sequence
import bio.sym._
import bio.sym.dna._

import org.scalatest._

class SymbolListTest extends FunSuite with BeforeAndAfter {
  
  val lst = List( A, T, G, C )
  val symLst = new SymbolList( lst )

  test( "Empty List" ) {
  
    val empty = SymbolList()
    assert( 0 === empty.length )
  }

  test( "Element accessors" ) {
    for( i <- 0 until lst.length ) {
      assert( lst(i) === symLst( i + 1) )
    }
    for( i <- 0 until lst.length ) {
      assert( lst(i) === symLst( new PointLocation( i+1)) )
    }
  }

  test( "Sequence string" ) {
    assert( "atgc" === symLst.seqString )
  }
  
  test( "Sublist" ) {
    assert( "tg" === symLst.subList(2,3).seqString )
    assert( "tg" === symLst.subList( new Location( 2,3 ) ).seqString )
  }

  test( "Value equality" ) {
    val lst2 = List( A, T, G, C )
    val symLst2 = new SymbolList( lst )
    assert( symLst2 == symLst )
  }

}
