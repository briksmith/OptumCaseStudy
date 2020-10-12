package com.example.demo

import static org.junit.jupiter.api.Assertions.*

import java.util.Optional;

import model.UserRepository
import model.Consts
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.BeforeEach
import org.mockito.Mock
import org.springframework.data.domain.Example
import org.springframework.ui.ExtendedModelMap
import org.springframework.ui.Model
import spock.lang.Specification
import spock.lang.Shared
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class UserControllerSpec extends Specification{
	
	def mockUserRepository = Mock(UserRepository)
	UserController systemUnderTest = new UserController(mockUserRepository)
	
	@BeforeEach
	def void setup() {
		mockUserRepository = Mock(UserRepository)
		systemUnderTest = new UserController(mockUserRepository)
	}
	
	@Test
	def "test index Page"(){
		Model model = new ExtendedModelMap()
		final List<User> listOfUsers = [new User("Bobby", "Hull"), new User("Stan", "Mikita")]
		
		
		when:
		List<User> actual = systemUnderTest.getAll()
		
		then:
		1 * mockUserRepository.findAll() >> listOfUsers
		0 * _._
		
		and:
		assertEquals(listOfUsers, actual)
	}
	
	@Test
	def "test Get All Happy Path"() {
		given:
		Model model = new ExtendedModelMap()
		final List<User> listOfUsers = [new User("Bobby", "Hull"), new User("Stan", "Mikita")]
		
		
		when:
		List<User> actual = systemUnderTest.getAll()
		
		then:
		1 * mockUserRepository.findAll() >> listOfUsers
		0 * _._
		
		and:
		assertEquals(listOfUsers, actual)
		
	}
	
	@Test
	def "test Get User By ID HappyPath"(){
		given:
		final long id = 1l
		final User user = new User("Dennis",  "Savard")
		Optional optional = new Optional(user)
		
		when:
		User actual = systemUnderTest.getUserByID(id)
		
		then:
		1 * mockUserRepository.findById(id) >> optional
		0 * _._
		
		and:
		assertEquals(user, actual)
		
	}
	
	@Test
	def "test delete by user Id"(){
		given:
		User user = new User("Bobby", "Hull")
		
		when:
		systemUnderTest.deleteUserByID(user.id)
		
		then:
		1 * mockUserRepository.deleteById(user.id)
		0 * _._
		
		
		
	}
	
	@Test
	def "test Get User By ID user not found"(){
		given:
		Optional emptyOptional = new Optional(null)
		final long id = 1l
		
		when:
		User actual = systemUnderTest.getUserByID(id)
		
		then:
		1 * mockUserRepository.findById(id) >> emptyOptional
		0 * _._
		
		and:
		assertEquals(actual, Consts.MISSING_USER)
		
	}
	
	@Test
	def "test Find By Name"() {
		given:
		final String firstName = "Bobby"
		final String lastName = "Hull"
		final User user = new User(firstName, lastName)
		final List<User> listOfUsers = [user]
		
		when:
		List<User> actualUsers = systemUnderTest.getUserByName(firstName, lastName)
		
		then:
		1 * mockUserRepository.findByUserName(firstName, lastName) >> listOfUsers
		0 * _._
		
		and:
		assertEquals(listOfUsers, actualUsers)
		
	}
	
	@Test
	def "test add user Name Only User"() {
		given:
		final String firstName = "Bobby"
		final String lastName = "Hull"
		final User user = new User(firstName,lastName)
		Map<String, String> inputs = new HashMap<>();
		inputs.put(Consts.FIRST_NAME, firstName)
		inputs.put(Consts.LAST_NAME, lastName)
		
		
		when:
		systemUnderTest.addUserNameOnly(inputs)
		
		then:
		1 * mockUserRepository.save(user)
		0 * _._
	}
	
	@Test
	def "test add full User"() {
		given:
		final String firstName = "Bobby"
		final String middleI = "C"
		final String lastName = "Hull"
		final String city = "Chicago"
		final String state = "IL"
		final String zip = "60201"
		final String phone = "(312) 555-1234"
		final User user = new User(firstName, middleI.charAt(0), lastName, city, state, zip, phone)
		Map<String, String> inputs = new HashMap<>();
		inputs.put(Consts.FIRST_NAME, firstName)
		inputs.put(Consts.MIDDLE_INITIAL, middleI)
		inputs.put(Consts.LAST_NAME, lastName)
		inputs.put(Consts.CITY, city)
		inputs.put(Consts.STATE, state)
		inputs.put(Consts.ZIP, zip)
		inputs.put(Consts.PHONE, phone)
		
		
		when:
		systemUnderTest.addFullUser(inputs)
		
		then:
		1 * mockUserRepository.save(user)
		0 * _._
	}

}
