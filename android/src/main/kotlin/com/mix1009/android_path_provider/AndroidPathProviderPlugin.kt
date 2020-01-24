package com.mix1009.android_path_provider

import io.flutter.plugin.common.MethodCall
import io.flutter.plugin.common.MethodChannel
import io.flutter.plugin.common.MethodChannel.MethodCallHandler
import io.flutter.plugin.common.MethodChannel.Result
import io.flutter.plugin.common.PluginRegistry.Registrar
import android.os.Environment;

class AndroidPathProviderPlugin: MethodCallHandler {
  companion object {
    @JvmStatic
    fun registerWith(registrar: Registrar) {
      val channel = MethodChannel(registrar.messenger(), "android_path_provider")
      channel.setMethodCallHandler(AndroidPathProviderPlugin())
    }
  }

  override fun onMethodCall(call: MethodCall, result: Result) {
    if (call.method == Environment.DIRECTORY_DOWNLOADS) {
      result.success(Environment.getDownloadCacheDirectory().absolutePath)
    }
  }
}
