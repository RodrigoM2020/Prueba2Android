package programas.rodrigo.prueba2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import programas.rodrigo.prueba2.model.Usuario;

public class RegistroActivity extends AppCompatActivity {
    EditText txtnombre, txtmail, txtclave;
FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);
        txtnombre = findViewById(R.id.txt_registro_nombre);
        txtmail = findViewById(R.id.txt_registro_email);
        txtclave = findViewById(R.id.txt_registro_clave);
        auth = FirebaseAuth.getInstance();
    }

    public void Registrar(View view) {
        final String nombre = txtnombre.getText().toString();
        final String email = txtmail.getText().toString();
        String clave = txtclave.getText().toString();
        auth.createUserWithEmailAndPassword(email,clave)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()){
                           Usuario user = new Usuario();
                            user.setEmail(email);
                            user.setNombre(nombre);
                            user.setUid(auth.getCurrentUser().getUid());

                            FirebaseDatabase database = FirebaseDatabase.getInstance();
                            DatabaseReference myRef = database.getReference("usuarios");

                            myRef.push().setValue(user);
                            Toast.makeText(RegistroActivity.this, "Creado", Toast.LENGTH_LONG).show();

                        }else{
                            Toast.makeText(RegistroActivity.this, task.getException().getMessage(), Toast.LENGTH_LONG).show();

                        }

                    }
                });
    }
}