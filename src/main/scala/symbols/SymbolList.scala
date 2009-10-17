package bio.symbols

class SymbolList[S <: Symbol] (private val lst: List[S]) extends Iterable[S] {

  val length = lst.length
  override val hasDefiniteSize = true
  
  // Biological index notation
  def apply( i: Int ) = lst(i-1)

  override def elements() = lst.elements
  override def toList() = lst

  def subList( start: Int, end: Int ) = new SymbolList( lst.slice( start-1, end ) )

  def seqString() = lst.mkString("")

  override def toString() = seqString

  def ==(that: SymbolList[S]) = this.lst == that.lst

}



object SymbolList {

  def apply() = new SymbolList( List[Symbol]() )

}
