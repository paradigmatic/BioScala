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


package bio.seq

import bio.sym._
import bio.sym.dna._

class DNA( name: String, dnaSeq: SymbolList[Nucleotide], annotation: Annotation )
extends Sequence[Nucleotide](name, dnaSeq, annotation) {
  
  def this( name: String, dnaSeq: SymbolList[Nucleotide] ) = this( name, dnaSeq, Annotation() )

  def complement() = {
    val newName = "Complement of " + name
    val newSymList = new SymbolList( dnaSeq.map( _.complement ).toList ) //TODO: ugly
    new DNA( newName, newSymList )
  }
  
}

object DNA {

  def createFromString( name: String, seq: String ) =  {
    val symList = NucleotideAlphabet.parse( seq )
    new DNA( name, symList )
  }



}
