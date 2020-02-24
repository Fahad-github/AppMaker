package com.fyp.appmaker.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import java.lang.Deprecated;
import java.lang.Object;

public abstract class FragmentTemplate2Binding extends ViewDataBinding {
  @NonNull
  public final ImageView image1;

  @NonNull
  public final ImageView image2;

  @NonNull
  public final ImageView image3;

  @NonNull
  public final ImageView image4;

  @NonNull
  public final RelativeLayout number1;

  @NonNull
  public final RelativeLayout number2;

  @NonNull
  public final RelativeLayout number3;

  @NonNull
  public final RelativeLayout number4;

  @NonNull
  public final TextView productName1;

  @NonNull
  public final TextView productName2;

  @NonNull
  public final TextView productName3;

  @NonNull
  public final TextView productName4;

  @NonNull
  public final TextView productPrice1;

  @NonNull
  public final TextView productPrice2;

  @NonNull
  public final TextView productPrice3;

  @NonNull
  public final TextView productPrice4;

  protected FragmentTemplate2Binding(Object _bindingComponent, View _root, int _localFieldCount,
      ImageView image1, ImageView image2, ImageView image3, ImageView image4,
      RelativeLayout number1, RelativeLayout number2, RelativeLayout number3,
      RelativeLayout number4, TextView productName1, TextView productName2, TextView productName3,
      TextView productName4, TextView productPrice1, TextView productPrice2, TextView productPrice3,
      TextView productPrice4) {
    super(_bindingComponent, _root, _localFieldCount);
    this.image1 = image1;
    this.image2 = image2;
    this.image3 = image3;
    this.image4 = image4;
    this.number1 = number1;
    this.number2 = number2;
    this.number3 = number3;
    this.number4 = number4;
    this.productName1 = productName1;
    this.productName2 = productName2;
    this.productName3 = productName3;
    this.productName4 = productName4;
    this.productPrice1 = productPrice1;
    this.productPrice2 = productPrice2;
    this.productPrice3 = productPrice3;
    this.productPrice4 = productPrice4;
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
