package com.example.tarea3_fragmentbasico;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private EditText editText;
    private FragmentoTextView fragmentoTextView;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        EdgeToEdge.enable ( this );
        setContentView ( R.layout.activity_main );
        ViewCompat.setOnApplyWindowInsetsListener ( findViewById ( R.id.main ) , (v , insets) -> {
            Insets systemBars = insets.getInsets ( WindowInsetsCompat.Type.systemBars () );
            v.setPadding ( systemBars.left , systemBars.top , systemBars.right , systemBars.bottom );
            return insets;
        } );

        // Inicialización de vistas
        editText = findViewById(R.id.editTextText);
        Button button = findViewById(R.id.button);

        // Configuración del fragmento
        if (savedInstanceState == null) {
            fragmentoTextView = FragmentoTextView.newInstance("", "");
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.frameLayoutMain , fragmentoTextView)
                    .commitNow(); // Asegura que la transacción se ejecute inmediatamente

        } else {
            fragmentoTextView = (FragmentoTextView) getSupportFragmentManager().findFragmentById(R.id.frameLayoutMain );
        }

        button.setOnClickListener(v -> {
            String text = editText.getText().toString();
            Log.d("MainActivity", "Texto ingresado: " + text);
            if (fragmentoTextView != null) {
                fragmentoTextView.actualizarTexto(text);
            } else {
                Log.e("MainActivity", "FragmentoTextView es null");
            }
        });

    }
}