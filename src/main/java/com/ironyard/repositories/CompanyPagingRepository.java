package com.ironyard.repositories;

import com.ironyard.data.company;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * Created by Raul on 10/25/16.
 */
public interface  CompanyPagingRepository extends PagingAndSortingRepository <company, Long>{
}
