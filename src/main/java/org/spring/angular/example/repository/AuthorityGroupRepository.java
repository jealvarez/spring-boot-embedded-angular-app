package org.spring.angular.example.repository;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.spring.angular.example.domain.AuthorityGroup;

import java.util.List;

@Mapper
public interface AuthorityGroupRepository {

    @Select("SELECT * FROM authority_group")
    List<AuthorityGroup> findAll();

    @Select("SELECT * FROM authority_group WHERE id = #{id}")
    AuthorityGroup findById(@Param("id") final Long id);

    @Insert("INSERT INTO authority_group (name) VALUES (#{name})")
    @Options(useGeneratedKeys = true, keyColumn = "id")
    void insert(final AuthorityGroup authorityGroup);

    @Delete("DELETE FROM authority_group WHERE id = #{id}")
    int delete(@Param("id") final Long id);

    @Update("UPDATE authority_group " +
                    "SET " +
                    "   name = #{name} " +
                    "WHERE id = #{id}")
    int update(final AuthorityGroup authorityGroup);

}
