package bio.symbols

class SymbolList[S <: Symbol] (private val lst: List[S]) extends Iterable[S] {

  val length = lst.length
  override val hasDefiniteSize = true
  
  // Biological index notation
  def apply( i: Int ) = lst(i-1)

  override def elements() = lst.elements
  override def toList() = lst

  def seqString() = lst.mkString("")

  override def toString() = seqString


}



object SymbolList {

  def apply() = new SymbolList( List[Symbol]() )

}
