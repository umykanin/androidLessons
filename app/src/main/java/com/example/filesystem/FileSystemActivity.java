package com.example.filesystem;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import com.example.dialog.R;

import java.io.File;

public class FileSystemActivity extends AppCompatActivity {

    EditText folderName;
    String folderNameStr;
    Button btnCreate, btnOpen, btnDelete;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_file_system);
        folderName = findViewById(R.id.file_system_folder_name);
        btnCreate = findViewById(R.id.file_system_btn_create);
        btnOpen = findViewById(R.id.file_system_btn_open);
        btnDelete = findViewById(R.id.file_system_btn_delete);


        btnCreate.setOnClickListener(v -> {
            folderNameStr = folderName.getText().toString().trim();
            if (ActivityCompat.checkSelfPermission(getApplicationContext(),
                    Manifest.permission.WRITE_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED) {
                createFolder();
            } else {
                ActivityCompat.requestPermissions(FileSystemActivity.this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, 100);
            }
        });

        btnOpen.setOnClickListener(v -> {
            folderNameStr = folderName.getText().toString().trim();
            Uri uri = Uri.parse(this.getExternalFilesDir(null) + "/" + folderNameStr + "/");
            startActivity(new Intent(Intent.ACTION_GET_CONTENT).setDataAndType(uri, "*/*"));
        });

        btnDelete.setOnClickListener(v -> {
            folderNameStr = folderName.getText().toString().trim();
            File file = new File(this.getExternalFilesDir(null), folderNameStr);
            if (file.exists()) {
                boolean deleted = file.delete();
                if (deleted) {
                    Toast.makeText(getApplicationContext(), "File successfully deleted.", Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(getApplicationContext(), "Could not delete the file.", Toast.LENGTH_LONG).show();
                }
            } else {
                Toast.makeText(getApplicationContext(), "File does not exists.", Toast.LENGTH_LONG).show();
            }
        });
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == 100 && grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
            createFolder();
        } else {
            Toast.makeText(getApplicationContext(), "Permission denied." , Toast.LENGTH_SHORT).show();
        }
    }

    private void createFolder() {
       File file = new File(this.getExternalFilesDir(null), folderNameStr);
       if (file.exists()) {
           Toast.makeText(getApplicationContext(), "Directory already exists", Toast.LENGTH_SHORT).show();
       } else {
           file.mkdirs();
           if (file.isDirectory()) {
               Toast.makeText(getApplicationContext(), this.getExternalFilesDir(null) + " Directory created!", Toast.LENGTH_SHORT).show();
           } else {
               AlertDialog.Builder builder = new AlertDialog.Builder(this);
               String message = "Failed to create directory: " +
                       "\nPath: " + this.getExternalFilesDir(null) +
                       "\nmkdirs: " + file.mkdirs();
               builder.setMessage(message);
               builder.show();
           }
       }
    }
}
