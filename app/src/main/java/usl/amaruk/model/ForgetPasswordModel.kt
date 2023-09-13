package usl.amaruk.model

import androidx.annotation.Keep
import com.google.gson.annotations.SerializedName

// response {"access":"CallingNewPasswOK","tier":"","firstName":"","lastName":"","emailAddress":""}

@Keep
class ForgetPasswordModel( @field:SerializedName("firstName")
                           val firstName: String? = null,

                           @field:SerializedName("lastName")
                           val lastName: String? = null,

                           @field:SerializedName("emailAddress")
                           val emailAddress: String? = null,

                           @field:SerializedName("access")
                           val access: String? = null,

                           @field:SerializedName("tier")
                           val tier: String? = null)