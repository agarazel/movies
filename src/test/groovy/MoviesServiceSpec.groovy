import com.webapp.crud.movies.model.Movie
import com.webapp.crud.movies.model.MovieGenre
import com.webapp.crud.movies.service.IMoviesService
import com.webapp.crud.movies.service.MoviesService
import org.springframework.beans.factory.annotation.Autowired
import spock.lang.Specification

class MoviesServiceSpec extends Specification {
  
  @Autowired
  IMoviesService service
  
  def setup() {
    service = new MoviesService()
  }
  
  def "It should get all movies list"() {
    
    given:
    def moviesExpected = [
        new Movie("Pulp Fiction", MovieGenre.DRAMA),
        new Movie("Pulp Fiction", MovieGenre.DRAMA)
    ]
    
    when:
    def moviesList = service.allMovies
    
    then:
    moviesList.eachWithIndex { it, int i ->
      assert it.name == moviesExpected[i].name
      assert it.genre == moviesExpected[i].genre
    }
    
  }
}
