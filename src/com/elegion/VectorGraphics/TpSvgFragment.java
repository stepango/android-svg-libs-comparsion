package com.elegion.VectorGraphics;

import android.graphics.Canvas;
import android.os.Bundle;
import com.trevorpage.tpsvg.SVGFlyweightFactory;
import com.trevorpage.tpsvg.SVGParserRenderer;
import com.trevorpage.tpsvg.SVGView;

/**
 * Created by sone on 18.08.13.
 */
public class TpSvgFragment extends BaseFragment {

  @Override
  public void onActivityCreated(Bundle savedInstanceState) {
    super.onActivityCreated(savedInstanceState);
    getActivity().getActionBar().setTitle("TPSVG");
    SVGView svgView = new SVGView(getActivity()){
      @Override
      protected void onDraw(final Canvas canvas) {
        final long time = System.nanoTime();
        super.onDraw(canvas);
        reportDrawDuration(System.nanoTime() - time);
      }
    };
    SVGParserRenderer svgParserRenderer = SVGFlyweightFactory.getInstance().get(getSvgId(), getActivity());
    svgView.setSVGRenderer(svgParserRenderer, null);
    addViewToSvgArea(svgView);
  }

}
