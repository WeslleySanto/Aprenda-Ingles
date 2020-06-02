package br.com.weslleyesanto.aprendaingles;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.ogaclejapan.smarttablayout.SmartTabLayout;
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItemAdapter;
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItems;

import br.com.weslleyesanto.aprendaingles.Fragments.BichosFragment;
import br.com.weslleyesanto.aprendaingles.Fragments.NumerosFragment;
import br.com.weslleyesanto.aprendaingles.Fragments.VogaisFragment;

public class MainActivity extends AppCompatActivity {

    private SmartTabLayout viewPagerTab;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewPagerTab  = findViewById(R.id.viewPagerTab);
        viewPager       = findViewById(R.id.viewPager);

        //Remove elevação Action bar
        getSupportActionBar().setElevation(0);

        FragmentPagerAdapter adapter = new FragmentPagerItemAdapter(
                getSupportFragmentManager(),
                FragmentPagerItems.with(this)
                    .add("Bichos", BichosFragment.class)
                    .add("Números", NumerosFragment.class)
                    .add("Vogais", VogaisFragment.class)
                    .create()
        );

        //Area de conteudo
        viewPager.setAdapter(adapter);
        viewPagerTab.setViewPager(viewPager);

    }
}
