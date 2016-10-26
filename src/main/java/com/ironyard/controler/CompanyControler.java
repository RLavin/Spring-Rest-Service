package com.ironyard.controler;

import com.ironyard.data.company;
import com.ironyard.data.employees;
import com.ironyard.repositories.CompanyPagingRepository;
import com.ironyard.repositories.CompanyRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Raul on 10/24/16.
 */
@RestController
public class CompanyControler {

    private final Logger log = LoggerFactory.getLogger(this.getClass());
    private CompanyRepository companyRepository;
    private CompanyPagingRepository companyPagingRepository;

    @Autowired
    public void setCompanyRepository(CompanyRepository aRepo) {
        this.companyRepository = aRepo;
    }
    @Autowired
    public void setCompanyPagingRepository(CompanyPagingRepository companyPagingRepository) {
        this.companyPagingRepository = companyPagingRepository;
    }

    @RequestMapping(value = "/company", method = RequestMethod.POST, produces = "application/json")
    public company save(@RequestBody company aCompany){
        companyRepository.save(aCompany);
        return companyRepository.findOne(aCompany.getId());
    }

    @RequestMapping(value = "/company/update", method = RequestMethod.PUT)
    public company update(@RequestBody company aCompany){
        companyRepository.save(aCompany);
        return companyRepository.findOne(aCompany.getId());
    }

    @RequestMapping(value = "/company/{id}", method = RequestMethod.GET)
    public company show(@PathVariable Long id){
        return companyRepository.findOne(id);
    }

    @RequestMapping(value = "/companies", method = RequestMethod.GET)
   public Iterable<company> list (@RequestParam(value = "page") Integer page,
                                    @RequestParam("size") Integer size,
                                    @RequestParam(value = "sortby", required = false) String sortby,
                                    @RequestParam(value = "dir", required = false) Sort.Direction direction)
        {

            Iterable<company> found = null;

            if (sortby == null) {
                sortby = "name";
            }

            if (direction == null) {
            }
            // long way
            Sort s = new Sort(direction, sortby);
            PageRequest pr = new PageRequest(page, size, s);
            found = companyPagingRepository .findAll(pr);

            // short cut
            //found = playerPgStRepo.findAll(new PageRequest(page, size,  new Sort(direction, sortby)));

            return found;

        }





    @RequestMapping(value = "/company/delete/{id}", method = RequestMethod.DELETE)
    public company delete(@PathVariable Long id){
        company deleted = companyRepository.findOne(id);
        companyRepository.delete(id);
        return deleted;
    }

    @ExceptionHandler(value = Throwable.class)
    public String nfeHandler(Throwable e){
        e.printStackTrace();
        return "You Suck just go home and cry HAHAHAHA SUCKER!!!";
    }
}
