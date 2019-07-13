package com.example.myapplication.OkHttp;

import org.jetbrains.annotations.NotNull;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;
import java.io.IOException;

import okhttp3.Call;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class OkHttpUtil {

    public static void GetOkHttpRequest(String address, okhttp3.Callback callback){
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url(address)
                .build();
        client.newCall(request).enqueue(callback);
    }

    public static void PostJSONFile (String address, okhttp3.Callback callback, File file) {
        final MediaType MEDIA_TYPE_MARKDOWN = MediaType.parse("application/json");
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url(address)
                .post(RequestBody.create(file, MEDIA_TYPE_MARKDOWN))
                .build();
        client.newCall(request).enqueue(callback);

    }


    public static JSONObject getJSONObject (String address, File file){
        final JSONObject[] jsonObject = new JSONObject[1];
        OkHttpUtil.PostJSONFile(address, new okhttp3.Callback() {
            @Override
            public void onFailure(@NotNull Call call, @NotNull IOException e) {
                e.printStackTrace();
            }

            @Override
            public void onResponse(@NotNull Call call, @NotNull Response response) throws IOException {
                try {
                   jsonObject[0] = new JSONObject(response.body().string());
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, file);
        return jsonObject[0];
    }



}
