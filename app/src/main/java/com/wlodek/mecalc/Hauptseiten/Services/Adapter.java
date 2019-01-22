package com.wlodek.mecalc.Hauptseiten.Services;

import android.content.Context;
import android.database.Cursor;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.wlodek.mecalc.R;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {
    private Context mContext;
    private Cursor mCursor;


    public Adapter(Context context, Cursor cursor){
        mContext = context;
        mCursor = cursor;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        public TextView nameText;
        public TextView kcalText;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            nameText = itemView.findViewById(R.id.edt_name);
            kcalText = itemView.findViewById(R.id.edt_kcal);
        }
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        LayoutInflater inflater = LayoutInflater.from(mContext);
        View view = inflater.inflate(R.layout.activity_infoseite, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int i) {
        if(!mCursor.moveToPosition(i)){
            return;
        }
        String name = mCursor.getString(mCursor.getColumnIndex(Contract.Entry.COLUMN_NAME));
        String kcal = mCursor.getString(mCursor.getColumnIndex(Contract.Entry.COLUMN_KCAL));

        holder.nameText.setText(name);
        holder.kcalText.setText(kcal);
    }

    @Override
    public int getItemCount() {
        return mCursor.getCount();
    }
    public void swapCursor(Cursor newCursor){
        if (mCursor != null){
            mCursor.close();
        }
        mCursor = newCursor;

        if (newCursor != null){
            notifyDataSetChanged();
        }


    }
}
