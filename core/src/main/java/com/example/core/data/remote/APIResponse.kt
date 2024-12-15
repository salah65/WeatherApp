package com.example.core.data.remote

import ErrorDetails
import ErrorResponse
import com.google.gson.Gson
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import okhttp3.ResponseBody
import retrofit2.HttpException
import retrofit2.Response
import java.io.IOException

sealed class Resource<T>(
    val data: T? = null,
    val message: String? = null
) {
    class Success<T>(data: T) : Resource<T>(data = data)

    class Error<T>(errorMessage: String) : Resource<T>(message = errorMessage)

}


suspend fun <T> safeApiCall(apiToBeCalled: suspend () -> Response<T>): Resource<T> {
    return withContext(Dispatchers.IO) {
        try {
            val response: Response<T> = apiToBeCalled()
            if (response.isSuccessful) {
                Resource.Success(data = response.body()!!)
            } else {
                val errorResponse: ErrorResponse? =
                    convertErrorBody(response.errorBody())
                Resource.Error(
                    errorMessage = errorResponse?.error?.message ?: "Something went wrong"
                )
            }

        } catch (e: HttpException) {
            Resource.Error(errorMessage = e.message ?: "Something went wrong")
        } catch (e: IOException) {

            Resource.Error("Please check your network connection")
        } catch (e: Exception) {
            Resource.Error(errorMessage = "Something went wrong")
        }
    }
}

private fun convertErrorBody(errorBody: ResponseBody?): ErrorResponse? {
    return try {
        errorBody?.let {
            Gson().fromJson(it.source().buffer.readUtf8(), ErrorResponse::class.java)
        }
    } catch (exception: Exception) {
        ErrorResponse(ErrorDetails(code = -1, message = null))
    }
}