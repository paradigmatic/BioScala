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

  def ==(that: SymbolList[S]) =
    if (this.length != that.length ) {
      println("Different size")
      false
    } else {
      println("Same size")
      (1 to length).forall( i => this(i) == that(i) )
    }

  override def hashCode() = lst.hashCode

}



object SymbolList {

  def apply() = new SymbolList( List[Symbol]() )

}
