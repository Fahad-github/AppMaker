package com.fyp.appmaker.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.Spinner;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import java.lang.Deprecated;
import java.lang.Object;

public abstract class ChooseSplashAnimDialogBinding extends ViewDataBinding {
  @NonNull
  public final CheckBox addLogoInSplash;

  @NonNull
  public final CheckBox addNameInSplash;

  @NonNull
  public final Spinner animTypeSpinner;

  protected ChooseSplashAnimDialogBinding(Object _bindingComponent, View _root,
      int _localFieldCount, CheckBox addLogoInSplash, CheckBox addNameInSplash,
      Spinner animTypeSpinner) {
    super(_bindingComponent, _root, _localFieldCount);
    this.addLogoInSplash = addLogoInSplash;
    this.addNameInSplash = addNameInSplash;
    this.animTypeSpinner = animTypeSpinner;
  }

  @NonNull
  public static ChooseSplashAnimDialogBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.choose_splash_anim_dialog, root, attachToRoot, component)
   */
  @NonNull
  @Deprecated
  public static ChooseSplashAnimDialogBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
    return ViewDataBinding.<ChooseSplashAnimDialogBinding>inflateInternal(inflater, com.fyp.appmaker.R.layout.choose_splash_anim_dialog, root, attachToRoot, component);
  }

  @NonNull
  public static ChooseSplashAnimDialogBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.choose_splash_anim_dialog, null, false, component)
   */
  @NonNull
  @Deprecated
  public static ChooseSplashAnimDialogBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable Object component) {
    return ViewDataBinding.<ChooseSplashAnimDialogBinding>inflateInternal(inflater, com.fyp.appmaker.R.layout.choose_splash_anim_dialog, null, false, component);
  }

  public static ChooseSplashAnimDialogBinding bind(@NonNull View view) {
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
  public static ChooseSplashAnimDialogBinding bind(@NonNull View view, @Nullable Object component) {
    return (ChooseSplashAnimDialogBinding)bind(component, view, com.fyp.appmaker.R.layout.choose_splash_anim_dialog);
  }
}
