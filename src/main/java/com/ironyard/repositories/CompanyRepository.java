package com.ironyard.repositories;

import com.ironyard.data.company;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by Raul on 10/24/16.
 */
public interface CompanyRepository extends CrudRepository<company, Long>  {
}
