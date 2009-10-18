package bio.sym

/**
 * Defines a location on a SymbolList or a Sequence.
 * The location bounds are inclusive and expressed in biological coordinates
 */

class Location( val start: Int, val end: Int ) {
  require( start > 0 )
  require( end  > 0 ) //TODO: check if requires are needed.
}

class PointLocation( val position: Int ) extends Location( position, position )
