package com.example.twoactivities;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    public static final String EXTRA_MESSAGE = "Message";
    private EditText mMessageEditText;
    private EditText mReplyTextView;
    public static final int  TEXT_REQUEST=1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mMessageEditText=findViewById(R.id.editText_Main);
        mReplyTextView=findViewById(R.id.text_reply);

    }

    public void launchSecondActivity(View view) {
        String message=mMessageEditText.getText().toString();
        Intent intent= new Intent(this, SecondActivity.class);
        intent.putExtra(EXTRA_MESSAGE, message);
        startActivityForResult(intent, TEXT_REQUEST);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode==TEXT_REQUEST) {
            if(resultCode==RESULT_OK) {
                String reply=data.getStringExtra(SecondActivity.EXTRA_REPLAY);
                mReplyTextView.setText(reply);
            }
        }
    }
}
