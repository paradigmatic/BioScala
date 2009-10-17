package bio

trait Annotatable{
  
  val annotation = Annotation()

}

class Annotation( var map: Map[String,String] ) {

  def apply( key: String ) = map( key ) 
  def hasKey( key: String ) = map.contains(key)
  def update( key: String, value: String ) = map = map(key)=value

}

object Annotation {

  def apply() =  new Annotation( Map[String,String]() ) 

}
