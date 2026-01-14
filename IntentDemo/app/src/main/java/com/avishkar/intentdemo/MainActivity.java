package com.avishkar.intentdemo;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        button = findViewById(R.id.btnNext);

        button.setOnClickListener(v->{ //lambda function
//            Intent i = new Intent(Intent.ACTION_VIEW);
//            Uri data = Uri.parse("https://www.udemy.com");
//            i.setData(data);
//            startActivity(i);

//            Intent i = new Intent(Intent.ACTION_SEND);
//            i.setType("text/plain");
//            i.putExtra(Intent.EXTRA_TEXT,"This is an android app");
//            startActivity(Intent.createChooser(i,"Share via"));

//            Intent i = new Intent(Intent.ACTION_DIAL);
//            i.setData(Uri.parse("tel:7841961074"));
//            startActivity(i);
        });
    }
}