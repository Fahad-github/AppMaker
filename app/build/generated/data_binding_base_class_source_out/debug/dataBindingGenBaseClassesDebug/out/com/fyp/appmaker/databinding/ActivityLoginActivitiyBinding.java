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
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import java.lang.Deprecated;
import java.lang.Object;

public abstract class ActivityLoginActivitiyBinding extends ViewDataBinding {
  @NonNull
  public final ImageView appLogo;

  @NonNull
  public final MaterialButton createAccountButton;

  @NonNull
  public final TextInputEditText emailEditText;

  @NonNull
  public final TextInputLayout emailLayout;

  @NonNull
  public final ProgressBar loadingBar;

  @NonNull
  public final MaterialButton loginButton;

  @NonNull
  public final RelativeLayout mainRelative;

  @NonNull
  public final TextView orTextView;

  @NonNull
  public final TextInputEditText passwordEditText;

  @NonNull
  public final TextInputLayout passwordLayout;

  @NonNull
  public final TextView textViewAppMaker;

  @NonNull
  public final View view1;

  @NonNull
  public final View view2;

  @NonNull
  public final RelativeLayout viewRelative;

  protected ActivityLoginActivitiyBinding(Object _bindingComponent, View _root,
      int _localFieldCount, ImageView appLogo, MaterialButton createAccountButton,
      TextInputEditText emailEditText, TextInputLayout emailLayout, ProgressBar loadingBar,
      MaterialButton loginButton, RelativeLayout mainRelative, TextView orTextView,
      TextInputEditText passwordEditText, TextInputLayout passwordLayout, TextView textViewAppMaker,
      View view1, View view2, RelativeLayout viewRelative) {
    super(_bindingComponent, _root, _localFieldCount);
    this.appLogo = appLogo;
    this.createAccountButton = createAccountButton;
    this.emailEditText = emailEditText;
    this.emailLayout = emailLayout;
    this.loadingBar = loadingBar;
    this.loginButton = loginButton;
    this.mainRelative = mainRelative;
    this.orTextView = orTextView;
    this.passwordEditText = passwordEditText;
    this.passwordLayout = passwordLayout;
    this.textViewAppMaker = textViewAppMaker;
    this.view1 = view1;
    this.view2 = view2;
    this.viewRelative = viewRelative;
  }

  @NonNull
  public static ActivityLoginActivitiyBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.activity_login_activitiy, root, attachToRoot, component)
   */
  @NonNull
  @Deprecated
  public static ActivityLoginActivitiyBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
    return ViewDataBinding.<ActivityLoginActivitiyBinding>inflateInternal(inflater, com.fyp.appmaker.R.layout.activity_login_activitiy, root, attachToRoot, component);
  }

  @NonNull
  public static ActivityLoginActivitiyBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.activity_login_activitiy, null, false, component)
   */
  @NonNull
  @Deprecated
  public static ActivityLoginActivitiyBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable Object component) {
    return ViewDataBinding.<ActivityLoginActivitiyBinding>inflateInternal(inflater, com.fyp.appmaker.R.layout.activity_login_activitiy, null, false, component);
  }

  public static ActivityLoginActivitiyBinding bind(@NonNull View view) {
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
  public static ActivityLoginActivitiyBinding bind(@NonNull View view, @Nullable Object component) {
    return (ActivityLoginActivitiyBinding)bind(component, view, com.fyp.appmaker.R.layout.activity_login_activitiy);
  }
}
