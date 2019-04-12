import com.webapp.crud.movies.controller.MainController
import com.webapp.crud.movies.model.Movie
import com.webapp.crud.movies.model.MovieGenre
import com.webapp.crud.movies.service.IMoviesService
import groovy.json.JsonSlurper
import org.springframework.test.web.servlet.MockMvc
import spock.lang.Specification

import static org.springframework.http.HttpStatus.OK
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup

class MainControllerSpec extends Specification {
  
  def moviesExpected = [
      new Movie("Pulp Fiction", MovieGenre.DRAMA),
      new Movie("Spiderman", MovieGenre.ACTION)
  ]
  
  def service = Stub(IMoviesService)
  def controller = new MainController(service)
  
  MockMvc mockMvc = standaloneSetup(controller).build()
  
  def "It should return an expected movies list"() {
    
    when:
    service.allMovies >> moviesExpected
    def response = mockMvc.perform(get("http://localhost:8080/movies")).andReturn().response
    def content = new JsonSlurper().parseText(response.contentAsString)
    
    then:
    println(response.contentAsString)
    response.status == OK.value()
    content.each {
      assert it.name in ["Pulp Fiction", "Spiderman"]
      assert it.genre in ["DRAMA", "ACTION"]
    }
  }
}
