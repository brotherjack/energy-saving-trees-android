package com.codefororlando.streettrees.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.codefororlando.streettrees.R;
import com.codefororlando.streettrees.TreeApplication;
import com.codefororlando.streettrees.api.models.TreeDescription;
import com.codefororlando.streettrees.api.providers.TreeDescriptionProvider;
import com.codefororlando.streettrees.fragments.DetailFragment;
import com.google.android.gms.maps.model.LatLng;

import javax.inject.Inject;

public class DetailActivity extends AppCompatActivity implements DetailFragment.DetailListener {

    final String TAG = "DETAILACTIVITY";

    @Inject
    TreeDescriptionProvider treeDescriptionProvider;
    private LatLng location;
    private String treeType;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        ((TreeApplication) getApplication()).getTreeProviderComponent().inject(this);

        if (savedInstanceState == null) {
            DetailFragment frag = DetailFragment.newInstance();
            getFragmentManager().beginTransaction()
                    .replace(R.id.detailContainer, frag, DetailFragment.TAG)
                    .commit();
        }

        Intent loadingIntent = getIntent();
        location = loadingIntent.getParcelableExtra(MainActivity.EXTRA_LOCATION);
        treeType = loadingIntent.getStringExtra(MainActivity.EXTRA_TREETYPE);
    }

	@Override
	public TreeDescription getTreeData() {
		try {
			return treeDescriptionProvider.getTreeDescription(treeType);
		} catch(IllegalArgumentException iae){
			Toast badTreeMsg = Toast.makeText(this.getApplicationContext(),
					iae.getMessage(), Toast.LENGTH_SHORT);
			badTreeMsg.show();
			return null;
	}
}
}
