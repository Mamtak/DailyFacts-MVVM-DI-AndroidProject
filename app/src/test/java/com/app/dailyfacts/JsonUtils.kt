package com.app.dailyfacts

import android.content.Context
import java.nio.charset.StandardCharsets

object JsonUtils {
    fun loadJsonFromAsset(context: Context, filename: String?) : String? {
      var json: String? = null
      json = try {
          val `is` = context.assets.open(filename!!)
          val size = `is`.available();
          val buffer = ByteArray(size)
          `is`.read(buffer)
          `is`.close()
          String(buffer, StandardCharsets.UTF_8)
      }catch (ex: Exception){
          return ""
      }
        return json;
    }
}