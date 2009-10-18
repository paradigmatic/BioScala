package bio.seq

import bio.sym._

class Sequence[S <: Symbol]( val name: String, val symbolList : SymbolList[S] ) extends Annotatable {

  override def toString = symbolList.toString
}


