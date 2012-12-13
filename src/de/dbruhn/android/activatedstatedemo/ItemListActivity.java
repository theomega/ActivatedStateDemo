package de.dbruhn.android.activatedstatedemo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.NavUtils;
import android.view.MenuItem;

public class ItemListActivity extends FragmentActivity implements
		ItemListFragment.Callbacks {

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_item_twopane);

	}

	@Override
	public void onItemSelected(String id) {

		Bundle arguments = new Bundle();
		arguments.putString(ItemDetailFragment.ARG_ITEM_ID, id);
		ItemDetailFragment fragment = new ItemDetailFragment();
		fragment.setArguments(arguments);
		getSupportFragmentManager().beginTransaction()
				.replace(R.id.item_detail_container, fragment).commit();

	}
}
