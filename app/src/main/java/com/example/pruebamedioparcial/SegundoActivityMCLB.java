package com.example.pruebamedioparcial;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SegundoActivityMCLB extends AppCompatActivity {
    private EditText etNombre2;
    private EditText etBase2;
    private EditText etApellido2;
    private EditText etExponente2;
    private EditText etFactorial2;
    private Button btnsiguiente2;
    private Button btncerrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_segundo_mclb);

        etNombre2 = (EditText) findViewById(R.id.txtNombre2);
        etBase2 = (EditText) findViewById(R.id.txtBase2);
        etApellido2 = (EditText) findViewById(R.id.txtApellido2);
        etExponente2 = (EditText) findViewById(R.id.txtExponente2);
        etFactorial2 = (EditText) findViewById(R.id.txtFactorial2);
        btnsiguiente2 = findViewById(R.id.btnSiguiente2);
        btncerrar = findViewById(R.id.btnCerrar);

        //Obtener los datos del tercer activity
        Bundle datosExtra = getIntent().getExtras();
        if(datosExtra != null){
            String nombre3 = datosExtra.getString("key_nombre3");
            String apellido3 = datosExtra.getString("key_apellido3");
            String base3 = datosExtra.getString("key_base3");
            String exponencial3 = datosExtra.getString("key_exponente3");
            String factorial3 = datosExtra.getString("key_factorial3");

            etNombre2.setText(nombre3);
            etBase2.setText(base3);

            etApellido2.setText(apellido3);
            etExponente2.setText(exponencial3);
            etFactorial2.setText(factorial3);

            btnsiguiente2.setEnabled(false);
            btncerrar.setEnabled(true);
        }

    }

    //nueva forma para retornar una variable de un activity hija
    ActivityResultLauncher<Intent> activityResult = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(),
            new ActivityResultCallback<ActivityResult>() {
                @Override
                public void onActivityResult(ActivityResult result) {
                    //procesar los datos
                    if(  result.getResultCode() == Activity.RESULT_OK){
                        Intent data = result.getData();
                        //tvTitulo.setText("Usted Seleccionada en la actividad  hija: " + data.getDataString());
                    }
                }
            });
    public void onClickCerrarTodo(View view){
        String nombre2 = etNombre2.getText().toString();
        String apellido2 = etApellido2.getText().toString();
        String base2 = etBase2.getText().toString();
        String exponente2 = etExponente2.getText().toString();
        String factorial2 = etFactorial2.getText().toString();

        Intent intent = new Intent(this,MainActivity.class);
        intent.putExtra("key_nombre2",nombre2);
        intent.putExtra("key_apellido2",apellido2);
        intent.putExtra("key_base2",base2);
        intent.putExtra("key_exponente2",exponente2);
        intent.putExtra("key_factorial2",factorial2);

        startActivity(intent);
    }
    public void onClickIngresartercerActivity(View view){
        //String nombre2 = etNombre2.getText().toString();
       // String baseStr = etBase2.getText().toString();


                Intent intent = new Intent(this, TercerActivityMCLB.class);
                startActivity(intent);
                //activityResult.launch(intent);

    }
}