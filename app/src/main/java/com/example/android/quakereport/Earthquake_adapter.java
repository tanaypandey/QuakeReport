package com.example.android.quakereport;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.SimpleTimeZone;

public class Earthquake_adapter extends ArrayAdapter<Earthquake> {

    public Earthquake_adapter(Context context, ArrayList<Earthquake> words) {
        super(context, 0, words);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        // Check if an existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }
        // Get the {@link Word} object located at this position in the list
        Earthquake currentWord = getItem(position);

        TextView magnitudeTV = (TextView) listItemView.findViewById(R.id.magnitude);
        DecimalFormat decimalFormat = new DecimalFormat("0.00");

        String magnitude = decimalFormat.format(currentWord.getMagnitudeId());

        magnitudeTV.setText(magnitude);

        // Set the proper background color on the magnitude circle.
        // Fetch the background from the TextView, which is a GradientDrawable.
        GradientDrawable magnitudeCircle = (GradientDrawable) magnitudeTV.getBackground();

        // Get the appropriate background color based on the current earthquake magnitude
        int magnitudeColor = getMagnitudeColor(currentWord.getMagnitudeId());
        int magColor= ContextCompat.getColor(getContext(), magnitudeColor);
        // Set the color on the magnitude circle
        magnitudeCircle.setColor(magColor);

        //fins the text view with id "place"
        TextView placeTV = (TextView) listItemView.findViewById(R.id.place);

        //declaration of the offSet
        TextView offSetTV = (TextView) listItemView.findViewById(R.id.offset);

        //declaring the loation variabl enad getting the place from earthwuake class
        String location = currentWord.getPlaceId();
        //declaring rh initial avlure of the ffSEt that is near the
        String offSet = "Near the";
        //declaring initial value of place (but it is not changed)
        String place = "Here";
        //finding the location of "of"
        int index = location.indexOf("of");
        //writing if statement so if the offset is not present the initioa;l offset shoul dbe displayed
        if (location.contains("of")) {
            //changing he offset by divinding hte string at the location of "of"
            offSet = location.substring(0, index+2);
            place = location.substring(index+2, location.length());

        }
        else {
            //setting the value of the main place by making it into a substring startig at thr index positon after"of"
            place = location.substring(index + 1, location.length());
        }
        //setting the values of place nas offset to the respective text views
        placeTV.setText(place);
        offSetTV.setText(offSet);
        //create a date object
        Date dateObject = new Date(currentWord.getDateId());

        // Find the ImageView in the list_item.xml layout with the ID image.
        TextView date = (TextView) listItemView.findViewById(R.id.date);
        SimpleDateFormat dateFormatter = new SimpleDateFormat("MMM DD, yyyy");
        String dateToDisplay = dateFormatter.format(dateObject);
        date.setText(dateToDisplay);

       //textview to display time
        TextView time = (TextView) listItemView.findViewById(R.id.time);
        SimpleDateFormat timeFormat = new SimpleDateFormat("h:mm a");
        String timeToDisplay = timeFormat.format(dateObject);
        time.setText(timeToDisplay);
        return listItemView;
    }

    int getMagnitudeColor(double mag){
        if(mag>10){
            return R.color.magnitude10plus;
        }
        else if(mag>9){
            return R.color.magnitude9;
        }
        else if(mag>8){
            return R.color.magnitude8;
        }
        else if(mag>7){
            return R.color.magnitude7;
        }
        else if(mag>6){
            return R.color.magnitude6;
        }
        else if(mag>5){
            return R.color.magnitude5;
        }
        else if(mag>4){
            return R.color.magnitude4;
        }
        else if(mag>3){
            return R.color.magnitude3;
        }
        else if(mag>2){
            return R.color.magnitude2;
        }
        else {
            return R.color.magnitude1;
        }
    }
}
