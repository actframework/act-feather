package org.codejargon.feather;

import act.di.feather.Feather;
import org.junit.Test;

import javax.inject.Inject;

import static org.junit.Assert.assertNotNull;

public class FieldInjectionTest {
    @Test
    public void fieldsInjected() {
        Feather feather = Feather.with();
        Target target = new Target();
        feather.injectFields(target);
        assertNotNull(target.a);
    }

    @Test
    public void fieldsInjected2() {
        Feather feather = Feather.with();
        Target target = feather.instance(Target.class);
        assertNotNull(target.a);
    }

    @Test
    public void fieldsInSuperClassInjected() {
        Feather feather = Feather.with();
        MoreTarget target = feather.instance(MoreTarget.class);
        assertNotNull(target.a());
    }


    public static class Target {
        @Inject
        private A a;
    }

    public static class A {

    }

    public static class MoreTarget extends Target {
        public A a() {
            return super.a;
        }
    }

}
