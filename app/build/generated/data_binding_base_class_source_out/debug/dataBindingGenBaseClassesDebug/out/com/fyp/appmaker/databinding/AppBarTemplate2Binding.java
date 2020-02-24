package com.fyp.appmaker.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.viewpager.widget.ViewPager;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.tabs.TabLayout;
import java.lang.Deprecated;
import java.lang.Object;

public abstract class AppBarTemplate2Binding extends ViewDataBinding {
  @NonNull
  public final AppBarLayout appbarLayout;

  @NonNull
  public final TabLayout tabLayout;

  @NonNull
  public final Toolbar toolbarTemplate2;

  @NonNull
  public final ViewPager viewPager;

  protected AppBarTemplate2Binding(Object _bindingComponent, View _root, int _localFieldCount,
      AppBarLayout appbarLayout, TabLayout tabLayout, Toolbar toolbarTemplate2,
      ViewPager viewPager) {
    super(_bindingComponent, _root, _localFieldCount);
    this.appbarLayout = appbarLayout;
    this.tabLayout = tabLayout;
    this.toolbarTemplate2 = toolbarTemplate2;
    this.viewPager = viewPager;
  }

  @NonNull
  public static AppBarTemplate2Binding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.app_bar_template2, root, attachToRoot, component)
   */
  @NonNull
  @Deprecated
  public static AppBarTemplate2Binding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
    return ViewDataBinding.<AppBarTemplate2Binding>inflateInternal(inflater, com.fyp.appmaker.R.layout.app_bar_template2, root, attachToRoot, component);
  }

  @NonNull
  public static AppBarTemplate2Binding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.app_bar_template2, null, false, component)
   */
  @NonNull
  @Deprecated
  public static AppBarTemplate2Binding inflate(@NonNull LayoutInflater inflater,
      @Nullable Object component) {
    return ViewDataBinding.<AppBarTemplate2Binding>inflateInternal(inflater, com.fyp.appmaker.R.layout.app_bar_template2, null, false, component);
  }

  public static AppBarTemplate2Binding bind(@NonNull View view) {
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
  public static AppBarTemplate2Binding bind(@NonNull View view, @Nullable Object component) {
    return (AppBarTemplate2Binding)bind(component, view, com.fyp.appmaker.R.layout.app_bar_template2);
  }
}
