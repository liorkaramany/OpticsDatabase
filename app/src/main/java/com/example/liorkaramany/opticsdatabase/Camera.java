package com.example.liorkaramany.opticsdatabase;

import android.app.ProgressDialog;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.io.ByteArrayOutputStream;

public class Camera extends AppCompatActivity {

    private static final int CAMERA_REQEUEST_CODE = 1;

    ImageView img;

    StorageReference r;
    DatabaseReference ref;

    ProgressDialog progress;

    Uri uri = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_camera);

        img = (ImageView) findViewById(R.id.img);

        r = FirebaseStorage.getInstance().getReference("customers");
        ref = FirebaseDatabase.getInstance().getReference("customers");

        progress = new ProgressDialog(this);
    }

    public void capture(View view) {

        Intent t = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(t, CAMERA_REQEUEST_CODE);
    }

    public void back(View view) {
        finish();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == CAMERA_REQEUEST_CODE && resultCode == RESULT_OK)
        {
            //TODO: Understand how to upload images.

            uri = data.getData();

            img.setImageURI(uri);
        }

    }

    public void upload(View view) {

        if (uri != null) {

            progress.setMessage("Uploading in process");
            progress.show();

            String id = ref.push().getKey();

            ref.child(id).setValue(new Customer(id, "", 0, 0,0 ,0, ""));

            r.child(id).putFile(uri).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                @Override
                public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                    progress.dismiss();
                    Toast.makeText(Camera.this, "Customer has been uploaded", Toast.LENGTH_SHORT).show();
                }
            }).addOnFailureListener(new OnFailureListener() {
                @Override
                public void onFailure(@NonNull Exception e) {
                    Toast.makeText(Camera.this, "Push failed", Toast.LENGTH_SHORT).show();
                }
            });
        }
        else Toast.makeText(this, "You didn't capture a photo", Toast.LENGTH_LONG).show();
    }
}
