package com.snow.riji;

import android.app.Activity;
import android.content.Context;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;

import com.snow.riji.editor.KindSectionView;

/**
 * A placeholder fragment containing a simple view.
 */
public class EditActivityFragment extends Fragment {
    private Context mContext;
    private LinearLayout mContent;
    private LayoutInflater mInflater;
   // private KindSectionView m

    public EditActivityFragment() {
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        mContext = activity;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_edit, container, false);
        mContent = (LinearLayout)view.findViewById(R.id.editorsContainer);
        bindEditorsForNewRiji();
        mInflater = (LayoutInflater)mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        return view;
    }

    private void bindEditorsForNewRiji(){
       // mContent.removeAllViews();
        final KindSectionView section = (KindSectionView)mInflater.inflate(
                R.layout.item_kind_section, mContent, false);
        KindSectionView kv = new KindSectionView(mContext);
        Button a = new Button(mContext);
        mContent.addView(section);
        mContent.addView(a);
    }
}