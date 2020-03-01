
package com.reactlibrary;

import android.app.WallpaperManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;


import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class RNWallpaperManagerModule extends ReactContextBaseJavaModule {

  private final ReactApplicationContext reactContext;

  public RNWallpaperManagerModule(ReactApplicationContext reactContext) {
    super(reactContext);
    this.reactContext = reactContext;
  }

  public static Bitmap drawableFromUrl(String url) throws Exception {
    Bitmap x;
    InputStream input = null;
    HttpURLConnection connection = null;

    try {
      connection = (HttpURLConnection) new URL(url).openConnection();
      connection.connect();

      input = connection.getInputStream();

    } catch (IOException e) {
      throw new Exception(e.getMessage());
    }

    return BitmapFactory.decodeStream(input);
  }


  @ReactMethod
  public void setAsWallpaper(String url, Promise promise) {

    try{
      Bitmap bitmap = drawableFromUrl(url);

      WallpaperManager manager = WallpaperManager.getInstance(reactContext);
      manager.setBitmap(bitmap);

      promise.resolve(true);

    } catch (Exception e) {
      promise.reject(new Error(e.getLocalizedMessage()));
    }
  }


  @Override
  public String getName() {
    return "RNWallpaperManagerModule";
  }
}