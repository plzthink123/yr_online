package com.think123.yr_online.util;

import java.util.List;

@FunctionalInterface
public interface QueryAction<T> {

	List<T> execute();

}
