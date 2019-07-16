package com.zw.service;

import com.zw.domain.Organization;
import com.zw.mapper.OrganizationMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class OrganizationService extends BaseService<Organization> {
    @Autowired
    private OrganizationMapper organizationMapper;


}
