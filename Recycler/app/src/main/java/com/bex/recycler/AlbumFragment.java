package com.bex.recycler;


import android.graphics.drawable.NinePatchDrawable;
import android.os.Bundle;
import android.support.v4.app.*;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;


public class AlbumFragment extends Fragment {
    List<Album> list;
    RecyclerView albumRecycler;

    public AlbumFragment(){

    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_album, container, false);
       list = getAlbumList();
        //..................................................
        //fucked me here
       albumRecycler = (RecyclerView) view.findViewById(R.id.album_recycler);
        /*

        mRecyclerView = (RecyclerView) rootView.findViewById(R.id.my_recycler_view);
    mRecyclerView.addItemDecoration(new DividerItemDecoration(getActivity(), DividerItemDecoration.VERTICAL_LIST));

    mRecyclerView.setHasFixedSize(true);
    mLayoutManager = new LinearLayoutManager(getActivity());
    mRecyclerView.setLayoutManager(mLayoutManager);
    mRecyclerView.setItemAnimator(new DefaultItemAnimator());




         */

        albumRecycler.addItemDecoration(new DividerItemDecoration(getActivity(),null));
        albumRecycler.setHasFixedSize(true);
       albumRecycler.setItemAnimator(new DefaultItemAnimator());
        AlbumAdapter albumAdapter = new AlbumAdapter(getActivity(),list);
        albumRecycler.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL,false));
       albumRecycler.setAdapter(albumAdapter);


        return view;
    }

   public List<Album> getAlbumList() {
      List<Album> list1 = new ArrayList<>();
       list1.add(new Album(1,"Album Name","jj","jj","Artist Name"));
       list1.add(new Album(2,"Excite","jdj","jdfj","Robus Gauli"));
        list1.add(new Album(3,"Burn","jdfj","jdfj","Rahul Gauli"));
        list1.add(new Album(4,"Go Home","jj","jj","Ed sheeran"));
       list1.add(new Album(3,"Burn","jdfj","jdfj","Rahul Gauli"));
       list1.add(new Album(4,"Go Home","jj","jj","Ed sheeran"));list1.add(new Album(3,"Burn","jdfj","jdfj","Rahul Gauli"));
       list1.add(new Album(4,"Go Home","jj","jj","Ed sheeran"));
       list1.add(new Album(3,"Burn","jdfj","jdfj","Rahul Gauli"));
       list1.add(new Album(4,"Go Home","jj","jj","Ed sheeran"));
       list1.add(new Album(3,"Burn","jdfj","jdfj","Rahul Gauli"));
       list1.add(new Album(4,"Go Home","jj","jj","Ed sheeran"));

        return list1;


    }


}
