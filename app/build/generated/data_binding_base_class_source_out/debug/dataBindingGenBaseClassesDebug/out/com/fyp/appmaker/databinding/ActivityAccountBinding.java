package com.fyp.appmaker.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import java.lang.Deprecated;
import java.lang.Object;

public abstract class ActivityAccountBinding extends ViewDataBinding {
  @NonNull
  public final RecyclerView appViewRecycler;

  @NonNull
  public final ImageView backButton;

  @NonNull
  public final ProgressBar loadingBar;

  @NonNull
  public final SwipeRefreshLayout refreshLayout;

  @NonNull
  public final RelativeLayout relativeInfo;

  @NonNull
  public final RelativeLayout relativeLayout;

  @NonNull
  public final TextView textViewAppCreated;

  @NonNull
  public final TextView textViewCreatorName;

  @NonNull
  public final TextView textViewKey;

  @NonNull
  public final TextView textViewUserKey;

  protected ActivityAccountBinding(Object _bindingComponent, View _root, int _localFieldCount,
      RecyclerView appViewRecycler, ImageView backButton, ProgressBar loadingBar,
      SwipeRefreshLayout refreshLayout, RelativeLayout relativeInfo, RelativeLayout relativeLayout,
      TextView textViewAppCreated, TextView textViewCreatorName, TextView textViewKey,
      TextView textViewUserKey) {
    super(_bindingComponent, _root, _localFieldCount);
    this.appViewRecycler = appViewRecycler;
    this.backButton = backButton;
    this.loadingBar = loadingBar;
    this.refreshLayout = refreshLayout;
    this.relativeInfo = relativeInfo;
    this.relativeLayout = relativeLayout;
    this.textViewAppCreated = textViewAppCreated;
    this.textViewCreatorName = textViewCreatorName;
    this.textViewKey = textViewKey;
    this.textViewUserKey = textViewUserKey;
  }

  @NonNull
  public static ActivityAccountBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.activity_account, root, attachToRoot, component)
   */
  @NonNull
  @Deprecated
  public static ActivityAccountBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
    return ViewDataBinding.<ActivityAccountBinding>inflateInternal(inflater, com.fyp.appmaker.R.layout.activity_account, root, attachToRoot, component);
  }

  @NonNull
  public static ActivityAccountBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.activity_account, null, false, component)
   */
  @NonNull
  @Deprecated
  public static ActivityAccountBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable Object component) {
    return ViewDataBinding.<ActivityAccountBinding>inflateInternal(inflater, com.fyp.appmaker.R.layout.activity_account, null, false, component);
  }

  public static ActivityAccountBinding bind(@NonNull View view) {
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
  public static ActivityAccountBinding bind(@NonNull View view, @Nullable Object component) {
    return (ActivityAccountBinding)bind(component, view, com.fyp.appmaker.R.layout.activity_account);
  }
}
