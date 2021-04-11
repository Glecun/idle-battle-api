import com.glecun.farmergameapi.domain.entities.User
import com.glecun.idlebattleapi.domain.SignUp
import com.glecun.idlebattleapi.domain.port.UserPort
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.Mockito.verify
import org.mockito.junit.jupiter.MockitoExtension

@ExtendWith(MockitoExtension::class)
internal class SignUpTest {
    @Mock
    private val userPort: UserPort? = null

    @InjectMocks
    var signUp: SignUp? = null

    @Test
    fun should_save_user() {
        val user = User("grewa", "grewa@gmail.com", "lol")
        Mockito.`when`(userPort?.findByEmail(user.email)).thenReturn(null)
        signUp?.execute(user)
        verify(userPort)?.save(user)
    }

    @Test
    fun should_not_save_user_when_already_exists() {
        val user = User("grewa", "grewa@gmail.com", "lol")
        Mockito.`when`(userPort?.findByEmail(user.email)).thenReturn(user)
        Assertions.assertThatThrownBy { signUp?.execute(user) }.isInstanceOf(RuntimeException::class.java)
    }

    @Test
    fun should_not_save_user_when_incorrect_email() {
        val user = User("grewa", "incorrect email", "lol")
        Assertions.assertThatThrownBy { signUp?.execute(user) }.isInstanceOf(RuntimeException::class.java)
    }

    @Test
    fun should_not_save_user_when_username_too_long() {
        val user = User("lkdjsflsmdjflmqksdjlfjkdjlfksjd", "incorrect email", "lol")
        Assertions.assertThatThrownBy { signUp?.execute(user) }.isInstanceOf(RuntimeException::class.java)
    }
}