data class ErrorResponse(
    val error: ErrorDetails
)

data class ErrorDetails(
    val code: Int,
    val message: String?
)