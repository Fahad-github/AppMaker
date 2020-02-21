package com.fyp.appmaker;

import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.View;
import androidx.databinding.DataBinderMapper;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.fyp.appmaker.databinding.ActivityLoginActivitiyBindingImpl;
import com.fyp.appmaker.databinding.ActivitySignUpBindingImpl;
import com.fyp.appmaker.databinding.ActivitySplashBindingImpl;
import com.fyp.appmaker.databinding.AddAppDetailsDialogBindingImpl;
import com.fyp.appmaker.databinding.ChooseSplashAnimDialogBindingImpl;
import java.lang.IllegalArgumentException;
import java.lang.Integer;
import java.lang.Object;
import java.lang.Override;
import java.lang.RuntimeException;
import java.lang.String;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DataBinderMapperImpl extends DataBinderMapper {
  private static final int LAYOUT_ACTIVITYLOGINACTIVITIY = 1;

  private static final int LAYOUT_ACTIVITYSIGNUP = 2;

  private static final int LAYOUT_ACTIVITYSPLASH = 3;

  private static final int LAYOUT_ADDAPPDETAILSDIALOG = 4;

  private static final int LAYOUT_CHOOSESPLASHANIMDIALOG = 5;

  private static final SparseIntArray INTERNAL_LAYOUT_ID_LOOKUP = new SparseIntArray(5);

  static {
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.fyp.appmaker.R.layout.activity_login_activitiy, LAYOUT_ACTIVITYLOGINACTIVITIY);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.fyp.appmaker.R.layout.activity_sign_up, LAYOUT_ACTIVITYSIGNUP);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.fyp.appmaker.R.layout.activity_splash, LAYOUT_ACTIVITYSPLASH);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.fyp.appmaker.R.layout.add_app_details_dialog, LAYOUT_ADDAPPDETAILSDIALOG);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.fyp.appmaker.R.layout.choose_splash_anim_dialog, LAYOUT_CHOOSESPLASHANIMDIALOG);
  }

  @Override
  public ViewDataBinding getDataBinder(DataBindingComponent component, View view, int layoutId) {
    int localizedLayoutId = INTERNAL_LAYOUT_ID_LOOKUP.get(layoutId);
    if(localizedLayoutId > 0) {
      final Object tag = view.getTag();
      if(tag == null) {
        throw new RuntimeException("view must have a tag");
      }
      switch(localizedLayoutId) {
        case  LAYOUT_ACTIVITYLOGINACTIVITIY: {
          if ("layout/activity_login_activitiy_0".equals(tag)) {
            return new ActivityLoginActivitiyBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for activity_login_activitiy is invalid. Received: " + tag);
        }
        case  LAYOUT_ACTIVITYSIGNUP: {
          if ("layout/activity_sign_up_0".equals(tag)) {
            return new ActivitySignUpBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for activity_sign_up is invalid. Received: " + tag);
        }
        case  LAYOUT_ACTIVITYSPLASH: {
          if ("layout/activity_splash_0".equals(tag)) {
            return new ActivitySplashBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for activity_splash is invalid. Received: " + tag);
        }
        case  LAYOUT_ADDAPPDETAILSDIALOG: {
          if ("layout/add_app_details_dialog_0".equals(tag)) {
            return new AddAppDetailsDialogBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for add_app_details_dialog is invalid. Received: " + tag);
        }
        case  LAYOUT_CHOOSESPLASHANIMDIALOG: {
          if ("layout/choose_splash_anim_dialog_0".equals(tag)) {
            return new ChooseSplashAnimDialogBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for choose_splash_anim_dialog is invalid. Received: " + tag);
        }
      }
    }
    return null;
  }

  @Override
  public ViewDataBinding getDataBinder(DataBindingComponent component, View[] views, int layoutId) {
    if(views == null || views.length == 0) {
      return null;
    }
    int localizedLayoutId = INTERNAL_LAYOUT_ID_LOOKUP.get(layoutId);
    if(localizedLayoutId > 0) {
      final Object tag = views[0].getTag();
      if(tag == null) {
        throw new RuntimeException("view must have a tag");
      }
      switch(localizedLayoutId) {
      }
    }
    return null;
  }

  @Override
  public int getLayoutId(String tag) {
    if (tag == null) {
      return 0;
    }
    Integer tmpVal = InnerLayoutIdLookup.sKeys.get(tag);
    return tmpVal == null ? 0 : tmpVal;
  }

  @Override
  public String convertBrIdToString(int localId) {
    String tmpVal = InnerBrLookup.sKeys.get(localId);
    return tmpVal;
  }

  @Override
  public List<DataBinderMapper> collectDependencies() {
    ArrayList<DataBinderMapper> result = new ArrayList<DataBinderMapper>(1);
    result.add(new androidx.databinding.library.baseAdapters.DataBinderMapperImpl());
    return result;
  }

  private static class InnerBrLookup {
    static final SparseArray<String> sKeys = new SparseArray<String>(2);

    static {
      sKeys.put(0, "_all");
    }
  }

  private static class InnerLayoutIdLookup {
    static final HashMap<String, Integer> sKeys = new HashMap<String, Integer>(5);

    static {
      sKeys.put("layout/activity_login_activitiy_0", com.fyp.appmaker.R.layout.activity_login_activitiy);
      sKeys.put("layout/activity_sign_up_0", com.fyp.appmaker.R.layout.activity_sign_up);
      sKeys.put("layout/activity_splash_0", com.fyp.appmaker.R.layout.activity_splash);
      sKeys.put("layout/add_app_details_dialog_0", com.fyp.appmaker.R.layout.add_app_details_dialog);
      sKeys.put("layout/choose_splash_anim_dialog_0", com.fyp.appmaker.R.layout.choose_splash_anim_dialog);
    }
  }
}
