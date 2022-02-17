package com.alsatpardakht.alsatipgcore.data.remote.util

object URLConstant {
    private const val BASE_URL = "https://www.alsatpardakht.com"
    private const val API_V1 = "API_V1"
    private const val IPGAPI_API22 = "IPGAPI/Api22"

    val SIGN_MOSTAGHIM_ROUTE = BASE_URL.appendPath(API_V1).appendPath("sign.php")
    val GO_ROUTE = BASE_URL.appendPath(API_V1).appendPath("Go.php")
    val VALIDATION_MOSTAGHIM_ROUTE = BASE_URL.appendPath(API_V1).appendPath("callback.php")

    val SIGN_VASET_ROUTE = BASE_URL.appendPath(IPGAPI_API22).appendPath("send.php")
    val VALIDATION_VASET_ROUTE =
        BASE_URL.appendPath(IPGAPI_API22).appendPath("VerifyTransaction.php")
}