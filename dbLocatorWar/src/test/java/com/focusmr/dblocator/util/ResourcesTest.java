package com.focusmr.dblocator.util;

import junit.framework.Assert;
import org.junit.Test;

import javax.enterprise.inject.spi.Annotated;
import javax.enterprise.inject.spi.Bean;
import javax.enterprise.inject.spi.InjectionPoint;
import java.lang.annotation.Annotation;
import java.lang.reflect.Member;
import java.lang.reflect.Type;
import java.util.Set;
import java.util.logging.Logger;

/**
 */
public class ResourcesTest {
    @Test
    public void testInjectionPOtin() {
        final Resources resources = new Resources();
        final Logger logger = resources.produceLog(new InjectionPoint() {
            @Override
            public Type getType() {
                return null;
            }

            @Override
            public Set<Annotation> getQualifiers() {
                return null;
            }

            @Override
            public Bean<?> getBean() {
                return null;
            }

            @Override
            public Member getMember() {
                return new Member() {
                    @Override
                    public Class<?> getDeclaringClass() {
                        return this.getClass();
                    }

                    @Override
                    public String getName() {
                        return "test";
                    }

                    @Override
                    public int getModifiers() {
                        return 0;
                    }

                    @Override
                    public boolean isSynthetic() {
                        return false;
                    }
                };
            }

            @Override
            public Annotated getAnnotated() {
                return null;
            }

            @Override
            public boolean isDelegate() {
                return false;
            }

            @Override
            public boolean isTransient() {
                return false;
            }
        });
        Assert.assertNotNull(logger);
    }
}
