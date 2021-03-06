package com.elegion.VectorGraphics;

import android.graphics.Canvas;
import android.os.Bundle;
import android.widget.ImageView;
import com.larvalabs.svgandroid.SVG;
import com.larvalabs.svgandroid.SVGBuilder;
import com.larvalabs.svgandroid.SVGParseException;

/**
 * Created by sone on 18.08.13.
 */
public class SvgAndroidFragment extends BaseFragment {

  @Override
  public void onActivityCreated(Bundle savedInstanceState) {
    super.onActivityCreated(savedInstanceState);
    getActivity().getActionBar().setTitle("svg-android");
    try {
      SVG svg = new SVGBuilder().readFromResource(getResources(), getSvgId()).build();
      ImageView imageView = new ImageView(getActivity()){
        @Override
        protected void onDraw(final Canvas canvas) {
          final long time = System.nanoTime();
          super.onDraw(canvas);
          reportDrawDuration(System.nanoTime() - time);
        }
      };
      imageView.setImageDrawable(svg.getDrawable());
      addViewToSvgArea(imageView);
    } catch (SVGParseException e) {
      e.printStackTrace();
      //SVG 1.1 not supported
    }
  }
}
