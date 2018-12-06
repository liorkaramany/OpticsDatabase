package com.example.liorkaramany.opticsdatabase;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

/**
 * @author Lior Karamany
 * @version 1.0
 * @since 1.0
 */
public class Credits extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_credits);
    }

    /**
     * Go back to the previous activity.
     */
    public void back(View view) {
        finish();
    }
}
