package com.mahrous.demo_app.core.common

import android.content.Context
import android.net.Uri
import android.provider.OpenableColumns
import com.mahrous.demo_app.core.app.Constants.ENGLISH_LOCALE_LANG
import java.io.File
import java.io.FileInputStream
import java.io.FileOutputStream
import java.text.SimpleDateFormat
import java.util.*
import kotlin.io.copyTo
import kotlin.let

object Common {

    fun getFile(context: Context, uri: Uri): File? {
        val parcelFileDescriptor = context.contentResolver.openFileDescriptor(uri, "r", null)
        parcelFileDescriptor?.let {
            val inputStream = FileInputStream(parcelFileDescriptor.fileDescriptor)
            val file = File(context.cacheDir, getFileName(context, uri))
            val outputStream = FileOutputStream(file)
            inputStream.copyTo(outputStream)
            inputStream.close()
            outputStream.close()
            return file
        }
        return null
    }


    private fun getFileName(context: Context, fileUri: Uri): String {
        val returnCursor = context.contentResolver.query(fileUri, null, null, null, null)
        var name = ""
        if (returnCursor != null) {
            val nameIndex = returnCursor.getColumnIndex(OpenableColumns.DISPLAY_NAME)
            returnCursor.moveToFirst()
            name = returnCursor.getString(nameIndex)
            returnCursor.close()
        }
        return name
    }
    fun getCurrentStateTime(): String {
        val calendar = Calendar.getInstance()
        //val pattern = "dd/MM/yyyy HH:mm:ss"
//        val pattern = "dd/MM/yyyy HH:mm"
        // PM / AM
        val pattern = "a"
        val simpleDateFormat = SimpleDateFormat(pattern, Locale(ENGLISH_LOCALE_LANG))
        return simpleDateFormat.format(calendar.time)
    }
}