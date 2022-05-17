package com.example.pruebamedioparcial;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class TercerActivityMCLB extends AppCompatActivity {


    private EditText etNombre3;
    private EditText etApellido3;
    private EditText etBase3;
    private EditText etExponente3;
    private EditText etFactorial3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tercer_mclb);

        etNombre3 = (EditText) findViewById(R.id.txtNombre3);
        etApellido3 = (EditText) findViewById(R.id.txtApellido3);
        etBase3 = (EditText) findViewById(R.id.txtBase3);
        etExponente3 = (EditText) findViewById(R.id.txtExponente3);
        etFactorial3 = (EditText) findViewById(R.id.txtFactorial3);

    }



    public void onClickCerrarTodo(View view){
        String nombre3 = etNombre3.getText().toString();
        String apellido3 = etApellido3.getText().toString();
        String base3 = etBase3.getText().toString();
        String exponente3 = etExponente3.getText().toString();
        String factorial3 = etFactorial3.getText().toString();

        //Regresar el item seleccionado a la otra actividad
        if (!nombre3.matches("") && !apellido3.matches("") && !base3.matches("") &&
                !exponente3.matches("") && !factorial3.matches("")){

            int exp = Integer.parseInt(exponente3);
            if (exp >= 0){
                Intent intent = new Intent(this,SegundoActivityMCLB.class);
                intent.putExtra("key_nombre3",nombre3);
                intent.putExtra("key_apellido3",apellido3);
                intent.putExtra("key_base3",base3);
                intent.putExtra("key_exponente3",exponente3);
                intent.putExtra("key_factorial3",factorial3);

                startActivity(intent);

            }else{
                Toast.makeText(this, "Exponente no debe ser menor a 0", Toast.LENGTH_LONG).show();

            }

        }else{
            Toast.makeText(this, "Campos Obligatorios", Toast.LENGTH_LONG).show();
        }

    }
}