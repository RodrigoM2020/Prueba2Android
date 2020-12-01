package programas.rodrigo.prueba2.ui.main;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

import programas.rodrigo.prueba2.R;
import programas.rodrigo.prueba2.adapter.DenunciaAdapter;
import programas.rodrigo.prueba2.model.Denuncia;


public class DenunciasFragment extends Fragment {
TextView txt;
FirebaseAuth auth;

       @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_denuncias, container, false);

        txt = view.findViewById(R.id.txt_denuncias_denuncias);
        auth = FirebaseAuth.getInstance();
        String uid = auth.getCurrentUser().getUid();
           FirebaseDatabase database = FirebaseDatabase.getInstance();
           DatabaseReference myRef = database.getReference("message");

           return view;
    }

        }
