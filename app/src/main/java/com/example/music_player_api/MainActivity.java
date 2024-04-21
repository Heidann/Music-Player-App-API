package com.example.music_player_api;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.gson.Gson;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttp;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;


public class MainActivity extends AppCompatActivity {






    TextView textView;
    Button btnGet;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.textData);
        btnGet = findViewById(R.id.btnGet);

        btnGet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    GetAlbum();

                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        });


    }
    public void GetAlbum() throws IOException {
        OkHttpClient client = new OkHttpClient();


        Request request = new Request.Builder()
                .url("https://spotify23.p.rapidapi.com/albums/?ids=3IBcauSj5M2A6lTeffJzdv")
                .get()
                .addHeader("X-RapidAPI-Key", "3718a556c7mshdf3159b442f993dp1b48ebjsnf22fdc11772e")
                .addHeader("X-RapidAPI-Host", "spotify23.p.rapidapi.com")
                .build();

        /*Response response = client.newCall(request).execute();*/
        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(@NonNull Call call, @NonNull IOException e) {
                e.printStackTrace();
            }

            @Override
            public void onResponse(@NonNull Call call, @NonNull Response response) throws IOException {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {


                        String responseData = null; 
                        try {
                            responseData = response.body().string();
                            // Phân tích chuỗi JSON thành đối tượng AlbumClass
                            Gson gson = new Gson();
                            AlbumClass.AlbumResponse albumResponse = gson.fromJson(responseData, AlbumClass.AlbumResponse.class);

                            // Sau khi phân tích xong, bạn có thể sử dụng dữ liệu trong đối tượng albumResponse ở đây
                            // Ví dụ: albumResponse.getAlbums() để lấy danh sách các album

                            // Set text cho textView hoặc thực hiện các thao tác khác với dữ liệu ở đây
                            textView.setText(responseData);
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                        Log.d("ResDataAlbum", responseData);



                    }
                });
            }
        });

    }
}