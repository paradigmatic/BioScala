package bio.symbols

abstract class Symbol

abstract class Alphabet[S <: Symbol] {
  
  def all: Set[S]
  
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
    val all = Set( A, C, G, T )
  }


}
