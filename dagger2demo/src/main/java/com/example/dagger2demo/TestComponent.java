package com.example.dagger2demo;

import dagger.Component;

/**
 * @author mochangsheng
 * @description 该类的主要功能描述
 */
@Component
public interface TestComponent {
    void inject(MainActivity activity);
    void inject(TestActivity activity);
}
