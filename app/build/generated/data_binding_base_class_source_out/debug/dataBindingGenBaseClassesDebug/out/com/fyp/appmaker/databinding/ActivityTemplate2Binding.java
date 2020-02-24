package com.fyp.appmaker.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.drawerlayout.widget.DrawerLayout;
import com.google.android.material.navigation.NavigationView;
import java.lang.Deprecated;
import java.lang.Object;

public abstract class ActivityTemplate2Binding extends ViewDataBinding {
  @NonNull
  public final DrawerLayout template2Drawer;

  @NonNull
  public final NavigationView template2NavigationDrawer;

  protected ActivityTemplate2Binding(Object _bindingComponent, View _root, int _localFieldCount,
      DrawerLayout template2Drawer, NavigationView template2NavigationDrawer) {
    super(_bindingComponent, _root, _localFieldCount);
    this.template2Drawer = template2Drawer;
    this.template2NavigationDrawer = template2NavigationDrawer;
  }

  @NonNull
  public static ActivityTemplate2Binding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.activity_template2, root, attachToRoot, component)
   */
  @NonNull
  @Deprecated
  public static ActivityTemplate2Binding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
    return ViewDataBinding.<ActivityTemplate2Binding>inflateInternal(inflater, com.fyp.appmaker.R.layout.activity_template2, root, attachToRoot, component);
  }

  @NonNull
  public static ActivityTemplate2Binding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.activity_template2, null, false, component)
   */
  @NonNull
  @Deprecated
  public static ActivityTemplate2Binding inflate(@NonNull LayoutInflater inflater,
      @Nullable Object component) {
    return ViewDataBinding.<ActivityTemplate2Binding>inflateInternal(inflater, com.fyp.appmaker.R.layout.activity_template2, null, false, component);
  }

  public static ActivityTemplate2Binding bind(@NonNull View view) {
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
  public static ActivityTemplate2Binding bind(@NonNull View view, @Nullable Object component) {
    return (ActivityTemplate2Binding)bind(component, view, com.fyp.appmaker.R.layout.activity_template2);
  }
}
