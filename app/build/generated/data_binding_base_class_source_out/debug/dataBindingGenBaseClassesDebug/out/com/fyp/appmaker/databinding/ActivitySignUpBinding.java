package com.fyp.appmaker.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import java.lang.Deprecated;
import java.lang.Object;

public abstract class ActivitySignUpBinding extends ViewDataBinding {
  @NonNull
  public final TextView agreeTV;

  @NonNull
  public final TextInputEditText confirmPassET;

  @NonNull
  public final TextInputLayout confirmPassLayout;

  @NonNull
  public final TextInputEditText emailET;

  @NonNull
  public final TextInputLayout emailLayout;

  @NonNull
  public final ProgressBar loadingBar;

  @NonNull
  public final TextInputEditText nameET;

  @NonNull
  public final TextInputLayout nameLayout;

  @NonNull
  public final TextInputLayout passLayout;

  @NonNull
  public final TextInputEditText passwordET;

  @NonNull
  public final MaterialButton signUpButton;

  @NonNull
  public final TextView textViewAppMaker;

  @NonNull
  public final TextView textViewHeader;

  @NonNull
  public final TextView tncTV;

  protected ActivitySignUpBinding(Object _bindingComponent, View _root, int _localFieldCount,
      TextView agreeTV, TextInputEditText confirmPassET, TextInputLayout confirmPassLayout,
      TextInputEditText emailET, TextInputLayout emailLayout, ProgressBar loadingBar,
      TextInputEditText nameET, TextInputLayout nameLayout, TextInputLayout passLayout,
      TextInputEditText passwordET, MaterialButton signUpButton, TextView textViewAppMaker,
      TextView textViewHeader, TextView tncTV) {
    super(_bindingComponent, _root, _localFieldCount);
    this.agreeTV = agreeTV;
    this.confirmPassET = confirmPassET;
    this.confirmPassLayout = confirmPassLayout;
    this.emailET = emailET;
    this.emailLayout = emailLayout;
    this.loadingBar = loadingBar;
    this.nameET = nameET;
    this.nameLayout = nameLayout;
    this.passLayout = passLayout;
    this.passwordET = passwordET;
    this.signUpButton = signUpButton;
    this.textViewAppMaker = textViewAppMaker;
    this.textViewHeader = textViewHeader;
    this.tncTV = tncTV;
  }

  @NonNull
  public static ActivitySignUpBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.activity_sign_up, root, attachToRoot, component)
   */
  @NonNull
  @Deprecated
  public static ActivitySignUpBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
    return ViewDataBinding.<ActivitySignUpBinding>inflateInternal(inflater, com.fyp.appmaker.R.layout.activity_sign_up, root, attachToRoot, component);
  }

  @NonNull
  public static ActivitySignUpBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.activity_sign_up, null, false, component)
   */
  @NonNull
  @Deprecated
  public static ActivitySignUpBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable Object component) {
    return ViewDataBinding.<ActivitySignUpBinding>inflateInternal(inflater, com.fyp.appmaker.R.layout.activity_sign_up, null, false, component);
  }

  public static ActivitySignUpBinding bind(@NonNull View view) {
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
  public static ActivitySignUpBinding bind(@NonNull View view, @Nullable Object component) {
    return (ActivitySignUpBinding)bind(component, view, com.fyp.appmaker.R.layout.activity_sign_up);
  }
}
