package com.marcelo.appgeradorqrcode;

import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;

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
                if (TextUtils.isEmpty(editQrCode.getText().toString())) {
                    editQrCode.setError("*");
                    editQrCode.requestFocus();
                } else {
                    gerarQRCode(editQrCode.getText().toString());
                }
            }
        });
    }

    private void initComponentes() {
        editQrCode = findViewById(R.id.editQRCode);
        btnCompartilhar = findViewById(R.id.btnCompartilhar);
        btnGerarQRCode = findViewById(R.id.btnGerarQrCode);
        imgQrCode = findViewById(R.id.imgQrCode);
    }

    private void gerarQRCode(String codigo) {
        QRCodeWriter qrCode = new QRCodeWriter();

        try {
            BitMatrix bitMatrix = qrCode.encode(codigo, BarcodeFormat.QR_CODE, 196, 196);

            int tamanho = bitMatrix.getWidth();
            int altura = bitMatrix.getHeight();

            Bitmap bitmap = Bitmap.createBitmap(tamanho, altura, Bitmap.Config.RGB_565);

            for (int x = 0; x < tamanho; x++) {
                for (int y = 0; y < altura; y++) {
                    bitmap.setPixel(x,y, bitMatrix.get(x,y) ? Color.BLACK : Color.WHITE);
                }
            }

            imgQrCode.setImageBitmap(bitmap);

        } catch (WriterException e) {
            e.printStackTrace();
        }
    }
}