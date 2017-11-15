package com.example.max.testui.fragments;


import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.v4.app.Fragment;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.CursorLoader;
import android.support.v4.content.Loader;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.max.testui.R;
import com.example.max.testui.adapter.myAdapter;


/**
 * A simple {@link Fragment} subclass.
 */
public class BlankFragment extends Fragment implements LoaderManager.LoaderCallbacks<Cursor> {


    public BlankFragment() {
        // Required empty public constructor
    }

    public ListView listView;
    private myAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_blank, container, false);
        listView = (ListView) rootView.findViewById(R.id.listContacts);
        getLoaderManager().initLoader(0, null, this);
        return rootView;
    }



    @Override
    public Loader<Cursor> onCreateLoader(int id, Bundle args) {
        Uri CONTACT_URI = ContactsContract.CommonDataKinds.Phone.CONTENT_URI;

        return new CursorLoader(
                getContext(), CONTACT_URI, null,
                null,null, null);
    }

    @Override
    public void onLoadFinished(Loader<Cursor> loader, Cursor data) {
        data.moveToFirst();
        adapter = new myAdapter(getContext(), data);
        listView.setAdapter(adapter);
    }

    @Override
    public void onLoaderReset(Loader<Cursor> loader) {

    }
}
