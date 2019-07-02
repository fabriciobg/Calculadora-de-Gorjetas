package com.example.calcgorjeta;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText edtValConta, edtGor10, edtGor15, edtGor20, edtValConta10, edtValConta15, edtValConta20, edtGorVar, edtValContaVar;
    TextView txtPercVar;
    SeekBar seekBar;

    double valConta = 0.00;
    int perConta=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        iniComponents();

        edtValConta.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                try {
                    valConta = Double.parseDouble(s.toString());
                    calcularGorjetas();
                    calculaGorjetaVar();
                } catch (Exception e){
                    e.printStackTrace();
                }
            }
        });

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                perConta = seekBar.getProgress();
                calculaGorjetaVar();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

    }

    private void calculaGorjetaVar() {
        txtPercVar.setText(perConta+"%");

        double gorvar = valConta*(perConta*0.01);
        double valcontavar = valConta+gorvar;

        edtGorVar.setText(String.format("%.2f", gorvar));
        edtValContaVar.setText(String.format("%.2f", valcontavar));
    }

    private void calcularGorjetas() {
        double gor10 = valConta*0.1;
        double gor15 = valConta*0.15;
        double gor20 = valConta*0.2;
        double vConta10 = valConta+gor10;
        double vConta15 = valConta+gor15;
        double vConta20 = valConta+gor20;
        /*Inserindo valor nos campos*/

        edtGor10.setText(String.format("%.2f", gor10));
        edtGor15.setText(String.format("%.2f", gor15));
        edtGor20.setText(String.format("%.2f", gor20));

        edtValConta10.setText(String.format("%.2f", vConta10));
        edtValConta15.setText(String.format("%.2f", vConta15));
        edtValConta20.setText(String.format("%.2f", vConta20));




    }

    private void iniComponents() {
        edtValConta = (EditText) findViewById(R.id.editValConta);
        edtGor10 = (EditText) findViewById(R.id.edtGor10);
        edtGor15 = (EditText) findViewById(R.id.edtGor15);
        edtGor20 = (EditText) findViewById(R.id.edtGor20);
        edtValConta10 = (EditText) findViewById(R.id.edtValConta10);
        edtValConta15 = (EditText) findViewById(R.id.edtValConta15);
        edtValConta20 = (EditText) findViewById(R.id.edtValConta20);
        edtGorVar = (EditText) findViewById(R.id.edtGorVar);
        edtValContaVar = (EditText) findViewById(R.id.edtValContaVar);
        txtPercVar = (TextView) findViewById(R.id.txtPercVar);
        seekBar = (SeekBar) findViewById(R.id.seekBar);
    }
}
