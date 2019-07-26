package org.spring.angular.example.controller;

import org.spring.angular.example.domain.AuthorityGroup;
import org.spring.angular.example.model.error.ErrorResponse;
import org.spring.angular.example.service.AuthorityGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;
import static org.springframework.http.HttpStatus.NO_CONTENT;

@RestController
@RequestMapping("/api/authority-groups")
public class AuthorityGroupController {

    private final AuthorityGroupService authorityGroupService;

    @Autowired
    public AuthorityGroupController(final AuthorityGroupService authorityGroupService) {
        this.authorityGroupService = authorityGroupService;
    }

    @GetMapping
    public List<AuthorityGroup> getAll() {
        return authorityGroupService.getAll();
    }

    @GetMapping("/{id}")
    public AuthorityGroup findById(@PathVariable final long id) {
        return authorityGroupService.getById(id);
    }

    @PostMapping
    @ResponseStatus(NO_CONTENT)
    public void create(@RequestBody final AuthorityGroup authorityGroup) {
        authorityGroupService.create(authorityGroup);
    }

    @PutMapping
    @ResponseStatus(NO_CONTENT)
    public void update(@RequestBody final AuthorityGroup authorityGroup) {
        authorityGroupService.update(authorityGroup);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(NO_CONTENT)
    public void delete(@PathVariable final Long id) {
        final AuthorityGroup authorityGroup = authorityGroupService.getById(id);
        authorityGroupService.delete(authorityGroup.getId());
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> exceptionHandler(final Exception exception) {
        final ErrorResponse errorResponse = ErrorResponse.builder()
                                                         .errorCode(INTERNAL_SERVER_ERROR.value())
                                                         .message(exception.getMessage())
                                                         .build();
        return new ResponseEntity<>(errorResponse, INTERNAL_SERVER_ERROR);
    }

}

