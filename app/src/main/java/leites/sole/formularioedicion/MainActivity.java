package leites.sole.formularioedicion;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatEditText;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.TextView;

import java.util.Calendar;
import java.util.Objects;

public class MainActivity extends AppCompatActivity {

    AppCompatEditText nombre, telefono, email, descripcion;
    AppCompatButton siguiente;
    TextView dpFecha;
    DatePickerDialog.OnDateSetListener setListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nombre = findViewById(R.id.ingNombre);
        telefono = findViewById(R.id.ingTelefono);
        email = findViewById(R.id.ingEmail);
        descripcion = findViewById(R.id.ingDescripcion);
        siguiente = findViewById(R.id.btnSiguiente);
        dpFecha = findViewById(R.id.dpFecha);

        Calendar calendar = Calendar.getInstance();
        final int year = calendar.get(Calendar.YEAR);
        final int month = calendar.get(Calendar.MONTH);
        final int day = calendar.get(Calendar.DAY_OF_MONTH);

        dpFecha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatePickerDialog datePickerDialog = new DatePickerDialog(
                        MainActivity.this, android.R.style.Theme_Holo_Light_Dialog_MinWidth
                        ,setListener,year,month,day
                );
                datePickerDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                datePickerDialog.show();
            }
        });

        setListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                month = month+1;
                String date = day+"/"+month+"/"+year;
                dpFecha.setText(date);
            }
        };
    }

    //Boton siguiente
    public void Siguiente(View view){
        String name = nombre.getText().toString();
        String age = dpFecha.getText().toString();
        String tel = telefono.getText().toString();
        String mail = email.getText().toString();
        String desc = descripcion.getText().toString();

        Intent siguiente = new Intent(this, ConfirmarDatos.class);

        siguiente.putExtra("name", name);
        siguiente.putExtra("age", age);
        siguiente.putExtra("tel", tel);
        siguiente.putExtra("mail", mail);
        siguiente.putExtra("desc", desc);

        startActivity(siguiente);
    }
}