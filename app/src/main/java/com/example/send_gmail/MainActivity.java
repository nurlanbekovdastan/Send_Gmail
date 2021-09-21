package com.example.send_gmail;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText editText, editText2, editText3;
    private Button button, button2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText = findViewById(R.id.ed_txt);
        editText2 = findViewById(R.id.ed_txt2);
        editText3 = findViewById(R.id.ed_txt3);
        button = findViewById(R.id.btn_d);
        button2 = findViewById(R.id.btn_dr);

        button2.setOnClickListener(v -> {
            Intent intent = new Intent(Intent.ACTION_SET_WALLPAPER);
            startActivity(intent);
        });

        button.setOnClickListener(v -> {
            if (editText.getText().toString().isEmpty() && editText2.getText().toString().isEmpty() && editText3.getText().toString().isEmpty()) {
                Toast.makeText(this, "Заполните поля", Toast.LENGTH_SHORT).show();
            }else if(editText.getText().toString().isEmpty()){
                Toast.makeText(this, "Заполни остальное", Toast.LENGTH_SHORT).show();
            }else if (editText2.getText().toString().isEmpty()){
                Toast.makeText(this, "Заполни", Toast.LENGTH_SHORT).show();
            }else if (editText3.getText().toString().isEmpty()){
                Toast.makeText(this, "ЗАПОЛНИ!!", Toast.LENGTH_SHORT).show();
            } else{
                Intent intent2 = new Intent(Intent.ACTION_SEND);
                intent2.setType("plain/text");
                intent2.putExtra(Intent.EXTRA_EMAIL,new String[]{
                        editText.getText().toString()});
                intent2.putExtra(Intent.EXTRA_SUBJECT,editText2.getText().toString());
                intent2.putExtra(Intent.EXTRA_TEXT,editText3.getText().toString());
                startActivity(intent2);
            }
        });
    }
}
