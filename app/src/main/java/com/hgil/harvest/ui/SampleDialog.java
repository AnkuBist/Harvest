package com.hgil.harvest.ui;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.hgil.harvest.R;

/**
 * Created by mohan.giri on 04-01-2017.
 */

public class SampleDialog extends AlertDialog {

    private Context mContext;

    protected SampleDialog(Context context) {
        super(context);
        mContext = context;
    }

    public void showDialog(Context context) {
        // Create custom dialog object
        final Dialog dialog = new Dialog(mContext);
        dialog.setCancelable(true);
        dialog.setCanceledOnTouchOutside(true);
        // Include dialog.xml file
        dialog.setContentView(R.layout.row_layout);
        // Set dialog title
        dialog.setTitle("Custom Dialog");

        // set values for custom dialog components - text, image and button
        TextView text = (TextView) dialog.findViewById(R.id.firstLine);
        text.setText("Custom dialog Android example.");
        ImageView image = (ImageView) dialog.findViewById(R.id.icon);
        image.setImageResource(R.mipmap.ic_launcher);

        dialog.show();

      /*  Button declineButton = (Button) dialog.findViewById(R.id.declineButton);
        // if decline button is clicked, close the custom dialog
        declineButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Close dialog
                dialog.dismiss();
            }
        });*/


    }
}