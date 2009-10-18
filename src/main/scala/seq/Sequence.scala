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

class Sequence[S <: Symbol]( val name: String, val symbolList : SymbolList[S], override val annotation: Annotation ) extends Annotatable {


  def this( name: String, dnaSeq: SymbolList[S] ) = this( name, dnaSeq, Annotation() )

  def updateAnnotation( newAnnotation: Annotation ) = new Sequence[S]( name, symbolList, newAnnotation )

  override def toString = symbolList.toString
  


}


