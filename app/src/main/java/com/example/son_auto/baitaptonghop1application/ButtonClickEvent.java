package com.example.son_auto.baitaptonghop1application;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v4.content.ContextCompat;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by Son-Auto on 2/15/2018.
 */

public class ButtonClickEvent implements View.OnClickListener {

    private Context context;

    ButtonClickEvent(Context context) {
        this.context = context;
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.buttonShow) {

            //cho button hien
            Button b = new Button(context);
            b.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
            b.setId(R.id.button_hien);
            b.setText(context.getResources().getResourceEntryName(R.id.button_hien) + "");
            b.setTextColor(ContextCompat.getColor(context, R.color.colorAccent));
            b.setBackgroundResource(context.getResources().getIdentifier("pic2", "drawable", context.getPackageName()));

            LinearLayout ln1 = (LinearLayout) ((Activity) context).findViewById(R.id.layout_item);
            if (ln1.getChildCount() < 3) //để khi nhấn button Show lần nữa thì nó không tạo thêm button
                ln1.addView(b);

            //cho textView
            TextView tv1 = (TextView) ((Activity) context).findViewById(R.id.textView1);
            tv1.setText(context.getResources().getString(R.string.textview2) + "");

            //cho imageView
            ArrayList<String> listPics = new ArrayList<>();
            listPics.add("pic1");
            listPics.add("pic2");
            listPics.add("pic3");
            Random r = new Random();
            ImageView imgv = (ImageView) ((Activity) context).findViewById(R.id.imageView1);
            imgv.setImageResource(context.getResources().getIdentifier(listPics.get(r.nextInt(3)), "drawable", context.getPackageName()));
        } else if (v.getId() == R.id.popup1) {
            PopupMenu popupMenu = new PopupMenu(context, v);
            popupMenu.getMenuInflater().inflate(R.menu.menu_main, popupMenu.getMenu());
            popupMenu.show();
        } else if (v.getId() == R.id.customdialog_activity1) {
            Intent i = new Intent(context, DialogActivity.class);
            context.startActivity(i);
        } else if (v.getId() == R.id.alertdialog1) {

            AlertDialog.Builder builder = new AlertDialog.Builder(context);
            builder.setTitle("Thông Báo");
            builder.setMessage("Có muốn thoát không");
            builder.setIcon(context.getResources().getIdentifier("pic1", "drawable", context.getPackageName()));
            builder.setPositiveButton("Có", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    ((Activity) context).finish();
                }
            });
            builder.setNegativeButton("Không", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                }
            });
            AlertDialog dialog = builder.create();
            dialog.show();

        }
    }

}
