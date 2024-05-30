import kotlinx.coroutines.runBlocking
import platform.UIKit.UIDevice

class IOSPlatform : Platform {
    override val name: String =
        UIDevice.currentDevice.systemName() +
                " " +
                UIDevice.currentDevice.systemVersion +
                GoogleAuthProviderImpl()
                    .getUiProvider()
                    .hashCode()
}

actual fun getPlatform(): Platform =
    IOSPlatform()
        .also {
            runBlocking {
                GoogleAuthProviderImpl()
                    .getUiProvider()
                    .signIn()
            }
        }