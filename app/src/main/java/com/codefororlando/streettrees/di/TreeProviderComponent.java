package com.codefororlando.streettrees.di;

import com.codefororlando.streettrees.activity.DetailActivity;
import com.codefororlando.streettrees.activity.MainActivity;
import com.codefororlando.streettrees.requesttree.selecttree.SelectTreeFragment;

import javax.inject.Singleton;

import dagger.Component;


@Singleton
@Component(modules = {TreeProviderModule.class, TreeDescriptionProviderModule.class})
public interface TreeProviderComponent {
    void inject(MainActivity target);

    void inject(DetailActivity target);

    void inject(SelectTreeFragment target);
}
