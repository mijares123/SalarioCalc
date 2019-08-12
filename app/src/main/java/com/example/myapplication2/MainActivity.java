package com.example.myapplication2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText txtpago;
    private EditText txthoras;
    private Button btn1;
    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtpago = (EditText) findViewById(R.id.edtpago);
        txthoras = (EditText) findViewById(R.id.edthoras);
        btn1 = (Button) findViewById(R.id.btn1);
        btn1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Double salario = 0.0;
                salario = CalcularSalario(Integer.parseInt(txthoras.getText().toString()),Double.parseDouble(txtpago.getText().toString()));
                if(salario > 0.0){
                    Toast.makeText(getApplicationContext(),""+salario,Toast.LENGTH_LONG).show();
                }else{
                    Toast.makeText(getApplicationContext(),"Error 500",Toast.LENGTH_LONG).show();
                }

            }
        });
    }
    public Double CalcularSalario(int horas,Double Pago){
        Double Salario = 0.0;
        if(horas > 0 && horas <= 60){
            if (horas <= 40) {
                Salario=horas * Pago;
                return Salario;
            }
            else{
                if(horas <= 50){
                    int resto = 0;
                    resto = 50-horas;
                    Salario = (40 * Pago) + (resto * Pago * 2);
                    return Salario;
                }else{

                    int resto2 = 60 - horas;
                    Salario=40*Pago + 40 * 2 * Pago + resto2 * Pago * 3;
                    return Salario;

                }
            }
        }
        else{
            return 0.0;
        }

    }
}
