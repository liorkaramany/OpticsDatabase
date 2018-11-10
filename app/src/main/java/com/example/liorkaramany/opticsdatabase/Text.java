package com.example.liorkaramany.opticsdatabase;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Text extends AppCompatActivity {

    EditText name, age, left, right, price;

    DatabaseReference ref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_text);

        name = (EditText) findViewById(R.id.name);
        age = (EditText) findViewById(R.id.age);
        left = (EditText) findViewById(R.id.left);
        right = (EditText) findViewById(R.id.right);
        price = (EditText) findViewById(R.id.price);

        ref = FirebaseDatabase.getInstance().getReference("customers");
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
            String id = ref.push().getKey();

            Customer customer = new Customer(id, n, Integer.parseInt(a), Double.parseDouble(l), Double.parseDouble(r), Double.parseDouble(p));

            ref.child(id).setValue(customer);

            Intent t = new Intent(this, Main.class);
            startActivity(t);
        }
        else
            Toast.makeText(this, "You haven't entered all the necessary information", Toast.LENGTH_LONG).show();
    }

    public void back(View view) {
        finish();
    }

}
