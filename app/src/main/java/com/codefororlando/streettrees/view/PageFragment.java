package com.codefororlando.streettrees.view;

import android.app.Activity;
import android.content.Context;
import android.support.v4.app.Fragment;

public class PageFragment extends Fragment {

    protected PageFragmentListener pageListener;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        Activity activity = (Activity) context;
        try {
            // Instantiate the NoticeDialogListener so we can send events to the host
            pageListener = (PageFragmentListener) activity;
        } catch (ClassCastException e) {
            // The activity doesn't implement the interface, throw exception
            throw new ClassCastException(activity.toString()
                    + " must implement PageFragmentListener");
        }
    }

    public interface PageFragmentListener {
        void next();

        void previous();
    }
}
