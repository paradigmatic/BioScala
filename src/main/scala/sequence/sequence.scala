package bio

class Sequence[S]( val name: String, private val symSeq : Array[S] ) {
  
  val length = symSeq.length

  def apply(i: Int) = symSeq(i)
  
}
