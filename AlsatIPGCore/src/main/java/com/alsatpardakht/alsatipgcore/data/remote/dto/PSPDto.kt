package com.alsatpardakht.alsatipgcore.data.remote.dto

import com.alsatpardakht.alsatipgcore.data.Mapper
import com.alsatpardakht.alsatipgcore.domain.model.PSP
import kotlinx.serialization.Serializable

@Serializable
data class PSPDto(
    val Amount: Int?,
    val InvoiceDate: String?,
    val InvoiceNumber: String?,
    val IsSuccess: Boolean?,
    val MerchantCode: Int?,
    val Message: String?,
    val ReferenceNumber: Long?,
    val TerminalCode: Int?,
    val TraceNumber: Int?,
    val TransactionDate: String?,
    val TransactionReferenceID: String?,
    val TrxHashedCardNumber: String?,
    val TrxMaskedCardNumber: String?
) : Mapper<PSP> {

    override fun toDomainModel(): PSP {
        return PSP(
            Amount = Amount!!,
            InvoiceDate = InvoiceDate!!,
            InvoiceNumber = InvoiceNumber!!,
            IsSuccess = IsSuccess!!,
            MerchantCode = MerchantCode!!,
            Message = Message!!,
            ReferenceNumber = ReferenceNumber!!,
            TerminalCode = TerminalCode!!,
            TraceNumber = TraceNumber!!,
            TransactionDate = TransactionDate!!,
            TransactionReferenceID = TransactionReferenceID!!,
            TrxHashedCardNumber = TrxHashedCardNumber!!,
            TrxMaskedCardNumber = TrxMaskedCardNumber!!
        )
    }
}