package com.example.jnitest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    // Used to load the 'native-lib' library on application startup.
    static {
        System.loadLibrary("native");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void toast(String msg){
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }

    public void click(View view){
        TextView tv = findViewById(R.id.sample_text);
        tv.setText(stringFromJNI(this) + new Random().nextInt(100));
    }

    /**
     * A native method that is implemented by the 'native-lib' native library,
     * which is packaged with this application.
     */
    public native String stringFromJNI(MainActivity obj);
}