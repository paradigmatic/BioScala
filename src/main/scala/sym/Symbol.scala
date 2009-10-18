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

abstract class Symbol

abstract class Alphabet[S <: Symbol] {
  
  def all: Set[S]
  def parse( input: String ): SymbolList[S]
}

package dna {

  abstract class Nucleotide extends Symbol {
    def complement(): Nucleotide
  }
  
  object A extends Nucleotide {
    override def toString() = "a"
    override def complement() = T
  }
  object C extends Nucleotide {
    override def toString() = "c"
    override def complement() = G
  }
  object G extends Nucleotide {
    override def toString() = "g"
    override def complement() = C
  }
  object T extends Nucleotide {
    override def toString() = "t"
    override def complement() = A
  }

  
  object NucleotideAlphabet extends Alphabet[Nucleotide] {
    
    override val all = Set( A, C, G, T )
    
    override def parse( input: String ) = {
      var lst : List[Nucleotide] = List()
      input.toLowerCase.foreach { char =>
	val nuc = char match {
	  case 'a' => A
	  case 'g' => G
	  case 'c' => C
	  case 't' => T
	  case _ => throw new IllegalArgumentException("Not a DNA nucleotide: " + char ) //TODO: use a custom exception
	}
	lst ::= nuc
      }
      new SymbolList( lst.reverse )
    }
    
  }

  


}
