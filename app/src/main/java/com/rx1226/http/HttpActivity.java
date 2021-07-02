package com.rx1226.http;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.content.Context;
import android.os.Bundle;
import android.util.Base64;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.test.R;
import com.google.gson.Gson;
import com.rx1226.AES;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;

public class HttpActivity extends AppCompatActivity {
    private static final String TAG = "HttpActivity";
    private final String YT_API_KEY = "AIzaSyBhuET_T_wYLhew2U-yhz2YiDSlepgyUw0";
    private final String LOGIN = "https://s-api2.4gtv.tv/Bobii/SignIn";
    private final String GET_CHANNEL = "https://s-api2.4gtv.tv/Bobii/GetChannelUrl";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_http);

//        asyncGet(getSearchUrl("周杰倫"));

//        try {
//            String TextAES = "/jAUeNvZxDW3ovEPKHqWRZt5az+1AsrIqZ5DRTfuUes4+669Bmi2zaTPjI849uy7b/zpFEFADicTlxPw1oyPD7uBYVsDHQHdS8UIxRWu0yORPZTVVcpVcTvsi6mOOIEh5fD9Oa6pEo9SqR+EI3GkCiA8INX/OdTgoyhuAXHjLDEn27AuOWU6m1DAgU+ZmHhE0rW8cTPERCIKQxck9fPSHIckqdIeOR2wkl31ucNQT6oLemqu0YZ8s4rDw/yr0MQDcezd0xvf86xZ4GpHXT866BQpLMXjZ+p6IsmxWx5HMT3+0CvFWjKtDSvjcD+3rT63G3N3dS7vQJryzbka8ydxpCfkP+6P61spI3Xj2dxlTGxGsfSUKumNwLWS2jG1e6ptEmooCMWD2rSu2InybqqWgeBB5ExkKhHWZnrnHqh7k4ZV9EzupjJAbZt2UlQSjCO98Aif+oufp4zatw/f5/xJdw==";
////            String TextAES = "test";
//            String encryptText = AES.encrypt(TextAES);
//            Log.d(TAG, "encryptText = " + encryptText);
//
////            byte[] TextByte = AES.DecryptByte(Base64.decode(encryptText.getBytes("UTF-8"), Base64.DEFAULT));
//            Log.d(TAG, "decryptText = " + AES.decrypt(encryptText));
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }

//        String value = new Gson().toJson(new SignInRequest("A86BAD0BB76D", "996681179078", "88888888"), SignInRequest.class);
//        Log.d(TAG, "value = " + value);

        try {
//            Log.d(TAG, "encryptTEXT = " + AES.encrypt(value));
//            login(LOGIN, new FormBody.Builder()
//                    .add("value",AES.encrypt(value))
//                    .build());

//            String back = "RPEqu41ACyWa0zGtL7XExGWi4xHCzGjj1hsu8MOHEvGX6yzLIiq16PPdFnDpU+mR1VG2IjEUMB7bEGaQWFs3l8qVFGiAIcXPEX1YEShgZFUZAaW+9met9nE6oDYhWxJgsFs6baEXi4Z+o38BdTVcn9n80QQfRBIA1M2AHWxWeekOF9pkyQCLJbzpTM8pygNgvapxEoyqp3UK6XQvTRLiaD0oA3aBMLasDcBo9yxM3jJshdAcSK4gKPprobcq0qZctjse+s7LeK81HKGSLB0ih924YnewnTRJKqtwmzSfieh2g2/oqaxnKA2jskGMlAWtwJDb4ooWPb/PRfD0GlNymq1+4svSo+0SULomCJtnrdJeftfcY/H0XQ2bsa2w6TE0Jov8DemSriccwY5WlJh6WZI9VT/aSNzyRF8UQB/6BSBjPHX3szLfMG/oa5kcwbdz0bE0iVmZxr0KuWB4xVAKbQ==";
//            String token = AES.decrypt(back);
//            String value = new Gson().toJson(new GetChannelRequest(145, "A86BAD0BB76D", "litv-longturn16", token), GetChannelRequest.class);
//            Log.d(TAG, "value = " + value);
//            asynPost(GET_CHANNEL, new FormBody.Builder()
//                    .add("value",AES.encrypt(value))
//                    .build());
            String back = "o/0cnfoxUKZ7xiP50P18qJ/Nx0MmnTJbrzGMt6XWz1p3m8/MG0Mv/h5v10ypgX9+JJ6L8xnC5aIAXOTDZgBNzAkBwWLUSZ6qDZhMeP0PxUnhaUxZABEFz86rA0hfxiQijppdm5F5DRXk19pT3zhgwNn3gxItMbKpGN2fObFXxukd7Yj/KLc9ATozQRtx5+QvExjm8ZVXfd1RfDdbcNAByWZuIkVqkTB1RFMo3mFClxCWnAf9Vl6us7ih2UcT6hAGJaOFa5eoYQE7+2FYopc3ZoICmRz2zlvFAt1D+kaCGz5cxjguRBQUUx4WEY2fEBNIx4QnCmp++xKGJiABFB1mla19veA48RGc2PcK/08ABojvHN+Pkoecv5Su4gwbsnajVG0SS7te35xMsR8EF5x6AP5KlN+zBNP88YkjD8wU7lx2BSQoZjEWElJdTaKQs+VqJJuUYDZop4fwDDNFwMiv9ZPE2t8SroC4tLbzMW2PgmI8ycw+yyOiX3pJ6R+r64/QTwS5S2ftwFvcYQkF9XhJR+SVAAhwfD7QiDe97aHsSd+COBPjw3f9HBiDGNP4gi0wOJQcqM0rk2xR1IyLJpHInPabyXgZxx79daqOD3D0DxcHRVc4CK386kS5tXBxKGvaWtjxqRXm17BmOG2nmn7T8w==";
            Log.d(TAG, "backText = " + AES.decrypt(back));
        } catch (Exception e) {
            e.printStackTrace();
        }

//        RecyclerView recyclerView = findViewById(R.id.recyclerView);
//        recyclerView.setLayoutManager(new LinearLayoutManager(this));
//        recyclerView.setAdapter(new Adapter(this));

    }

    private String getSearchUrl(String searcKeykey){
        return "https://www.googleapis.com/youtube/v3/search" +
                "?id=7lCDEYXw3mM" +
                "&key=" + YT_API_KEY +
                "&part=snippet" +
                "&q=YouTube+Data+API" +
                "&type=video" +
                "&videoCaption=closedCaption";
    }

    private class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {
        private Context context;
        private String[] numbers = {"1", "2", "3", "4", "5"};
        Adapter(Context context) {
            this.context = context;
        }

        @NonNull
        @Override
        public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            return new ViewHolder(LayoutInflater.from(context).inflate(R.layout.item_text, parent, false));
        }

        @Override
        public void onBindViewHolder(ViewHolder holder, int position) {
            holder.text.setText(numbers[position]);
        }

        @Override
        public int getItemCount() {
            return numbers.length;
        }

        class ViewHolder extends RecyclerView.ViewHolder{
            TextView text;
            ViewHolder(View itemView) {
                super(itemView);
                text = itemView.findViewById(R.id.text);
            }
        }
    }

    private void asyncGet(String url){
        Log.d("TAG", "url = " + url);
        Request request = new Request.Builder()
                .url(url)
                .build();
        OkHttpClient client = new OkHttpClient();
        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(@NonNull Call call, @NonNull IOException e) {
                e.printStackTrace();
            }

            @Override
            public void onResponse(@NonNull Call call, @NonNull Response response) {
                 ResponseBody body = response.body();
                 if(body != null){
                     Log.d("TAG", "body = " + body.toString());
                 }
            }
        });
    }

    private void asynPost(String url, FormBody body){
        Request request = new Request.Builder()
                .url(url)
                .header("From", "Bobii")
                .post(body)
                .build();
        Log.d(TAG, "hchatonFailure: 失敗");
        OkHttpClient okHttpClient = new OkHttpClient();
        okHttpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(@NonNull Call call, @NonNull IOException e) {
                Log.d(TAG, "hchatonFailure: 失敗");
            }

            @Override
            public void onResponse(@NonNull Call call, @NonNull Response response) throws IOException {
                ResponseBody body = response.body();
                if(body != null){
                    Log.d(TAG, "hchatOnResponse: "+ body.string());
                }
            }
        });
    }

    private void login(String url, FormBody body){
        Request request = new Request.Builder()
                .url(url)
                .header("From", "Bobii")
                .post(body)
                .build();
        Log.d(TAG, "hchatonFailure: 失敗");
        OkHttpClient okHttpClient = new OkHttpClient();
        okHttpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(@NonNull Call call, @NonNull IOException e) {
                Log.d(TAG, "hchatonFailure: 失敗");
            }

            @Override
            public void onResponse(@NonNull Call call, @NonNull Response response) throws IOException {
                ResponseBody body = response.body();
                if(body != null){
                    Log.d(TAG, "hchatOnResponse: "+ body.string());
                }
            }
        });
    }
}
