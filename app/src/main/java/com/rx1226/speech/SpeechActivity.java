package com.rx1226.speech;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.speech.RecognitionListener;
import android.speech.RecognizerIntent;
import android.speech.SpeechRecognizer;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.test.R;

import java.util.ArrayList;
import java.util.List;

import pub.devrel.easypermissions.EasyPermissions;

import static android.Manifest.permission.ACCESS_COARSE_LOCATION;
import static android.Manifest.permission.ACCESS_FINE_LOCATION;
import static android.Manifest.permission.RECORD_AUDIO;

public class SpeechActivity extends AppCompatActivity{
    private final int REQUIRE_PERMISSIONS = 9527;
    private String[] permissions = {
            RECORD_AUDIO,
    };
    private SpeechRecognizer speechRecognizer;
    private TextView txt_result;
    private Button btn_speak;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_speech);

        txt_result = findViewById(R.id.txt_result);
        btn_speak = findViewById(R.id.btn_speak);

        speechRecognizer = SpeechRecognizer.createSpeechRecognizer(this);
        speechRecognizer.setRecognitionListener(new CustomRecognizerListener());

        btn_speak.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                callSpeakWithDialog();
                callSpeakNoDialog();
            }
        });

        EasyPermissions.requestPermissions(this, "語音需要錄音權限", REQUIRE_PERMISSIONS, permissions);
    }

    @Override
    protected void onDestroy() {
        speechRecognizer.stopListening();
        speechRecognizer.destroy();
        super.onDestroy();
    }

    private void callSpeakWithDialog(){
        //透過 Intent 的方式開啟內建的語音辨識 Activity...
        Intent intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL, RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
        intent.putExtra(RecognizerIntent.EXTRA_PROMPT, "請說話..."); //語音辨識 Dialog 上要顯示的提示文字
        startActivityForResult(intent, 1);
    }

    private void callSpeakNoDialog(){
        Intent intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL, RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);

        speechRecognizer.startListening(intent);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1) {
            if (resultCode == RESULT_OK) {
                //把所有辨識的可能結果印出來看一看，第一筆是最 match 的。
                ArrayList<String> result = data.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
                String all = "";
                if(result != null && !result.isEmpty()) {
                    for (String r : result) {
                        all = all + r + "\n";
                    }
                    txt_result.setText(all);
                }
            }
        }
    }

    private void showResult(){

    }

    //用遙控器輸入
    @Override
    public boolean dispatchKeyEvent(KeyEvent event) {
        Log.d("TAG", "keycode = " + event.getKeyCode());
        if (event.getKeyCode() == KeyEvent.KEYCODE_SEARCH) {
            if (event.getAction() == KeyEvent.ACTION_DOWN
                    && event.getRepeatCount() == 0) {
                callSpeakNoDialog();
            }
            return true;
        }
        return super.dispatchKeyEvent(event);
    }
    //用遙控器輸入End

    //無對話框輸入
    class CustomRecognizerListener implements RecognitionListener{
        @Override
        public void onReadyForSpeech(Bundle params) {

        }

        @Override
        public void onBeginningOfSpeech() {

        }

        @Override
        public void onRmsChanged(float rmsdB) {

        }

        @Override
        public void onBufferReceived(byte[] buffer) {

        }

        @Override
        public void onEndOfSpeech() {

        }

        @Override
        public void onError(int error) {

        }

        @Override
        public void onResults(Bundle results) {
            List<String> resList = results.getStringArrayList(SpeechRecognizer.RESULTS_RECOGNITION);
            if(resList != null) {
                StringBuffer sb = new StringBuffer();
                for (String res : resList) {
                    sb.append(res + "\n");
                }
                txt_result.setText("onResults: " + sb.toString());
                Log.d("RECOGNIZER", "onResults: " + sb.toString());
            }
        }

        @Override
        public void onPartialResults(Bundle partialResults) {

        }

        @Override
        public void onEvent(int eventType, Bundle params) {

        }
    }
}