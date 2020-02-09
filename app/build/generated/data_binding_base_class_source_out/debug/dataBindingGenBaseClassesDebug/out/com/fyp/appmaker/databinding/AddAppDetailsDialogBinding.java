package com.fyp.appmaker.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import java.lang.Deprecated;
import java.lang.Object;

public abstract class AddAppDetailsDialogBinding extends ViewDataBinding {
  @NonNull
  public final LinearLayout addIconRelativeLayout;

  @NonNull
  public final TextInputEditText addIconTextView;

  @NonNull
  public final TextInputLayout addIconTextViewLayout;

  @NonNull
  public final TextInputLayout appDesc;

  @NonNull
  public final TextInputEditText appDescEditText;

  @NonNull
  public final TextInputLayout appName;

  @NonNull
  public final TextInputEditText appNameEditText;

  @NonNull
  public final TextInputLayout creatorsName;

  @NonNull
  public final TextInputEditText creatorsNameEditText;

  @NonNull
  public final ImageButton insertIconButton;

  protected AddAppDetailsDialogBinding(Object _bindingComponent, View _root, int _localFieldCount,
      LinearLayout addIconRelativeLayout, TextInputEditText addIconTextView,
      TextInputLayout addIconTextViewLayout, TextInputLayout appDesc,
      TextInputEditText appDescEditText, TextInputLayout appName, TextInputEditText appNameEditText,
      TextInputLayout creatorsName, TextInputEditText creatorsNameEditText,
      ImageButton insertIconButton) {
    super(_bindingComponent, _root, _localFieldCount);
    this.addIconRelativeLayout = addIconRelativeLayout;
    this.addIconTextView = addIconTextView;
    this.addIconTextViewLayout = addIconTextViewLayout;
    this.appDesc = appDesc;
    this.appDescEditText = appDescEditText;
    this.appName = appName;
    this.appNameEditText = appNameEditText;
    this.creatorsName = creatorsName;
    this.creatorsNameEditText = creatorsNameEditText;
    this.insertIconButton = insertIconButton;
  }

  @NonNull
  public static AddAppDetailsDialogBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.add_app_details_dialog, root, attachToRoot, component)
   */
  @NonNull
  @Deprecated
  public static AddAppDetailsDialogBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
    return ViewDataBinding.<AddAppDetailsDialogBinding>inflateInternal(inflater, com.fyp.appmaker.R.layout.add_app_details_dialog, root, attachToRoot, component);
  }

  @NonNull
  public static AddAppDetailsDialogBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.add_app_details_dialog, null, false, component)
   */
  @NonNull
  @Deprecated
  public static AddAppDetailsDialogBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable Object component) {
    return ViewDataBinding.<AddAppDetailsDialogBinding>inflateInternal(inflater, com.fyp.appmaker.R.layout.add_app_details_dialog, null, false, component);
  }

  public static AddAppDetailsDialogBinding bind(@NonNull View view) {
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
  public static AddAppDetailsDialogBinding bind(@NonNull View view, @Nullable Object component) {
    return (AddAppDetailsDialogBinding)bind(component, view, com.fyp.appmaker.R.layout.add_app_details_dialog);
  }
}
