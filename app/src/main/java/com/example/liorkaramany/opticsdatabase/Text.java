package com.example.liorkaramany.opticsdatabase;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class Text extends AppCompatActivity {

    EditText name, age, left, right, price;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_text);

        name = (EditText) findViewById(R.id.name);
        age = (EditText) findViewById(R.id.age);
        left = (EditText) findViewById(R.id.left);
        right = (EditText) findViewById(R.id.right);
        price = (EditText) findViewById(R.id.price);
    }

    public void next(View view) {
    }

    public void back(View view) {
        finish();
    }

}
