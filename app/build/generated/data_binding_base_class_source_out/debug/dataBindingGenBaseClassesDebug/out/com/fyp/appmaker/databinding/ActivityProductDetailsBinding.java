package com.fyp.appmaker.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import java.lang.Deprecated;
import java.lang.Object;

public abstract class ActivityProductDetailsBinding extends ViewDataBinding {
  @NonNull
  public final AppCompatImageView addToCartButton;

  @NonNull
  public final ImageView backButton;

  @NonNull
  public final Button buyNowButton;

  @NonNull
  public final Button extraLarge;

  @NonNull
  public final RelativeLayout footer;

  @NonNull
  public final ImageView heartImage;

  @NonNull
  public final Button large;

  @NonNull
  public final Button medium;

  @NonNull
  public final TextView productDescription;

  @NonNull
  public final ImageView productImage;

  @NonNull
  public final TextView productName;

  @NonNull
  public final TextView productPrice;

  @NonNull
  public final RatingBar ratingBar;

  @NonNull
  public final RelativeLayout relativeLayout;

  @NonNull
  public final RelativeLayout sizesLayout;

  @NonNull
  public final Button small;

  protected ActivityProductDetailsBinding(Object _bindingComponent, View _root,
      int _localFieldCount, AppCompatImageView addToCartButton, ImageView backButton,
      Button buyNowButton, Button extraLarge, RelativeLayout footer, ImageView heartImage,
      Button large, Button medium, TextView productDescription, ImageView productImage,
      TextView productName, TextView productPrice, RatingBar ratingBar,
      RelativeLayout relativeLayout, RelativeLayout sizesLayout, Button small) {
    super(_bindingComponent, _root, _localFieldCount);
    this.addToCartButton = addToCartButton;
    this.backButton = backButton;
    this.buyNowButton = buyNowButton;
    this.extraLarge = extraLarge;
    this.footer = footer;
    this.heartImage = heartImage;
    this.large = large;
    this.medium = medium;
    this.productDescription = productDescription;
    this.productImage = productImage;
    this.productName = productName;
    this.productPrice = productPrice;
    this.ratingBar = ratingBar;
    this.relativeLayout = relativeLayout;
    this.sizesLayout = sizesLayout;
    this.small = small;
  }

  @NonNull
  public static ActivityProductDetailsBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.activity_product_details, root, attachToRoot, component)
   */
  @NonNull
  @Deprecated
  public static ActivityProductDetailsBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
    return ViewDataBinding.<ActivityProductDetailsBinding>inflateInternal(inflater, com.fyp.appmaker.R.layout.activity_product_details, root, attachToRoot, component);
  }

  @NonNull
  public static ActivityProductDetailsBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.activity_product_details, null, false, component)
   */
  @NonNull
  @Deprecated
  public static ActivityProductDetailsBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable Object component) {
    return ViewDataBinding.<ActivityProductDetailsBinding>inflateInternal(inflater, com.fyp.appmaker.R.layout.activity_product_details, null, false, component);
  }

  public static ActivityProductDetailsBinding bind(@NonNull View view) {
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
  public static ActivityProductDetailsBinding bind(@NonNull View view, @Nullable Object component) {
    return (ActivityProductDetailsBinding)bind(component, view, com.fyp.appmaker.R.layout.activity_product_details);
  }
}
