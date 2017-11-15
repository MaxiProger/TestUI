package com.example.max.testui.adapter;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.provider.ContactsContract;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.max.testui.R;
import com.example.max.testui.roundedImageView.RoundedImageView;

/**
 * Created by max on 11/8/17.
 */

public class myAdapter extends BaseAdapter {

    Cursor cursor;
    Context myContext;
    LayoutInflater inflater;

    public myAdapter(Context context, Cursor cursor) {
        myContext = context;
        this.cursor = cursor;
        inflater = (LayoutInflater) myContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return cursor.getCount();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int i, View convertView, ViewGroup viewGroup) {

        View view = convertView;
        Holder holder;
        cursor.moveToPosition(i);

        if (view == null) {
            view = inflater.inflate(R.layout.content_element, null, false);


            holder = new Holder();
            holder.contactName = (TextView) view.findViewById(R.id.name);
            holder.contactNumber = (TextView) view.findViewById(R.id.number);
            holder.contactImage = (RoundedImageView) view.findViewById(R.id.image);

            view.setTag(holder);
        } else {
            holder = (Holder) view.getTag();
        }
        holder.contactImage.setImageURI(null);
        holder.contactName.setText(cursor.getString(cursor.getColumnIndex(
                ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME)));
        holder.contactNumber.setText(cursor.getString(cursor.getColumnIndex(
                ContactsContract.CommonDataKinds.Phone.NUMBER)));
        String imageUri = cursor.getString(cursor.getColumnIndex(
                ContactsContract.CommonDataKinds.Phone.PHOTO_URI));

        if (imageUri != null) {
            holder.contactImage.setImageURI(Uri.parse(imageUri));

        } else if (imageUri == null)
            holder.contactImage.setImageResource(R.drawable.contact_in_person);

        return view;
    }


    class Holder {
        TextView contactName, contactNumber;
        RoundedImageView contactImage, image;
    }

}
