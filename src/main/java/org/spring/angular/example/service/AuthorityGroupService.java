package org.spring.angular.example.service;

import org.spring.angular.example.domain.AuthorityGroup;
import org.spring.angular.example.repository.AuthorityGroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(rollbackFor = Exception.class)
public class AuthorityGroupService {

    private final AuthorityGroupRepository authorityGroupRepository;

    @Autowired
    public AuthorityGroupService(final AuthorityGroupRepository authorityGroupRepository) {
        this.authorityGroupRepository = authorityGroupRepository;
    }

    public List<AuthorityGroup> getAll() {
        return authorityGroupRepository.findAll();
    }

    public AuthorityGroup getById(final Long id) {
        return authorityGroupRepository.findById(id);
    }

    public void create(final AuthorityGroup authorityGroup) {
        authorityGroupRepository.insert(authorityGroup);
    }

    public void update(final AuthorityGroup authorityGroup) {
        authorityGroupRepository.update(authorityGroup);
    }

    public void delete(final Long id) {
        authorityGroupRepository.delete(id);
    }

}
