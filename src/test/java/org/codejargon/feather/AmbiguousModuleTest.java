package org.codejargon.feather;

import act.di.feather.Feather;
import act.di.feather.FeatherException;
import act.di.feather.Provides;
import org.junit.Test;

public class AmbiguousModuleTest {
    @Test(expected = FeatherException.class)
    public void ambiguousModule() {
        Feather.with(new Module());
    }

    public static class Module {
        @Provides
        String foo() {
            return "foo";
        }

        @Provides
        String bar() {
            return "bar";
        }
    }
}
