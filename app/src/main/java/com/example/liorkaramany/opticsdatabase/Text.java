package com.example.liorkaramany.opticsdatabase;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Text extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_text);
    }

    public void back(View view) {
        finish();
    }
}
