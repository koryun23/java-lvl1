package com.aca.homework.week16.organization;

import net.bytebuddy.dynamic.DynamicType;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

class OrganizationServiceImplTest {
    @Test
    public void testGetById() {
        OrganizationService service = new OrganizationServiceImpl(new OrganizationRepository() {
            @Override
            public List<Organization> findAll() {
                return null;
            }

            @Override
            public List<Organization> findAll(Sort sort) {
                return null;
            }

            @Override
            public List<Organization> findAllById(Iterable<Long> longs) {
                return null;
            }

            @Override
            public <S extends Organization> List<S> saveAll(Iterable<S> entities) {
                return null;
            }

            @Override
            public void flush() {

            }

            @Override
            public <S extends Organization> S saveAndFlush(S entity) {
                return null;
            }

            @Override
            public <S extends Organization> List<S> saveAllAndFlush(Iterable<S> entities) {
                return null;
            }

            @Override
            public void deleteAllInBatch(Iterable<Organization> entities) {

            }

            @Override
            public void deleteAllByIdInBatch(Iterable<Long> longs) {

            }

            @Override
            public void deleteAllInBatch() {

            }

            @Override
            public Organization getOne(Long aLong) {
                return null;
            }

            @Override
            public Organization getById(Long aLong) {
                return null;
            }


            @Override
            public <S extends Organization> List<S> findAll(Example<S> example) {
                return null;
            }

            @Override
            public <S extends Organization> List<S> findAll(Example<S> example, Sort sort) {
                return null;
            }

            @Override
            public Page<Organization> findAll(Pageable pageable) {
                return null;
            }

            @Override
            public <S extends Organization> S save(S entity) {
                return null;
            }

            @Override
            public Optional<Organization> findById(Long aLong) {
                System.out.println("getting by id");
                if(aLong.equals(1L))
                    return Optional.of(new Organization("name-1", "address-1"));
                throw new OrganizationNotFoundException(aLong);
            }

            @Override
            public boolean existsById(Long aLong) {
                return false;
            }

            @Override
            public long count() {
                return 0;
            }

            @Override
            public void deleteById(Long aLong) {

            }

            @Override
            public void delete(Organization entity) {

            }

            @Override
            public void deleteAllById(Iterable<? extends Long> longs) {

            }

            @Override
            public void deleteAll(Iterable<? extends Organization> entities) {

            }

            @Override
            public void deleteAll() {

            }

            @Override
            public <S extends Organization> Optional<S> findOne(Example<S> example) {
                return Optional.empty();
            }

            @Override
            public <S extends Organization> Page<S> findAll(Example<S> example, Pageable pageable) {
                return null;
            }

            @Override
            public <S extends Organization> long count(Example<S> example) {
                return 0;
            }

            @Override
            public <S extends Organization> boolean exists(Example<S> example) {
                return false;
            }

            @Override
            public <S extends Organization, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction) {
                return null;
            }
        });

        Assertions.assertThat(service.getById(1L))
                .isEqualTo(new Organization("name-1", "address-1"));
    }
}