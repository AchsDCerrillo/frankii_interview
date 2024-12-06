sealed class BuildType(
    val serverUrl: String,
    val isMinifyEnabled: Boolean,
    val isDebuggable: Boolean,
    val applicationIdSuffix: String? = null,
    val apiKey: String,
) {
    object Debug : BuildType(
        serverUrl = "https://api.openweathermap.org/",
        isMinifyEnabled = false,
        isDebuggable = true,
        applicationIdSuffix = ".debug",
        apiKey = "5deca2f99f97d972562a33188d696b4a" // NEVER SHARE YOUR API KEY WITH ANYONE, this is just for interview purposes I usually use github secrets
    )

    object Release : BuildType(
        serverUrl = "https://api.openweathermap.org/", // NEVER SHARE YOUR API KEY WITH ANYONE, this is just for interview purposes I usually use github secrets
        isMinifyEnabled = true,
        isDebuggable = false,
        apiKey = "5deca2f99f97d972562a33188d696b4a"
    )
}