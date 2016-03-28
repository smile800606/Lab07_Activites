package com.example.student.lab07_activites;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class EditTextActivity extends AppCompatActivity {

    public static final String BUNDLE_KEY_TEXT = "com.android.text";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_text);
    }

    public void ok(View view){
        EditText editText = (EditText)findViewById(R.id.edit_text);
        CharSequence text = editText.getText();

        Intent intent = new Intent();
        intent.putExtra(BUNDLE_KEY_TEXT, text);
        setResult(RESULT_OK, intent);
        finish();
    }
    public void cancel(View view){
        setResult(RESULT_CANCELED);
        finish();
    }
}
