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
    RecyclerView denuncias_rc;
    FirebaseAuth auth;
    List<Denuncia> lista;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_denuncias, container, false);

        denuncias_rc=view.findViewById(R.id.denuncias_rc);


        lista = new ArrayList<>();

        auth = FirebaseAuth.getInstance();
        String uid = auth.getCurrentUser().getUid();
        final FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("denuncias");

        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if(dataSnapshot.exists()){
                    lista.clear();
                    // txt.setText("");
            for(DataSnapshot padre : dataSnapshot.getChildren()) {
                for (DataSnapshot ds : padre.getChildren()) {
                    Denuncia denuncia = ds.getValue(Denuncia.class);
                    denuncia.setId(ds.getKey());
                    lista.add(denuncia);
                }
            }
                    DenunciaAdapter adapter = new DenunciaAdapter(getActivity(),R.layout.item_layout,lista);
                    LinearLayoutManager lm = new LinearLayoutManager(getActivity());
                    lm.setOrientation(RecyclerView.VERTICAL);
                    denuncias_rc.setLayoutManager(lm);
                    denuncias_rc.setAdapter(adapter);

                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }


        });

        return view;
    }
        }
