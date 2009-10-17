package bio

trait Annotable{
  
  private var annotations = Map[String,String]()

  def getAnnotation( key: String ): String  = annotations( key )
  def setAnnotation( key: String, value: String ): Unit = {  
    annotations = ( annotations( key ) = value )
  }

}
