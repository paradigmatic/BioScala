package bio.symbols

abstract class Symbol

abstract class Alphabet[S <: Symbol] {
  
  def all: Set[S]
  def parse( input: String ): List[S]
}

package dna {

  abstract class Nucleotide extends Symbol
  
  object A extends Nucleotide {
    override def toString() = "a"
  }
  object C extends Nucleotide {
      override def toString() = "c"
  }
  object G extends Nucleotide {
    override def toString() = "g"
  }
  object T extends Nucleotide {
    override def toString() = "t"
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
      lst.reverse
    }
    
  }

  


}
