package com.fyp.appmaker.databinding;
import com.fyp.appmaker.R;
import com.fyp.appmaker.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class ActivityProductDetailsBindingImpl extends ActivityProductDetailsBinding  {

    @Nullable
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.relativeLayout, 1);
        sViewsWithIds.put(R.id.backButton, 2);
        sViewsWithIds.put(R.id.footer, 3);
        sViewsWithIds.put(R.id.buyNowButton, 4);
        sViewsWithIds.put(R.id.addToCartButton, 5);
        sViewsWithIds.put(R.id.productImage, 6);
        sViewsWithIds.put(R.id.sizesLayout, 7);
        sViewsWithIds.put(R.id.small, 8);
        sViewsWithIds.put(R.id.medium, 9);
        sViewsWithIds.put(R.id.large, 10);
        sViewsWithIds.put(R.id.extraLarge, 11);
        sViewsWithIds.put(R.id.heartImage, 12);
        sViewsWithIds.put(R.id.productPrice, 13);
        sViewsWithIds.put(R.id.productName, 14);
        sViewsWithIds.put(R.id.productDescription, 15);
        sViewsWithIds.put(R.id.ratingBar, 16);
    }
    // views
    @NonNull
    private final androidx.constraintlayout.widget.ConstraintLayout mboundView0;
    // variables
    // values
    // listeners
    // Inverse Binding Event Handlers

    public ActivityProductDetailsBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 17, sIncludes, sViewsWithIds));
    }
    private ActivityProductDetailsBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0
            , (androidx.appcompat.widget.AppCompatImageView) bindings[5]
            , (android.widget.ImageView) bindings[2]
            , (com.google.android.material.button.MaterialButton) bindings[4]
            , (com.google.android.material.button.MaterialButton) bindings[11]
            , (android.widget.RelativeLayout) bindings[3]
            , (android.widget.ImageView) bindings[12]
            , (com.google.android.material.button.MaterialButton) bindings[10]
            , (com.google.android.material.button.MaterialButton) bindings[9]
            , (android.widget.TextView) bindings[15]
            , (android.widget.ImageView) bindings[6]
            , (android.widget.TextView) bindings[14]
            , (android.widget.TextView) bindings[13]
            , (android.widget.RatingBar) bindings[16]
            , (android.widget.RelativeLayout) bindings[1]
            , (android.widget.RelativeLayout) bindings[7]
            , (com.google.android.material.button.MaterialButton) bindings[8]
            );
        this.mboundView0 = (androidx.constraintlayout.widget.ConstraintLayout) bindings[0];
        this.mboundView0.setTag(null);
        setRootTag(root);
        // listeners
        invalidateAll();
    }

    @Override
    public void invalidateAll() {
        synchronized(this) {
                mDirtyFlags = 0x1L;
        }
        requestRebind();
    }

    @Override
    public boolean hasPendingBindings() {
        synchronized(this) {
            if (mDirtyFlags != 0) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean setVariable(int variableId, @Nullable Object variable)  {
        boolean variableSet = true;
            return variableSet;
    }

    @Override
    protected boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        switch (localFieldId) {
        }
        return false;
    }

    @Override
    protected void executeBindings() {
        long dirtyFlags = 0;
        synchronized(this) {
            dirtyFlags = mDirtyFlags;
            mDirtyFlags = 0;
        }
        // batch finished
    }
    // Listener Stub Implementations
    // callback impls
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;
    /* flag mapping
        flag 0 (0x1L): null
    flag mapping end*/
    //end
}