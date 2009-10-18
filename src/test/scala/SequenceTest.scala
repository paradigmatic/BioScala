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

class SequenceTest extends FunSuite with BeforeAndAfter {

  test("Annotation") {
    val symList = new SymbolList( List( A, T, C, G ) )
    val seq = new Sequence( "machin", symList )
    val key = "XX"
    val value = "yyyyy"
    val annot = seq.annotation( key ) = value
    val seq2 = seq.updateAnnotation( annot )
    assert( value == seq2.annotation(key) )
  }

}
