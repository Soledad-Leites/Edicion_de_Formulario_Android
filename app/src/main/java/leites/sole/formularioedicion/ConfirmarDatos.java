package leites.sole.formularioedicion;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatEditText;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ConfirmarDatos extends AppCompatActivity {

    TextView cdNombre, cdFechaNacimiento, cdTelefono, cdEmail, cdDescripcion;
    AppCompatButton btnEditar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirmar_datos);

        cdNombre = findViewById(R.id.cdNombre);
        cdFechaNacimiento = findViewById(R.id.cdFechaNacimiento);
        cdTelefono = findViewById(R.id.cdTelefono);
        cdEmail = findViewById(R.id.cdEmail);
        cdDescripcion = findViewById(R.id.cdDescripcion);
        btnEditar = findViewById(R.id.btnEditar);

        //BOTON REGRESAR
        btnEditar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        mostrarDatos();
    }

    private void mostrarDatos(){
        Bundle datos = this.getIntent().getExtras();
        String nombre = datos.getString("name");
        String anio = datos.getString("age");
        String telefono = datos.getString("tel");
        String email = datos.getString("mail");
        String descripcion = datos.getString("desc");

        cdNombre.setText(nombre);
        cdFechaNacimiento.setText(anio);
        cdTelefono.setText(telefono);
        cdEmail.setText(email);
        cdDescripcion.setText(descripcion);

    }
}