/*
 * Copyright 2013 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.springframework.data.elasticsearch.core.query;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;

/**
 * Query
 * 
 * @author Rizwan Idrees
 * @author Mohsin Husen
 */
public interface Query {

	public static final int DEFAULT_PAGE_SIZE = 10;
	public static final Pageable DEFAULT_PAGE = new PageRequest(0, DEFAULT_PAGE_SIZE);

	/**
	 * restrict result to entries on given page. Corresponds to the 'start' and 'rows' parameter in elasticsearch
	 * 
	 * @param pageable
	 * @return
	 */
	<T extends Query> T setPageable(Pageable pageable);

	/**
	 * Get filter queries if defined
	 * 
	 * @return
	 */
	// List<FilterQuery> getFilterQueries();

	/**
	 * Get page settings if defined
	 * 
	 * @return
	 */
	Pageable getPageable();

	/**
	 * Add {@link org.springframework.data.domain.Sort} to query
	 * 
	 * @param sort
	 * @return
	 */
	<T extends Query> T addSort(Sort sort);

	/**
	 * @return null if not set
	 */
	Sort getSort();

	/**
	 * Get Indices to be searched
	 * 
	 * @return
	 */
	List<String> getIndices();

	/**
	 * Add Indices to be added as part of search request
	 * 
	 * @param indices
	 */
	void addIndices(String... indices);

	/**
	 * Add types to be searched
	 * 
	 * @param types
	 */
	void addTypes(String... types);

	/**
	 * Get types to be searched
	 * 
	 * @return
	 */
	List<String> getTypes();

	/**
	 * Add fields to be added as part of search request
	 * 
	 * @param fields
	 */
	void addFields(String... fields);

	/**
	 * Get fields to be returned as part of search request
	 * 
	 * @return
	 */
	List<String> getFields();
}
