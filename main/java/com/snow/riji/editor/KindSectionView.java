package com.snow.riji.editor;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.snow.riji.R;
import com.snow.riji.until.SnowLog;

import java.util.ArrayList;
import java.util.List;

/**
 * Custom view for an entire section of data as segmented by
 * {@ DataKind} around a { Data#MIMETYPE}. This view shows a
 * section header and a trigger for adding new { Data} rows.
 */
public class KindSectionView extends LinearLayout {
    private static final String TAG = "KindSectionView";

    private TextView mTitle;
    private ViewGroup mEditors;
    private View mAddFieldFooter;
    private String mTitleString;

    private LayoutInflater mInflater;

    public KindSectionView(Context context) {
        super(context);
        SnowLog.d(TAG, "KindSectionView 1--------------------");
        mInflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        mInflater.inflate(R.layout.item_kind_section,this);
        mTitle = (TextView) findViewById(R.id.kind_title);
        mTitle.setText(R.string.action_settings);
        mEditors = (ViewGroup) findViewById(R.id.kind_editors);
        mAddFieldFooter = findViewById(R.id.add_text);
        mAddFieldFooter.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                // Setup click listener to add an empty field when the footer is clicked.
                //   mAddFieldFooter.setVisibility(View.GONE);
                addItem();
            }
        });
    }

    public KindSectionView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public void setEnabled(boolean enabled) {
        SnowLog.d(TAG, "setEnabled");
        super.setEnabled(enabled);
        if (mEditors != null) {
            int childCount = mEditors.getChildCount();
            for (int i = 0; i < childCount; i++) {
                mEditors.getChildAt(i).setEnabled(enabled);
            }
        }

      //  if (enabled) {
            mAddFieldFooter.setVisibility(View.VISIBLE);
      //  } else {
      //      mAddFieldFooter.setVisibility(View.GONE);
      //  }
    }

    public void addItem() {
        SnowLog.d(TAG, "addItem");
        final View newField = createEditorView();

        // Hide the "add field" footer because there is now a blank field.
     //   mAddFieldFooter.setVisibility(View.GONE);

        // Ensure we are visible
   //     updateSectionVisible();
    }

    public String getTitle() {
        return mTitleString;
    }

    public void setTitleVisible(boolean visible) {
        findViewById(R.id.kind_title_layout).setVisibility(View.VISIBLE);
    }

    /**
     * Creates an EditorView for the given entry. This function must be used while constructing
     * the views corresponding to the the object-model. The resulting EditorView is also added
     * to the end of mEditors
     */
    private View createEditorView() {
        final View view;
        try {
            view = mInflater.inflate(R.layout.text_fields_editor_view, mEditors, false);
        } catch (Exception e) {
            throw new RuntimeException(
                    "Cannot allocate editor with layout resource ID "  + e.toString());
        }

       // view.setEnabled(isEnabled());

        if (view instanceof Editor) {
            Editor editor = (Editor)view;
            editor.setDeletable(true);
        }
        SnowLog.d(TAG, "createEditorView addView");
        mEditors.addView(view);
        return view;
    }

    private void updateSectionVisible() {
        setVisibility(VISIBLE );
    }


    /**
     * Updates the editors being displayed to the user removing extra empty
     * {@link Editor}s, so there is only max 1 empty {@link Editor} view at a time.
     */
    private void updateEmptyEditors() {
        List<View> emptyEditors = getEmptyEditors();
        SnowLog.d(TAG, "updateEmptyEditors");
        // If there is more than 1 empty editor, then remove it from the list of editors.
        if (emptyEditors.size() > 1) {
            for (View emptyEditorView : emptyEditors) {
                // If no child {@link View}s are being focused on within
                // this {@link View}, then remove this empty editor.
                if (emptyEditorView.findFocus() == null) {
                    mEditors.removeView(emptyEditorView);
                }
            }
        }
    }

    /**
     * Returns a list of empty editor views in this section.
     */
    private List<View> getEmptyEditors() {
        List<View> emptyEditorViews = new ArrayList<View>();
        for (int i = 0; i < mEditors.getChildCount(); i++) {
            View view = mEditors.getChildAt(i);
            if (((Editor) view).isEmpty()) {
                emptyEditorViews.add(view);
            }
        }
        return emptyEditorViews;
    }

    public int getEditorCount() {
        return mEditors.getChildCount();
    }

}
