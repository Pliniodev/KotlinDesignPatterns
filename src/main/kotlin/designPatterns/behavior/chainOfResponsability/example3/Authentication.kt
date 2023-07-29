package designPatterns.behavior.chainOfResponsability.example3

// Interface representing an authentication handler in the chain
interface AuthenticationHandler {
    fun authenticate(credentials: String): Boolean
}

// Concrete class representing API Key authentication handler
class ApiKeyHandler(private val nextHandler: AuthenticationHandler) : AuthenticationHandler {
    override fun authenticate(credentials: String): Boolean {
        return if (credentials.startsWith("APIKEY_")) {
            println("API Key authentication successful.")
            true
        } else {
            nextHandler.authenticate(credentials)
        }
    }
}

// Concrete class representing Username/Password authentication handler
class UsernamePasswordHandler(private val nextHandler: AuthenticationHandler) : AuthenticationHandler {
    override fun authenticate(credentials: String): Boolean {
        return if (credentials.contains(':')) {
            println("Username/Password authentication successful.")
            true
        } else {
            nextHandler.authenticate(credentials)
        }
    }
}

// Concrete class representing Social Media Token authentication handler
class SocialMediaTokenHandler(private val nextHandler: AuthenticationHandler) : AuthenticationHandler {
    override fun authenticate(credentials: String): Boolean {
        return if (credentials.startsWith("SOCIAL_")) {
            println("Social Media Token authentication successful.")
            true
        } else {
            nextHandler.authenticate(credentials)
        }
    }
}

// Concrete class representing the "end" of the chain
class DefaultAuthenticationHandler : AuthenticationHandler {
    override fun authenticate(credentials: String): Boolean {
        println("Authentication failed. Invalid credentials.")
        return false
    }
}

fun main() {
    val defaultHandler = DefaultAuthenticationHandler()
    val socialMediaTokenHandler = SocialMediaTokenHandler(defaultHandler)
    val usernamePasswordHandler = UsernamePasswordHandler(socialMediaTokenHandler)
    val apiKeyHandler = ApiKeyHandler(usernamePasswordHandler)

    val credentials1 = "APIKEY_12345"
    val credentials2 = "user123:pass456"
    val credentials3 = "SOCIAL_78910"
    val credentials4 = "invalid_credentials"

    println("Authentication for credentials1: ${apiKeyHandler.authenticate(credentials1)}")
    println("Authentication for credentials2: ${apiKeyHandler.authenticate(credentials2)}")
    println("Authentication for credentials3: ${apiKeyHandler.authenticate(credentials3)}")
    println("Authentication for credentials4: ${apiKeyHandler.authenticate(credentials4)}")
}
