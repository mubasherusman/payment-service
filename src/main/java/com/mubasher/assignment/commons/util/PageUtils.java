package com.mubasher.assignment.commons.util;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;

/**
 * PageUtils is used to create Page related functions.
 *
 * @author Mubasher Usman
 * @since 0.0.1
 */
public class PageUtils {

	public static Pageable createPage(int page, int size) {
		return PageRequest.of(page - 1, size);
	}

	public static Pageable createPageWithSort(int page, int size, List<String> properties,
			boolean isDescending) {

		Sort sort = getSortOrder(properties, isDescending);
		return sort == null ? PageRequest.of(page - 1, size)
				: PageRequest.of(page - 1, size, sort);

	}

	public static Sort getSortOrder(List<String> properties, boolean isDescending) {
		Sort sortOnFields = null;
		if (properties != null && !properties.isEmpty()) {
			sortOnFields = new Sort(
					isDescending ? Sort.Direction.DESC : Sort.Direction.ASC, properties);
		}
		return sortOnFields;
	}

	public static Pageable createPage(int page, int size, Sort sort) {
		return PageRequest.of(page - 1, size, sort);
	}

}
