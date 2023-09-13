package usl.amaruk.model

import com.google.gson.annotations.SerializedName

class SongModel(@field:SerializedName("songData")
                           val songData: ByteArray? = null
)