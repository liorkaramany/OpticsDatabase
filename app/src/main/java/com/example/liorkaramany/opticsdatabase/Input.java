package com.example.liorkaramany.opticsdatabase;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

/**
 * @author Lior Karamany
 * @version 1.0
 * @since 1.0
 */
public class Input extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input);

    }

    /**
     * Go to the Text activity.
     */
    public void text(View view) {
        Intent t = new Intent(this, Text.class);
        startActivity(t);
    }

    /**
     * Go to the Camera activity.
     */
    public void camera(View view) {
        Intent t = new Intent(this, Camera.class);
        startActivity(t);
    }

    public void back(View view) {
        finish();
    }
}
