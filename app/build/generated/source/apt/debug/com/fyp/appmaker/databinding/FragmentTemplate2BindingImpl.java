package com.fyp.appmaker.databinding;
import com.fyp.appmaker.R;
import com.fyp.appmaker.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class FragmentTemplate2BindingImpl extends FragmentTemplate2Binding  {

    @Nullable
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.productsTextView, 1);
        sViewsWithIds.put(R.id.gridLayout, 2);
        sViewsWithIds.put(R.id.number1, 3);
        sViewsWithIds.put(R.id.image1, 4);
        sViewsWithIds.put(R.id.productName1, 5);
        sViewsWithIds.put(R.id.productPrice1, 6);
        sViewsWithIds.put(R.id.number2, 7);
        sViewsWithIds.put(R.id.image2, 8);
        sViewsWithIds.put(R.id.productName2, 9);
        sViewsWithIds.put(R.id.productPrice2, 10);
        sViewsWithIds.put(R.id.number3, 11);
        sViewsWithIds.put(R.id.image3, 12);
        sViewsWithIds.put(R.id.productName3, 13);
        sViewsWithIds.put(R.id.productPrice3, 14);
        sViewsWithIds.put(R.id.number4, 15);
        sViewsWithIds.put(R.id.image4, 16);
        sViewsWithIds.put(R.id.productName4, 17);
        sViewsWithIds.put(R.id.productPrice4, 18);
        sViewsWithIds.put(R.id.colorEditor, 19);
    }
    // views
    // variables
    // values
    // listeners
    // Inverse Binding Event Handlers

    public FragmentTemplate2BindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 20, sIncludes, sViewsWithIds));
    }
    private FragmentTemplate2BindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0
            , (android.widget.ImageView) bindings[19]
            , (android.widget.GridLayout) bindings[2]
            , (android.widget.ImageView) bindings[4]
            , (android.widget.ImageView) bindings[8]
            , (android.widget.ImageView) bindings[12]
            , (android.widget.ImageView) bindings[16]
            , (android.widget.RelativeLayout) bindings[3]
            , (android.widget.RelativeLayout) bindings[7]
            , (android.widget.RelativeLayout) bindings[11]
            , (android.widget.RelativeLayout) bindings[15]
            , (androidx.constraintlayout.widget.ConstraintLayout) bindings[0]
            , (android.widget.TextView) bindings[5]
            , (android.widget.TextView) bindings[9]
            , (android.widget.TextView) bindings[13]
            , (android.widget.TextView) bindings[17]
            , (android.widget.TextView) bindings[6]
            , (android.widget.TextView) bindings[10]
            , (android.widget.TextView) bindings[14]
            , (android.widget.TextView) bindings[18]
            , (android.widget.TextView) bindings[1]
            );
        this.parentConstraint.setTag(null);
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