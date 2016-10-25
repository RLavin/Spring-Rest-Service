package com.ironyard.controler;

import com.ironyard.data.company;
import com.ironyard.repositories.CompanyRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Raul on 10/24/16.
 */
@RestController
public class CompanyControler {

    private final Logger log = LoggerFactory.getLogger(this.getClass());
    private CompanyRepository companyRepository;

    @Autowired
    public void setCompanyRepository(CompanyRepository aRepo) {
        this.companyRepository = aRepo;
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
   public Iterable<company> list(){
        Iterable<company> list = companyRepository.findAll();
        log.debug(list.toString());
        log.debug("debug level log");
        log.info("info level log");
        log.error("error level log");
        return list;
    }

    @RequestMapping(value = "/company/delete/{id}", method = RequestMethod.DELETE)
    public company delete(@PathVariable Long id){
        company deleted = companyRepository.findOne(id);
        companyRepository.delete(id);
        return deleted;
    }

    @ExceptionHandler(value = Throwable.class)
    public String nfeHandler(Throwable e){
        return "You Suck just go home and cry HAHAHAHA SUCKER!!!";
    }
}
