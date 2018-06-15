package com.example.android.quakereport;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class EarthquakeAdapter extends ArrayAdapter<Earthquake> {

    public EarthquakeAdapter(@NonNull Context context, @NonNull List<Earthquake> objects) {
        super(context, 0, objects);
    }

    @SuppressLint({"SetTextI18n", "SimpleDateFormat"})
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listItem = convertView;

        if (listItem == null) {
            listItem = LayoutInflater.from(getContext()).inflate(R.layout.earthquake_list_item, parent, false);
        }

        Earthquake currentEarthquake = getItem(position);

        TextView magnitudeText = (TextView) listItem.findViewById(R.id.magnitude_text_view);

        DecimalFormat magnitudeFormatter = new DecimalFormat("0.0");

        GradientDrawable magnitudeCircle = (GradientDrawable) magnitudeText.getBackground();

        magnitudeText.setText(magnitudeFormatter.format(currentEarthquake.getMagnitude()));

        magnitudeCircle.setColor(getMagColor(currentEarthquake.getMagnitude()));

        TextView cityText = (TextView) listItem.findViewById(R.id.city_text_view);

        TextView locationText = (TextView) listItem.findViewById(R.id.location_text_view);

        String splitLocation = currentEarthquake.getCity();

        if (splitLocation.contains("of")) {
            String[] parts = splitLocation.split(" of ");
            cityText.setText(parts[0] + " of");
            locationText.setText(parts[1]);
        } else {
            cityText.setText("Near the");
            locationText.setText(splitLocation);
        }

        TextView dateText = (TextView) listItem.findViewById(R.id.date_text_view);
        Date dateObject = new Date(currentEarthquake.getDate());

        @SuppressLint("SimpleDateFormat")
        SimpleDateFormat dateFormatter = new SimpleDateFormat("MMM D, yyyy");
        String dateToDisplay = dateFormatter.format(dateObject);
        dateText.setText(dateToDisplay);

        dateFormatter = new SimpleDateFormat("h:mm a");
        TextView timeText = (TextView) listItem.findViewById(R.id.time_text_view);
        timeText.setText(dateFormatter.format(dateObject));

        return listItem;
    }

    private int getMagColor(double magnitude) {

        if (magnitude > 0 && magnitude < 2)
            return ContextCompat.getColor(getContext(), R.color.magnitude1);
        else if (magnitude >= 2 && magnitude < 3)
            return ContextCompat.getColor(getContext(), R.color.magnitude2);
        else if (magnitude >= 3 && magnitude < 4)
            return ContextCompat.getColor(getContext(), R.color.magnitude3);
        else if (magnitude >= 4 && magnitude < 5)
            return ContextCompat.getColor(getContext(), R.color.magnitude4);
        else if (magnitude >= 5 && magnitude < 6)
            return ContextCompat.getColor(getContext(), R.color.magnitude5);
        else if (magnitude >= 6 && magnitude < 7)
            return ContextCompat.getColor(getContext(), R.color.magnitude6);
        else if (magnitude >= 7 && magnitude < 8)
            return ContextCompat.getColor(getContext(), R.color.magnitude7);
        else if (magnitude >= 8 && magnitude < 9)
            return ContextCompat.getColor(getContext(), R.color.magnitude8);
        else if (magnitude >= 9 && magnitude < 10)
            return ContextCompat.getColor(getContext(), R.color.magnitude9);
        else if (magnitude >= 10)
            return ContextCompat.getColor(getContext(), R.color.magnitude10plus);
        else
            return ContextCompat.getColor(getContext(), R.color.magnitude10plus);
    }
}