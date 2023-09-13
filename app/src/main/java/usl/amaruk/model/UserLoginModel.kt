package usl.amaruk.model

import androidx.annotation.Keep
import com.google.gson.annotations.SerializedName

@Keep
data class UserLoginModel(

	@field:SerializedName("firstName")
	val firstName: String? = null,

	@field:SerializedName("lastName")
	val lastName: String? = null,

	@field:SerializedName("emailAddress")
	val emailAddress: String? = null,

	@field:SerializedName("access")
	val access: String? = null,

	@field:SerializedName("tier")
	val tier: String? = null,

	@field:SerializedName("dailyPoem")
	val dailyPoem: String? = null,

	@field:SerializedName("dailySong")
	val dailySong: String = "",

	@field:SerializedName("dailyPoemNumber")
	val dailyPoemNumber: Int = 1
)
