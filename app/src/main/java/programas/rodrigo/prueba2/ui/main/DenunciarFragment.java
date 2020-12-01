package programas.rodrigo.prueba2.ui.main;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import programas.rodrigo.prueba2.R;
import programas.rodrigo.prueba2.model.Denuncia;


public class DenunciarFragment extends Fragment {
EditText txt_titulo, txt_direccion;
Button bt_guardar;
FirebaseAuth auth;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        View view = inflater.inflate(R.layout.fragment_denunciar, container, false);

        auth = FirebaseAuth.getInstance();

       txt_titulo = view.findViewById(R.id.txt_denunciar_titulo);
       txt_direccion = view.findViewById(R.id.txt_denunciar_direccion);
       bt_guardar = view.findViewById(R.id.btn_denunciar_guardar);

        bt_guardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               String titulo = txt_titulo.getText().toString();
               String direccion = txt_direccion.getText().toString();
               if(titulo.isEmpty() || direccion.isEmpty()){
            Toast.makeText(getActivity(), "Complete todo los Campos", Toast.LENGTH_LONG).show();
                }else{
                   FirebaseDatabase database = FirebaseDatabase.getInstance();
                   DatabaseReference myRef = database.getReference("denuncias");
                    Denuncia denuncia = new Denuncia();
                    denuncia.setTitulo(titulo);
                    denuncia.setDireccion(direccion);

                    String uid = auth.getCurrentUser().getUid();
                   myRef.child(uid).push().setValue(denuncia);
                   Toast.makeText(getActivity(), "Denuncia Registrada", Toast.LENGTH_LONG).show();

               }
            }
        });


        return view;
    }
}