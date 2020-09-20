package com.sudanix.contactlist.data.commons

import android.content.res.AssetManager
import java.io.BufferedReader
import java.io.InputStream
import java.io.InputStreamReader

@Throws(Exception::class)
fun getStringFromFile(filePath: String, assetManager: AssetManager): String? {
    val stream: InputStream = assetManager.open(filePath)
    val ret =
        convertStreamToString(stream)
    stream.close()
    return ret
}

@Throws(Exception::class)
private fun convertStreamToString(inputStream: InputStream): String {
    val reader = BufferedReader(InputStreamReader(inputStream))
    val sb = StringBuilder()
    var line: String?
    while (reader.readLine().also { line = it } != null) {
        sb.append(line).append("\n")
    }
    reader.close()
    return sb.toString()
}