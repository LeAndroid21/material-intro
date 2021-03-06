package com.heinrichreimersoftware.materialintro.view.parallax;

import android.os.Bundle;
import android.support.annotation.FloatRange;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;

import com.heinrichreimersoftware.materialintro.app.SlideFragment;
import com.heinrichreimersoftware.materialintro.view.parallax.util.ParallaxUtil;

import java.util.ArrayList;
import java.util.List;


public class ParallaxSlideFragment extends SlideFragment implements Parallaxable {

    private final List<Parallaxable> parallaxableChildren = new ArrayList<>();

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        parallaxableChildren.addAll(ParallaxUtil.findParallaxableChildren(view));
    }


    @Override
    public void setOffset(@FloatRange(from = -1.0, to = 1.0) float offset) {
        ParallaxUtil.setOffsetToParallaxableList(parallaxableChildren, offset);
    }
}
