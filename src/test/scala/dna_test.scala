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
import bio.seq.DNA
import bio.sym._
import bio.sym.dna._

import org.scalatest._

class DNATest extends FunSuite with BeforeAndAfter {

  val dna = new SymbolList( List( G, A, T, A, T , C ) ) //TODO: ugly
  val name = "Dna fragment"
  val seq = new DNA( name, dna )
  
  test( "String representation" ) {
    assert( "gatatc" === seq.toString )
  }

  test( "String to Symbol list" ) {
    val string = "gatatc"
    val lst = NucleotideAlphabet.parse(string)
    println( lst.getClass() )
    println( dna.getClass() )
    assert( lst == dna )
    //TODO: add exception test
  }

  test( "complement" ) {
    assert( seq.complement.toString === "ctatag" )
  }

}
