package com.example.dialogexample;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button button;
    DialogRefuel dgf;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dgf = new DialogRefuel();
        dgf.setTypeFuelValue("95");     //устанавливаем некое значение типа топлива
        button = findViewById(R.id.button_refuel);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dgf.show(getSupportFragmentManager(), "Dialog Refuel");
            }
        });
    }
}