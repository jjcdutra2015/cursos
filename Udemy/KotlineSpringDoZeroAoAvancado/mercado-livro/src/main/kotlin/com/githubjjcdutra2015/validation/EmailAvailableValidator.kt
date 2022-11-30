package com.githubjjcdutra2015.validation

import com.githubjjcdutra2015.service.CustomerService
import javax.validation.ConstraintValidator
import javax.validation.ConstraintValidatorContext

class EmailAvailableValidator(private val customerService: CustomerService) :
    ConstraintValidator<EmailAvailable, String> {

    override fun isValid(value: String?, context: ConstraintValidatorContext?): Boolean {
        if (value.isNullOrEmpty()) {
            return false
        }

        return customerService.emailAvailable(value)
    }
}
