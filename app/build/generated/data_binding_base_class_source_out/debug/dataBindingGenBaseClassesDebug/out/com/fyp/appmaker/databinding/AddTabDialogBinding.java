package com.fyp.appmaker.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import java.lang.Deprecated;
import java.lang.Object;

public abstract class AddTabDialogBinding extends ViewDataBinding {
  @NonNull
  public final MaterialButton tabAddButton;

  @NonNull
  public final MaterialButton tabCancelButton;

  @NonNull
  public final TextInputEditText tabNameEdit;

  @NonNull
  public final TextInputLayout tabNameLayout;

  protected AddTabDialogBinding(Object _bindingComponent, View _root, int _localFieldCount,
      MaterialButton tabAddButton, MaterialButton tabCancelButton, TextInputEditText tabNameEdit,
      TextInputLayout tabNameLayout) {
    super(_bindingComponent, _root, _localFieldCount);
    this.tabAddButton = tabAddButton;
    this.tabCancelButton = tabCancelButton;
    this.tabNameEdit = tabNameEdit;
    this.tabNameLayout = tabNameLayout;
  }

  @NonNull
  public static AddTabDialogBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.add_tab_dialog, root, attachToRoot, component)
   */
  @NonNull
  @Deprecated
  public static AddTabDialogBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
    return ViewDataBinding.<AddTabDialogBinding>inflateInternal(inflater, com.fyp.appmaker.R.layout.add_tab_dialog, root, attachToRoot, component);
  }

  @NonNull
  public static AddTabDialogBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.add_tab_dialog, null, false, component)
   */
  @NonNull
  @Deprecated
  public static AddTabDialogBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable Object component) {
    return ViewDataBinding.<AddTabDialogBinding>inflateInternal(inflater, com.fyp.appmaker.R.layout.add_tab_dialog, null, false, component);
  }

  public static AddTabDialogBinding bind(@NonNull View view) {
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
  public static AddTabDialogBinding bind(@NonNull View view, @Nullable Object component) {
    return (AddTabDialogBinding)bind(component, view, com.fyp.appmaker.R.layout.add_tab_dialog);
  }
}
