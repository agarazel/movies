import com.webapp.crud.movies.Start
import com.webapp.crud.movies.model.Movie
import com.webapp.crud.movies.model.MovieGenre
import groovyx.net.http.HttpResponseDecorator
import groovyx.net.http.RESTClient
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ActiveProfiles
import org.springframework.test.context.ContextConfiguration
import spock.lang.Specification

@SpringBootTest(
    classes = Start.class,
    webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT
)
@ActiveProfiles(value = "test")
@ContextConfiguration
class MainControllerIntegrationSpec extends Specification {
  
  def client = new RESTClient("http://localhost:8080")
  
  def "It should return the expected movies list produced by MoviesService"() {
    
    given:
    def moviesExpected = [
        new Movie("Pulp Fiction", MovieGenre.DRAMA),
        new Movie("Pulp Fiction", MovieGenre.DRAMA)
    ]
    
    when:
    def response = client.get(path : "/movies") as HttpResponseDecorator
    
    then:
    assert response.status == 200
    response.data.eachWithIndex { it, int i ->
      println it
      assert it["name"] == moviesExpected[i].name
      assert it["genre"] == moviesExpected[i].genre as String
    }
  }
}
