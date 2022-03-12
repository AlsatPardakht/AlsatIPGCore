package com.alsatpardakht.alsatipgcore.data.remote

import com.alsatpardakht.alsatipgcore.data.remote.dto.*
import com.alsatpardakht.alsatipgcore.data.remote.util.URLConstant.SIGN_MOSTAGHIM_ROUTE
import com.alsatpardakht.alsatipgcore.data.remote.util.URLConstant.SIGN_VASET_ROUTE
import com.alsatpardakht.alsatipgcore.data.remote.util.URLConstant.VALIDATION_MOSTAGHIM_ROUTE
import com.alsatpardakht.alsatipgcore.data.remote.util.URLConstant.VALIDATION_VASET_ROUTE
import io.ktor.client.*
import io.ktor.client.request.forms.*
import io.ktor.http.*

class IPGServiceImpl(
    private val client: HttpClient
) : IPGService {

    override suspend fun signMostaghim(paymentSignRequest: PaymentSignRequest) =
        client.submitForm<PaymentSignResponse>(
            url = SIGN_MOSTAGHIM_ROUTE,
            formParameters = Parameters.build {
                append("Api", paymentSignRequest.Api)
                append("Amount", paymentSignRequest.Amount)
                append("InvoiceNumber", paymentSignRequest.InvoiceNumber)
                append("RedirectAddress", paymentSignRequest.RedirectAddress)
            }
        )

    override suspend fun signVaset(paymentSignRequest: PaymentSignRequest) =
        client.submitForm<PaymentSignResponse>(
            url = SIGN_VASET_ROUTE,
            formParameters = Parameters.build {
                append("Api", paymentSignRequest.Api)
                append("Amount", paymentSignRequest.Amount)
                append("Tashim", paymentSignRequest.Tashim.toJson())
                append("RedirectAddress", paymentSignRequest.RedirectAddress)
            }
        )

    override suspend fun validationMostaghim(paymentValidationRequest: PaymentValidationRequest) =
        client.submitForm<PaymentValidationResponse>(
            url = VALIDATION_MOSTAGHIM_ROUTE,
            formParameters = Parameters.build {
                append("Api", paymentValidationRequest.Api)
                append("tref", paymentValidationRequest.tref)
                append("iD", paymentValidationRequest.iD)
                append("iN", paymentValidationRequest.iN)
            }
        )

    override suspend fun validationVaset(paymentValidationRequest: PaymentValidationRequest) =
        client.submitForm<PaymentValidationResponse>(
            url = VALIDATION_VASET_ROUTE,
            formParameters = Parameters.build {
                append("Api", paymentValidationRequest.Api)
                append("tref", paymentValidationRequest.tref)
                append("iD", paymentValidationRequest.iD)
                append("iN", paymentValidationRequest.iN)
            }
        )
}
