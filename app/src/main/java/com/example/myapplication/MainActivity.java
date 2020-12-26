package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private EditText et1;
    private EditText et2;
    private EditText et3;
    private Button bt1;
    private Button bt2;
    private TextView TV;
    private Retrofit retrofit;

    private final static String BASE_URL = "http://chlwhdtn.ddns.net/";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();

        bt1.setOnClickListener(v->{
            String str = et1.getText().toString();
            int update_id = Integer.parseInt(str);
            UpdateInfo(update_id,et2.getText().toString());
        });

    }

    private void UpdateInfo(int id,String name){
        ApiService apiService = retrofit.create(ApiService.class);
        Call<Data> call = apiService.Update(id,name);
        call.enqueue(new Callback<Data>() {
            @Override
            public void onResponse(Call<Data> call, Response<Data> response) {
                Log.e("response_code",response.code()+"");
                Data data = response.body();
            }

            @Override
            public void onFailure(Call<Data> call, Throwable t) {
                Log.e("asd","error");
            }
        });

    }

    private void init() {
        et1 = findViewById(R.id.school_number);
        et2 = findViewById(R.id.name);
        et3 = findViewById(R.id.school_number_check);
        bt1 = findViewById(R.id.bt);
        bt2 = findViewById(R.id.bt_2);
        TV = findViewById(R.id.value);

        retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }
}