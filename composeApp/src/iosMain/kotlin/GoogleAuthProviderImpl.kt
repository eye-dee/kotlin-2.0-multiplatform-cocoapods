import androidx.compose.runtime.Composable
import cocoapods.GoogleSignIn.GIDSignIn
import kotlinx.cinterop.ExperimentalForeignApi

internal class GoogleAuthProviderImpl {

    @Composable
    fun getUiProvider() = GoogleAuthUiProviderImpl()

    @OptIn(ExperimentalForeignApi::class)
    suspend fun signOut() {
        GIDSignIn.sharedInstance.signOut()
    }


}