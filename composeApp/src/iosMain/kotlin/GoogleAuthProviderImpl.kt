import cocoapods.GoogleSignIn.GIDSignIn
import kotlinx.cinterop.ExperimentalForeignApi

internal class GoogleAuthProviderImpl {

    fun getUiProvider() = GoogleAuthUiProviderImpl()

    @OptIn(ExperimentalForeignApi::class)
    suspend fun signOut() {
        GIDSignIn.sharedInstance.signOut()
    }


}