package com.example.application_1;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.text.Editable;
import android.text.method.KeyListener;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Activity_KeyListener_Java extends AppCompatActivity {
    Button btn_add;
    TextView textview_add,textview_answer;
    EditText edittext_input01, edittext_input02;
    String strKey[] = new String[10];
    int i=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_edittext_java);
//        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
//            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
//            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
//            return insets;
//        });

        btn_add = findViewById(R.id.button_add);
        textview_add = findViewById(R.id.textview_add);
        textview_answer = findViewById(R.id.textview_answer);
        edittext_input01 = findViewById(R.id.edittext_input01);
        edittext_input02 = findViewById(R.id.edittext_input02);


        edittext_input02.setVisibility(View.INVISIBLE);
        textview_answer.setVisibility(View.INVISIBLE);
        btn_add.setVisibility(View.INVISIBLE);

        for(i = 0; i< strKey.length; i++){
            strKey[i] = new String("你按的按鍵是："+i);
        }

        edittext_input01.setKeyListener(new KeyListener(){
            @Override
            public int getInputType() {
                return 0;
            }

            @Override
            public boolean onKeyDown(View view, Editable text, int KeyCode, KeyEvent event)  {
                if(event.getAction() == KeyEvent.ACTION_DOWN){
                    edittext_input01.setHint("");
//                    edittext_input01.setText(new Integer(KeyCode-7).toString());
                    Integer integerKey = new Integer(KeyCode-7);
                    String outputString = integerKey.toString();
                    edittext_input01.setText(outputString);

//                    textview_add.setText(" : "+strKey[KeyCode-7]);
                    int indexKeyMessage = KeyCode -7;
                    textview_add.setText(" : "+strKey[indexKeyMessage]);

                    return true;
                }
                return false;
            }

            @Override
            public boolean onKeyUp(View view, Editable text, int keyCode, KeyEvent event) {
                return false;
            }

            @Override
            public boolean onKeyOther(View view, Editable text, KeyEvent event) {
                return false;
            }

            @Override
            public void clearMetaKeyState(View view, Editable content, int states) {

            }


        });


    }
}
