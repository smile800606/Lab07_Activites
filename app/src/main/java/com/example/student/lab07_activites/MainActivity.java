package com.example.student.lab07_activites;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.widget.ScrollView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private static final int SELECT_COLOR_REQUEST = 0;
    private static final int EDIT_TEXT_REQUEST = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void selectColor(View view) {
        //Intent ( 傳回的Activity 接受傳令的 Activity)
        Intent intent = new Intent(this, ColorPickerActivity.class);
        startActivityForResult(intent, SELECT_COLOR_REQUEST);//傳令需要能返回結果
    }
    public void editText(View view){
        Intent intent = new Intent(this, EditTextActivity.class);
        startActivityForResult(intent, EDIT_TEXT_REQUEST);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        // 如果回傳的包裹裡的識別碼與我們幫出定義的相同 這結果(包裹)就是我們的
        if (requestCode == SELECT_COLOR_REQUEST) {
            if (resultCode == RESULT_OK) {
                //取得傳令兵的包裹
                Bundle bundle = data.getExtras();
                //從包裹取出值
                int colorInt = bundle.getInt(ColorPickerActivity.BUNDLE_KEY_COLOR_INT);
                CharSequence colorName =
                        bundle.getCharSequence(ColorPickerActivity.BUNDLE_KEY_COLOR_NAME);
                //將 Color 相關資訊定到 TextView
                TextView tv_color = (TextView) findViewById(R.id.tv_Color);
                tv_color.setGravity(Gravity.CENTER);
                tv_color.setText(colorName);
                //變更ScrollView背景顏色
                ScrollView scrollView = (ScrollView)findViewById(R.id.scroll_view);
                scrollView.setBackgroundColor(colorInt);
            }
        }else if(requestCode ==RESULT_OK){
            if(resultCode == RESULT_OK){
                //取得傳令兵 包裹
                Bundle bundle = data.getExtras();
                //從包裹拿出 CharSequence 資料  需提通資料的KEY
                CharSequence text = bundle.getCharSequence(EditTextActivity.BUNDLE_KEY_TEXT);
                //變更 TextView的文字
                TextView tv_color = (TextView)findViewById((R.id.tv_Color));
                tv_color.setGravity(Gravity.LEFT);
                tv_color.setText(text);
            }
        }
    }
    public void Next(View view) {
        Intent intent = new Intent(this, Activity1.class);
        startActivity(intent);
    }
}