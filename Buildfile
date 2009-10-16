require 'buildr/scala'

repositories.remote << 'http://www.ibiblio.org/maven2/'

define 'bioScala' do
 
  project.version = '0.0.1'
  manifest['Copyright'] = 'Jean-Luc Falcone (c) 2009'

  compile.using(:warnings => true )

  package :jar
  

end
