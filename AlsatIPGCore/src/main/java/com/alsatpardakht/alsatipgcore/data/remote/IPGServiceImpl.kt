package com.alsatpardakht.alsatipgcore.data.remote

import com.alsatpardakht.alsatipgcore.data.remote.util.URLConstant.SIGN_MOSTAGHIM_ROUTE
import com.alsatpardakht.alsatipgcore.data.remote.util.URLConstant.SIGN_VASET_ROUTE
import com.alsatpardakht.alsatipgcore.data.remote.util.URLConstant.VALIDATION_MOSTAGHIM_ROUTE
import com.alsatpardakht.alsatipgcore.data.remote.util.URLConstant.VALIDATION_VASET_ROUTE
import com.alsatpardakht.alsatipgcore.data.remote.model.PaymentSignRequest
import com.alsatpardakht.alsatipgcore.data.remote.model.PaymentSignResponse
import com.alsatpardakht.alsatipgcore.data.remote.model.PaymentValidationRequest
import com.alsatpardakht.alsatipgcore.data.remote.model.toJson
import io.ktor.client.*
import io.ktor.client.request.forms.*
import io.ktor.http.*

class IPGServiceImpl(
    private val client: HttpClient
) : IPGService {

    override suspend fun signMostaghim(paymentSignRequest: PaymentSignRequest): PaymentSignResponse =
        client.submitForm(
            url = SIGN_MOSTAGHIM_ROUTE,
            formParameters = Parameters.build {
                set("Api", paymentSignRequest.Api)
                set("Amount", paymentSignRequest.Amount)
                set("InvoiceNumber", paymentSignRequest.InvoiceNumber)
                set("RedirectAddress", paymentSignRequest.RedirectAddress)
            },
            encodeInQuery = false
        ) {
            method = HttpMethod.Post
        }


    override suspend fun signVaset(paymentSignRequest: PaymentSignRequest): PaymentSignResponse =
        client.submitForm(
            url = SIGN_VASET_ROUTE,
            formParameters = Parameters.build {
                set("ApiKey", paymentSignRequest.Api)
                set("Amount", paymentSignRequest.Amount)
                set("Tashim", paymentSignRequest.Tashim.toJson())
                set("RedirectAddressPage", paymentSignRequest.RedirectAddress)
            },
            encodeInQuery = false
        ) {
            method = HttpMethod.Post
        }

    override suspend fun validationMostaghim(paymentValidationRequest: PaymentValidationRequest): String? =
        client.submitForm(
            url = VALIDATION_MOSTAGHIM_ROUTE,
            formParameters = Parameters.build {
                set("Api", paymentValidationRequest.Api)
                set("tref", paymentValidationRequest.tref ?: "")
                set("iD", paymentValidationRequest.iD ?: "")
                set("iN", paymentValidationRequest.iN ?: "")
            },
            encodeInQuery = false
        ) {
            method = HttpMethod.Post
        }

    override suspend fun validationVaset(paymentValidationRequest: PaymentValidationRequest): String? =
        client.submitForm(
            url = VALIDATION_VASET_ROUTE,
            formParameters = Parameters.build {
                set("tref", paymentValidationRequest.tref ?: "")
                set("iD", paymentValidationRequest.iD ?: "")
                set("iN", paymentValidationRequest.iN ?: "")
            },
            encodeInQuery = false
        ) {
            method = HttpMethod.Post
        }
}
