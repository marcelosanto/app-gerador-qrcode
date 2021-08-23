package com.marcelo.appgeradorqrcode;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    EditText editQrCode;
    Button btnGerarQRCode, btnCompartilhar;
    ImageView imgQrCode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initComponentes();

        btnGerarQRCode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (TextUtils.isEmpty(editQrCode.getText().toString())){
                    editQrCode.setError("*");
                    editQrCode.requestFocus();
                } else {
                    gerarQRCode(editQrCode.getText().toString());
                }
            }
        });
    }

    private void gerarQRCode(String toString) {
    }

    private void initComponentes() {
        editQrCode = findViewById(R.id.editQRCode);
        btnCompartilhar = findViewById(R.id.btnCompartilhar);
        btnGerarQRCode = findViewById(R.id.btnGerarQrCode);
        imgQrCode = findViewById(R.id.imgQrCode);
    }
}