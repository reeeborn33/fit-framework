/*
 * Copyright (c) 2024-2025 Huawei Technologies Co., Ltd. All rights reserved.
 * This file is a part of the ModelEngine Project.
 * Licensed under the MIT License. See License.txt in the project root for license information.
 */

package modelengine.fitframework.aop.interceptor.aspect.interceptor;

import modelengine.fitframework.aop.annotation.AfterThrowing;
import modelengine.fitframework.aop.interceptor.AdviceMethodInterceptor;
import modelengine.fitframework.inspection.Nonnull;
import modelengine.fitframework.ioc.BeanFactory;

import java.lang.reflect.Method;
import java.util.Objects;

/**
 * 将带有 {@link AfterThrowing} 注解的方法包装成 {@link AdviceMethodInterceptor}。
 *
 * @author 季聿阶
 * @author 郭龙飞
 * @since 2022-05-14
 */
public class AspectAfterThrowingInterceptorFactory extends AbstractAspectInterceptorFactory {
    /**
     * 初始化 {@link AspectAfterThrowingInterceptorFactory} 的新实例。
     */
    public AspectAfterThrowingInterceptorFactory() {
        super(AfterThrowing.class);
    }

    @Override
    protected AdviceMethodInterceptor createConcreteMethodInterceptor(BeanFactory aspectFactory, Method method) {
        return new AspectAfterThrowingInterceptor(aspectFactory, method);
    }

    @Override
    protected String getExpression(@Nonnull Method method) {
        return this.getAnnotations(method).getAnnotation(AfterThrowing.class).pointcut();
    }

    @Override
    protected String getArgNames(@Nonnull Method method) {
        return this.getAnnotations(method).getAnnotation(AfterThrowing.class).argNames();
    }

    @Override
    protected boolean shouldIgnore(@Nonnull Method method, String argName) {
        return Objects.equals(argName, this.getAnnotations(method).getAnnotation(AfterThrowing.class).throwing());
    }
}
