package com.bex.recycler;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Robus on 7/19/2015.
 */
public class AlbumAdapter extends RecyclerView.Adapter<AlbumAdapter.MyViewHolder> {
    List<Album> list;
    Context context;
    LayoutInflater layoutInflater;



    public AlbumAdapter(Context context,List<Album> list){
        this.list = list;
        this.context = context;
        this.layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {

        View rowView = layoutInflater.inflate(R.layout.layout,viewGroup,false);
        MyViewHolder myViewHolder = new MyViewHolder(rowView);
        return myViewHolder;

    }

    @Override
    public void onBindViewHolder(MyViewHolder myViewHolder, int i) {

            Album album = list.get(i);
             myViewHolder.albumName.setText(album.getAlbumName());
             myViewHolder.artistName.setText(album.getAlbumReleaseYear());


    }



    @Override
    public int getItemCount() {
        return list.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        ImageView albumImage;
        TextView albumName;
        TextView artistName;



        public MyViewHolder(View itemView) {
            super(itemView);

            albumImage = (ImageView)itemView.findViewById(R.id.album_image);
            albumName = (TextView)itemView.findViewById(R.id.album_name);
            artistName = (TextView)itemView.findViewById(R.id.artist_name);



        }
    }
}
