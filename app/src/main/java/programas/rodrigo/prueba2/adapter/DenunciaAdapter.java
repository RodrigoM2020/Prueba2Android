package programas.rodrigo.prueba2.adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import programas.rodrigo.prueba2.R;
import programas.rodrigo.prueba2.model.Denuncia;

public class DenunciaAdapter extends RecyclerView.Adapter<DenunciaAdapter.DenunciaHolder> {

    String id;
    TextView item_nombre, item_direccion;

    public Activity activity;
    public int layout;
    public List<Denuncia> list;

    public DenunciaAdapter(Activity activity, int layout, List<Denuncia> list) {
        this.activity = activity;
        this.layout = layout;
        this.list = list;
    }

    @NonNull
    @Override
    public DenunciaHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(layout, parent,false);

        return new DenunciaHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DenunciaHolder holder, int position) {

     Denuncia denuncia = list.get(position);
    holder.id = denuncia.getId();
    holder.item_nombre.setText(denuncia.getTitulo());
    holder.item_direccion.setText(denuncia.getDireccion());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public  class DenunciaHolder extends RecyclerView.ViewHolder{
String id;
TextView item_nombre, item_direccion;
        public DenunciaHolder(@NonNull View itemView) {
            super(itemView);
            item_nombre = itemView.findViewById(R.id.item_nombre_denuncia);
            item_direccion = itemView.findViewById(R.id.item_direccion_denuncia);

        }
    }
}
