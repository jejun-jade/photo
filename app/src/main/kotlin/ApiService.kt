import com.jejun.album.`object`.User
import kotlinx.coroutines.Deferred
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {
    @GET("/user")
    fun getUser(): Deferred<Response<User>>
}