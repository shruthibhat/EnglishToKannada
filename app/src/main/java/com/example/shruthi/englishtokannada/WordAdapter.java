package com.example.shruthi.englishtokannada;


import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by shruthi on 4/21/17.
 */

/**
 * This is our own custom constructor (it doesn't mirror a superclass constructor).
 * The context is used to inflate the layout file, and the list is the data we want
 * to populate into the lists.
 *
 * @param context        The current context. Used to inflate the layout file.
 * @param sampleWords    A List of Word objects to display in a list
 */

public class WordAdapter extends ArrayAdapter<Word> {
    private int mColorResourceId;

    public WordAdapter(Activity context, ArrayList<Word> sampleWords,int ColorResourceId)
    {
        // Here, we initialize the ArrayAdapter's internal storage for the context and the list.
        // the second argument is used when the ArrayAdapter is populating a single TextView.
        // Because this is a custom adapter for two TextViews, the adapter is not
        // going to use this second argument, so it can be any value. Here, we used 0.
        super(context, 0, sampleWords);
        mColorResourceId=ColorResourceId;
    }

/**
 * Provides a view for an AdapterView (ListView, GridView, etc.)
 *
 * @param position The position in the list of data that should be displayed in the
 *                 list item view.
 * @param convertView The recycled view to populate.
 * @param parent The parent ViewGroup that is used for inflation.
 * @return The View for the position in the AdapterView.
 */

@Override
public View getView(int position,  View convertView,  ViewGroup parent) {

    View listItemView=convertView;

    // Check if the existing view is being reused, otherwise inflate the view
    if(listItemView == null)
    {
        listItemView= LayoutInflater.from(getContext()).inflate(R.layout.list_item,parent,false);

    }

    Word currentWord= getItem(position);

    //Find the ImageView in the list_item.xml layout with the ID image
    ImageView imageView= (ImageView)listItemView.findViewById(R.id.image);
    // Get the image resource ID from the current currentWord object and
    // set the image to iconView
   // imageView.setImageResource(currentWord.getmImageResourceId());

    // Check if an image is provided for this word or not
    if (currentWord.hasImage()) {
        // If an image is available, display the provided image based on the resource ID
        imageView.setImageResource(currentWord.getmImageResourceId());
        // Make sure the view is visible
        imageView.setVisibility(View.VISIBLE);
    } else {
        // Otherwise hide the ImageView (set visibility to GONE)
        imageView.setVisibility(View.GONE);
    }

    //Get the id of english integer name from the list_item.xml and assign it to defaultTextView so that it can be populated
    TextView defaultTextView =  (TextView)listItemView.findViewById(R.id.default_text_view);

    //Get the current English Integer name from the adapter and set this text on the defaultTextView
    defaultTextView.setText(currentWord.getmDefaultTranslation());


    //similarly for the kannada word
    TextView kannadaTextView =(TextView) listItemView.findViewById(R.id.kannada_text_view);

    kannadaTextView.setText(currentWord.getmKannadaTranslation());


    // Set the theme color for the list item
    View textContainer = listItemView.findViewById(R.id.text_container);
    // Find the color that the resource ID maps to
    int color = ContextCompat.getColor(getContext(), mColorResourceId);
    // Set the background color of the text container View
    textContainer.setBackgroundColor(color);


    //return the whole list item layout (containing 2 textviews) so that it can be shown in the list view.
    return listItemView;

}





}



