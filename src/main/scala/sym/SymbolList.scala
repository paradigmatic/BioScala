package bio.sym

class SymbolList[S <: Symbol] (private val lst: List[S]) extends Iterable[S] {

  val length = lst.length
  override val hasDefiniteSize = true
  
  // Biological index notation
  def apply( i: Int ): S = lst(i-1)
  /**
   * Retrives a sing Symbol using a PointLocation object
   */
  def apply( point: PointLocation ): S = apply( point.position ) 

  override def elements() = lst.elements
  override def toList() = lst

  def subList( start: Int, end: Int ): SymbolList[S] = new SymbolList( lst.slice( start-1, end ) )
  /**
   * Returns a sub symbol list by passing a location object
   */
  def subList( location: Location ): SymbolList[S] = subList( location.start, location.end )

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
