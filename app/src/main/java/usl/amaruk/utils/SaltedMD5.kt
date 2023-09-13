package usl.amaruk.utils

import java.security.MessageDigest
import java.security.NoSuchAlgorithmException
import java.security.SecureRandom
import kotlin.experimental.and

object SaltedMD5 {
    fun getSecureHashString(stringToHash: String): String? {
        var generatedHashString: String? = null
        try {
            /*
            Create MessageDigest instance for MD5 or SHA-1,SHA-256,SHA-384,SHA-512
            MD5 (Simple password security using MD5)
            SHA-1 (Stronger then MD5 Simplest one – 160 bits Hash)
            SHA-256 (Stronger than SHA-1 – 256 bits Hash)
            SHA-384 (Stronger than SHA-256 – 384 bits Hash)
            SHA-512 (Stronger than SHA-384 – 512 bits Hash)
            */
            val md: MessageDigest = MessageDigest.getInstance("MD5")
            //Add password bytes to digest
           // md.update(getSalt())
            //Get the hash's bytes
            val bytes: ByteArray = md.digest(stringToHash.toByteArray())
            //This bytes[] has bytes in decimal format;
            //Convert it to hexadecimal format
            val sb = StringBuilder()
            for (aByte in bytes) {
                sb.append(((aByte and 0xff.toByte()) + 0x100).toString(16).substring(1))
            }
            //Get complete hashed password in hex format
            generatedHashString = sb.toString()
        } catch (e: NoSuchAlgorithmException) {
            e.printStackTrace()
        }
        return generatedHashString
    }

    //Add salt
    private fun getSalt(): ByteArray? {
        val sr: SecureRandom = SecureRandom.getInstance("SHA1PRNG")
        val salt = ByteArray(16)
        sr.nextBytes(salt)
        return salt
    }
}