package com.example.android.quakereport;

import android.content.Context;
import android.nfc.TagLostException;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class EarthquakeAdapter extends ArrayAdapter<Earthquake> {
    public EarthquakeAdapter(Context context,List<Earthquake> earthquakes)
    {
        super(context,0,earthquakes);
    }

    @NonNull
    @Override
    public View getView(int position,  View convertView,  ViewGroup parent) {
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.earthquake_list_item, parent,false);
        }

        Earthquake currentEarthquake = getItem(position);

        TextView magnitudeView = (TextView) listItemView.findViewById(R.id.magnitude);

        magnitudeView.setText(formatMagnitude(currentEarthquake.getMagnitude()));

        String fullLocation = currentEarthquake.getLocation();

        String[] parts = formatLocation(fullLocation);



        TextView directionView = (TextView) listItemView.findViewById(R.id.direction);

        directionView.setText(parts[0]);

        TextView locationView = (TextView) listItemView.findViewById(R.id.location);

        locationView.setText(parts[1]);

        TextView dateView = (TextView) listItemView.findViewById(R.id.date);

        dateView.setText(formatDate(new Date(currentEarthquake.getTime())));

        TextView timeView = (TextView) listItemView.findViewById(R.id.time);

        timeView.setText(formatTime(new Date(currentEarthquake.getTime())));
        return listItemView;
    }
    /**
     * Return the formatted date string (i.e. "Mar 3, 1984") from a Date object.
     */
    private String formatDate(Date dateObject) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("LLL dd, yyyy");
        return dateFormat.format(dateObject);
    }

    /**
     * Return the formatted date string (i.e. "4:30 PM") from a Date object.
     */
    private String formatTime(Date dateObject) {
        SimpleDateFormat timeFormat = new SimpleDateFormat("h:mm a");
        return timeFormat.format(dateObject);
    }

    private String[] formatLocation(String location)
    {
        String[] x;
        if (location.contains("of"))
        {
            x = location.split("of");
            x[0] += " of";
            return x;

        }
        x = new String[]{"Near the", location};
        return x;
    }

    private String formatMagnitude(double magnitude)
    {
        DecimalFormat magnitudeFormat = new DecimalFormat("0.0");
        return magnitudeFormat.format(magnitude);
    }
}
