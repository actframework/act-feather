package org.codejargon.feather;

import act.di.feather.Feather;
import act.di.feather.Provides;
import org.junit.Test;

import javax.inject.Inject;
import javax.inject.Singleton;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;

public class ModuleTest {

    @Test
    public void test() {
        Feather feather = Feather.with(new MyModule());
        App app = feather.instance(App.class);
        assertNotNull(app.a);
        assertNotNull(app.b);

        App app2 = feather.instance(App.class);
        assertNotEquals(app, app2);
        assertEquals(app.a, app2.a);
        assertNotEquals(app.b, app2.b);
    }

    public static class A {}

    public static class B {}

    public static class App {
        @Inject
        private A a;

        @Inject
        private B b;
    }

    public static class MyModule {
        private A a = new A();
        private B b = new B();

        public MyModule() {
        }

        @Singleton
        @Provides
        public A x() {
            return a;
        }
    }

}
