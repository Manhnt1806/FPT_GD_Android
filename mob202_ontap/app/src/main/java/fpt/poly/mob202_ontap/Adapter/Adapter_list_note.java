package fpt.poly.mob202_ontap.Adapter;

import android.app.Dialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import fpt.poly.mob202_ontap.DAO.NoteDAO;
import fpt.poly.mob202_ontap.DTO.Note;
import fpt.poly.mob202_ontap.R;

public class Adapter_list_note extends RecyclerView.Adapter<Adapter_list_note.dsNoteViewHolder>{
    Context context;
    List<Note> listNote;
    NoteDAO dao;


    public Adapter_list_note(Context context, List<Note> listNote) {
        this.context = context;
        this.listNote = listNote;
    }

    @NonNull
    @Override
    public Adapter_list_note.dsNoteViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        this.context = parent.getContext();
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.dialog_note_layout,parent,false);
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context, "OK", Toast.LENGTH_SHORT).show();
//                Note note = new Note();
//                Dialog dialog = new Dialog(context);
//                dialog.setContentView(R.layout.note_view_layout);
//                TextView tv_nd,tv_time;
//                tv_nd = dialog.findViewById(R.id.tv_nd);
//                tv_time = dialog.findViewById(R.id.tv_time);
//                tv_nd.setText(note.getContent());
//                tv_time.setText(note.getTime());
            }
        });
        return new dsNoteViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Adapter_list_note.dsNoteViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }
    static class dsNoteViewHolder extends RecyclerView.ViewHolder {
        TextView tv_thoigian,tv_content;
        ImageView img_close;
        public dsNoteViewHolder(@NonNull View itemView) {
            super(itemView);


            tv_content= itemView.findViewById(R.id.tv_content);
            tv_thoigian = itemView.findViewById(R.id.tv_thoigian);
            img_close = itemView.findViewById(R.id.img_close);

        }
    }
}
