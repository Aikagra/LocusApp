package com.example.geek_a_heartzproject;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.shashank.sony.fancytoastlib.FancyToast;
import com.smarteist.autoimageslider.SliderViewAdapter;

import org.w3c.dom.Text;

public class SliderAdapter extends SliderViewAdapter<SliderAdapter.SliderViewHolder> {

    private int[] images;
    private String[] text;

    public SliderAdapter(int[] images, String[] text) {
        this.images = images;
        this.text = text;
    }

    @Override
    public SliderViewHolder onCreateViewHolder(ViewGroup parent) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.slider_item_layout, null);
        return new SliderViewHolder(view);
    }

    @Override
    public void onBindViewHolder(SliderViewHolder viewHolder, int position) {
        viewHolder.imageView.setImageResource(images[position]);
        viewHolder.textView.setText(text[position]);
       // viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
         //   @Override
         //   public void onClick(View view) {
                //imp
         //   }
        //});

    }

    @Override
    public int getCount() {
        return images.length;
    }

    public class SliderViewHolder extends SliderViewAdapter.ViewHolder {

        private ImageView imageView;
        private TextView textView;

        public SliderViewHolder(View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.image);
            textView = itemView.findViewById(R.id.textDescription);
        }
    }
}
