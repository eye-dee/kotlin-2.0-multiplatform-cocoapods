import cocoapods.GoogleSignIn.GIDSignIn
import kotlinx.cinterop.ExperimentalForeignApi
import platform.UIKit.UIApplication
import kotlin.coroutines.resume
import kotlin.coroutines.suspendCoroutine

internal class GoogleAuthUiProviderImpl {
    @OptIn(ExperimentalForeignApi::class)

    suspend fun signIn(): Any? = suspendCoroutine { continutation ->

        val rootViewController =
            UIApplication.sharedApplication.keyWindow?.rootViewController

        if (rootViewController == null) continutation.resume(null)
        else {
            GIDSignIn.sharedInstance
                .signInWithPresentingViewController(rootViewController) { gidSignInResult, nsError ->
                    nsError?.let { println("Error While signing: $nsError") }

                    val user = gidSignInResult?.user
                    val idToken = user?.idToken?.tokenString
                    val accessToken = user?.accessToken?.tokenString
                    val profile = gidSignInResult?.user?.profile
                    if (idToken != null && accessToken != null) {
                        println(idToken)
                    } else {
                        continutation.resume(null)
                    }
                }

        }
    }


}