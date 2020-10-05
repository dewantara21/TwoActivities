package com.example.twoactivities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {
    public static final String EXTRA_REPLAY="REPLY";
    private EditText mReplay;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        mReplay=findViewById(R.id.editText_second);
        Intent intent=getIntent();
        if(intent.hasExtra(MainActivity.EXTRA_MESSAGE)) {
            String message=intent.getStringExtra(MainActivity.EXTRA_MESSAGE);
            TextView textView=findViewById(R.id.text_message);
            textView.setText(message);
        }

    }

    public void returnReplay(View view) {
        String reply=mReplay.getText().toString();
        Intent replyintent= new Intent();
        replyintent.putExtra(EXTRA_REPLAY, reply);
        setResult(RESULT_OK, replyintent);
        finish();
    }
}
