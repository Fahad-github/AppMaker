package com.fyp.appmaker.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import java.lang.Deprecated;
import java.lang.Object;

public abstract class FragmentTemplate2Binding extends ViewDataBinding {
  @NonNull
  public final ImageView colorEditor;

  @NonNull
  public final FloatingActionButton createApkButton;

  @NonNull
  public final ConstraintLayout parentConstraint;

  @NonNull
  public final TextView productsTextView;

  @NonNull
  public final FrameLayout progressBarHolder;

  @NonNull
  public final RecyclerView template2Recycler;

  protected FragmentTemplate2Binding(Object _bindingComponent, View _root, int _localFieldCount,
      ImageView colorEditor, FloatingActionButton createApkButton,
      ConstraintLayout parentConstraint, TextView productsTextView, FrameLayout progressBarHolder,
      RecyclerView template2Recycler) {
    super(_bindingComponent, _root, _localFieldCount);
    this.colorEditor = colorEditor;
    this.createApkButton = createApkButton;
    this.parentConstraint = parentConstraint;
    this.productsTextView = productsTextView;
    this.progressBarHolder = progressBarHolder;
    this.template2Recycler = template2Recycler;
  }

  @NonNull
  public static FragmentTemplate2Binding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.fragment_template2, root, attachToRoot, component)
   */
  @NonNull
  @Deprecated
  public static FragmentTemplate2Binding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
    return ViewDataBinding.<FragmentTemplate2Binding>inflateInternal(inflater, com.fyp.appmaker.R.layout.fragment_template2, root, attachToRoot, component);
  }

  @NonNull
  public static FragmentTemplate2Binding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.fragment_template2, null, false, component)
   */
  @NonNull
  @Deprecated
  public static FragmentTemplate2Binding inflate(@NonNull LayoutInflater inflater,
      @Nullable Object component) {
    return ViewDataBinding.<FragmentTemplate2Binding>inflateInternal(inflater, com.fyp.appmaker.R.layout.fragment_template2, null, false, component);
  }

  public static FragmentTemplate2Binding bind(@NonNull View view) {
    return bind(view, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.bind(view, component)
   */
  @Deprecated
  public static FragmentTemplate2Binding bind(@NonNull View view, @Nullable Object component) {
    return (FragmentTemplate2Binding)bind(component, view, com.fyp.appmaker.R.layout.fragment_template2);
  }
}
