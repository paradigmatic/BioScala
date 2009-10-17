package bio.symbols

class SymbolList[S <: Symbol] (private val lst: List[S]) {

  val length = lst.length

}



object SymbolList {

  def apply() = new SymbolList( List[Symbol]() )

}
