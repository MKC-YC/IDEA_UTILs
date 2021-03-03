package com.tian.service.impl;

import com.tian.dao.AdministratorDao;
import com.tian.domain.Administrator;
import com.tian.service.AdministratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("administratorService")
public class AdministratorServiceImpl implements AdministratorService {

    @Autowired
    private AdministratorDao dao;

    @Override
    public List<Administrator> findAll() {
        return dao.findAll();
    }


    @Override
    public void addAdministrator(Administrator administrator) {
        dao.addAdministrator(administrator);
    }

    @Override
    public void update(Administrator administrator) {
        dao.update(administrator);
    }

    @Override
    public void delete(Integer ad_id) {
        dao.delete(ad_id);
    }

    @Override
    public Administrator findOne(Integer ad_id) {
        return dao.findOne(ad_id);
    }


    public Administrator selectOne(String ad_name, String password) {
        return dao.selectOne(ad_name,password);
    }

    @Override
    public UserDetails loadUserByUsername(String adName) throws UsernameNotFoundException {
        Administrator ad = dao.findByAd_name(adName);
        User user = new User(ad.getAd_name(),"{noop}"+ad.getPassword(),true,true,true,true,getAuthority(ad.getPermission()));
        return user;

    }
    private List<SimpleGrantedAuthority> getAuthority(String permission){
        List<SimpleGrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority((permission)));
        return authorities;
    }
}
