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

    EditText fname, lname, address, city, phone, mobile;
    Button leftBtn, rightBtn;

    DatabaseReference ref;

    int sign;
    String idIntent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_text);

        fname = (EditText) findViewById(R.id.fname);
        lname = (EditText) findViewById(R.id.lname);
        address = (EditText) findViewById(R.id.address);
        city = (EditText) findViewById(R.id.city);
        phone = (EditText) findViewById(R.id.phone);
        mobile = (EditText) findViewById(R.id.mobile);

        leftBtn = (Button) findViewById(R.id.leftBtn);
        rightBtn = (Button) findViewById(R.id.rightBtn);

        ref = FirebaseDatabase.getInstance().getReference("customers");

        Intent gt = getIntent();
        sign=gt.getIntExtra("sign", 0);

        if (sign == 1)
        {
            leftBtn.setText("Cancel");
            rightBtn.setText("Save");

            fname.setText(gt.getStringExtra("fname"));
            lname.setText(gt.getStringExtra("lname"));
            address.setText(gt.getStringExtra("address"));
            city.setText(gt.getStringExtra("city"));
            phone.setText(gt.getStringExtra("phone"));
            mobile.setText(gt.getStringExtra("mobile"));
            idIntent = gt.getStringExtra("customerID");
        }
    }

    public void next(View view) {
        String fn = fname.getText().toString();
        String ln = lname.getText().toString();
        String a = address.getText().toString();
        String c = city.getText().toString();
        String p = phone.getText().toString();
        String m = mobile.getText().toString();

        if (!fn.equals("") && !ln.equals("") && !a.equals("") && !c.equals("") && !p.equals("") && !m.equals(""))
        {

            if (sign == 0)
            {
                String id = ref.push().getKey();

                Customer customer = new Customer(id, fn, ln, a, c, p, m);

                ref.child(id).setValue(customer);

                Toast.makeText(this, "Customer has been added", Toast.LENGTH_SHORT).show();

                finish();
            }
            else
            {
                Customer customer = new Customer(idIntent, fn, ln, a, c, p, m);
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
