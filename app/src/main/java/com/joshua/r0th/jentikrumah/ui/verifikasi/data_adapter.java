package com.joshua.r0th.jentikrumah.ui.verifikasi;

import android.content.Context;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.firestore.FirestoreRecyclerAdapter;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;
import com.joshua.r0th.jentikrumah.R;
import com.joshua.r0th.jentikrumah.Upload_verif;
import com.squareup.picasso.Picasso;

import org.w3c.dom.Text;

import java.util.List;

public class data_adapter extends RecyclerView.Adapter<data_adapter.ImageViewHolder> {
private Context mContext;
private List<Upload_verif> mUpload;

public data_adapter(Context context, List<Upload_verif> Uploads){
    mContext = context;
    mUpload = Uploads;

}
    @NonNull
    @Override
    public ImageViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(mContext).inflate(R.layout.display_data_verif, parent, false);


        return new ImageViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ImageViewHolder holder, int position) {
    Upload_verif uploadCurrent = mUpload.get(position);
    holder.txtnama.setText(uploadCurrent.getmName());
        Picasso.get().load(uploadCurrent.getmImageurl()).resize(250, 250).into(holder.img);
    }

    @Override
    public int getItemCount() {
        return mUpload.size();
    }

    public class ImageViewHolder extends RecyclerView.ViewHolder{
        public TextView txtnama;
        public ImageView img;

        public ImageViewHolder(@NonNull View itemView) {
            super(itemView);
            img = itemView.findViewById(R.id.data_verif_img);
            txtnama = itemView.findViewById(R.id.nama_verif);

        }
    }



}
