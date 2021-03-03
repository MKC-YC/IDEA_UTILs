package com.tian.service;


import com.tian.domain.Administrator;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface AdministratorService extends UserDetailsService {
    public List<Administrator> findAll();
    public void addAdministrator(Administrator administrator);
    public void update(Administrator administrator);
    public void delete(Integer ad_id);

    public Administrator findOne(Integer ad_id);
}
