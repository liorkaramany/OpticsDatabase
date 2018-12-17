package com.example.liorkaramany.opticsdatabase;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Text extends AppCompatActivity {

    EditText name, age, left, right, price;

    Button leftBtn, rightBtn;

    DatabaseReference ref;

    int sign;
    String idIntent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_text);

        name = (EditText) findViewById(R.id.name);
        age = (EditText) findViewById(R.id.age);
        left = (EditText) findViewById(R.id.left);
        right = (EditText) findViewById(R.id.right);
        price = (EditText) findViewById(R.id.price);

        leftBtn = (Button) findViewById(R.id.leftBtn);
        rightBtn = (Button) findViewById(R.id.rightBtn);

        ref = FirebaseDatabase.getInstance().getReference("customers");

        Intent gt = getIntent();
        sign=gt.getIntExtra("sign", 0);

        if (sign == 1)
        {
            leftBtn.setText("Cancel");
            rightBtn.setText("Save");

            name.setText(gt.getStringExtra("name"));
            age.setText(""+gt.getIntExtra("age", 0));
            left.setText(""+gt.getDoubleExtra("left", 0));
            right.setText(""+gt.getDoubleExtra("right", 0));
            price.setText(""+gt.getDoubleExtra("price", 0));

            idIntent = gt.getStringExtra("id");
        }
    }

    public void next(View view) {
        String n = name.getText().toString();
        String a = age.getText().toString();
        String l = left.getText().toString();
        String r = right.getText().toString();
        String p = price.getText().toString();

        if (!n.equals("") && !a.equals("")
                && !l.equals("-") && !l.equals(".") && !l.equals("")
                && !r.equals("-") && !r.equals(".") && !r.equals("")
                && !p.equals("") && !p.equals("."))
        {

            if (sign == 0)
            {
                String id = ref.push().getKey();

                Customer customer = new Customer(id, n, Integer.parseInt(a), Double.parseDouble(l), Double.parseDouble(r), Double.parseDouble(p), "");

                ref.child(id).setValue(customer);

                Toast.makeText(this, "Customer has been added", Toast.LENGTH_SHORT).show();

                finish();
            }
            else
            {
                Customer customer = new Customer(idIntent, n, Integer.parseInt(a), Double.parseDouble(l), Double.parseDouble(r), Double.parseDouble(p), "");
                ref.child(idIntent).setValue(customer);
                Toast.makeText(this, "Customer has been edited", Toast.LENGTH_SHORT).show();
                finish();
            }
        }
        else
            Toast.makeText(this, "You haven't entered all the necessary information", Toast.LENGTH_LONG).show();
    }

    public void back(View view) {
        finish();
    }

}
