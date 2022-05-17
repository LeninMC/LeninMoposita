package com.example.pruebamedioparcial;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText etNombre;
    private EditText etApellido;
    private EditText etBase;
    private EditText etExponente;
    private EditText etFactorial;
    private EditText etPotencia;
    private Button btnmostrar;
    private Button btnsiguiente;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etNombre = (EditText) findViewById(R.id.txtNombre);
        etApellido = (EditText) findViewById(R.id.txtApellido);
        etBase = (EditText) findViewById(R.id.txtBase);
        etExponente = (EditText) findViewById(R.id.txtExponente);
        etFactorial = (EditText) findViewById(R.id.txtFactorial);
        etPotencia = (EditText) findViewById(R.id.txtPotencia);

        btnmostrar = findViewById(R.id.btnMostrarResultado);
        btnsiguiente = findViewById(R.id.btnSiguiente);

        Bundle datosExtra = getIntent().getExtras();
        if(datosExtra != null){
            btnmostrar.setEnabled(true);
            btnsiguiente.setEnabled(false);
        }


    }

    public void onClickSegundoActivity(View view){
        Intent intent = new Intent(this,SegundoActivityMCLB.class);
        startActivity(intent);

    }
    public void onClickMostrarResultado(View view){

        //Obtener los datos del tercer activity
        Bundle datosExtra = getIntent().getExtras();

        if(datosExtra != null){
            String nombre3 = datosExtra.getString("key_nombre2");
            String apellido3 = datosExtra.getString("key_apellido2");
            String base3 = datosExtra.getString("key_base2");
            String exponencial3 = datosExtra.getString("key_exponente2");
            String factorial3 = datosExtra.getString("key_factorial2");

            double calPotencia = calcularPotencia(Integer.parseInt(base3),Integer.parseInt(exponencial3));
            etPotencia.setText(String.valueOf(calPotencia));
            int calFactorial = calcularFactorial(Integer.parseInt(factorial3));
            etFactorial.setText(String.valueOf(calFactorial));

            etNombre.setText(nombre3);
            etApellido.setText(apellido3);
            etBase.setText(base3);
            etExponente.setText(exponencial3);

        }else{
            Toast.makeText(this, "No existen datos aun !", Toast.LENGTH_LONG).show();
        }

    }

    private double calcularPotencia(int base,int exponente){
        //return Math.pow(base,exponente);

        int resultado = 1;
        for (int i = 1; i<=exponente; i++) {
            resultado = resultado * base;
        }
        return resultado;
    }

    private int calcularFactorial(int numero){
        int total = 1;
        if(numero != 0){
            for (int i=1; i<=numero; i++) {
                total = total * i;
            }
            return total;
        }else {
            return 1;
        }

    }
}