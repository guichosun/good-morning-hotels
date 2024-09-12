package com.challenge.gmh.hotel.repository;

import com.challenge.gmh.hotel.model.entity.Hotel;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

public class TestHotelRepository implements HotelRepository{
    @Override
    public Optional<Hotel> findById(String id) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(String s) {
        return false;
    }

    @Override
    public List<Hotel> findByName(String name) {
        return null;
    }

    @Override
    public List<Hotel> findByNameAndStars(String name, Integer stars) {
        System.out.println("TestHotelRepository.findByNameAndStars");
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return Collections.emptyList();
    }

    @Override
    public <S extends Hotel> S save(S s) {
        System.out.println("TestHotelRepository.save");
        return null;
    }

    @Override
    public <S extends Hotel> List<S> saveAll(Iterable<S> iterable) {
        return null;
    }

    @Override
    public List<Hotel> findAll() {
        return null;
    }

    @Override
    public Iterable<Hotel> findAllById(Iterable<String> iterable) {
        return null;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void deleteById(String s) {

    }

    @Override
    public void delete(Hotel hotel) {

    }

    @Override
    public void deleteAllById(Iterable<? extends String> iterable) {

    }

    @Override
    public void deleteAll(Iterable<? extends Hotel> iterable) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public List<Hotel> findAll(Sort sort) {
        return null;
    }

    @Override
    public Page<Hotel> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public <S extends Hotel> S insert(S s) {
        return null;
    }

    @Override
    public <S extends Hotel> List<S> insert(Iterable<S> iterable) {
        return null;
    }

    @Override
    public <S extends Hotel> Optional<S> findOne(Example<S> example) {
        return Optional.empty();
    }

    @Override
    public <S extends Hotel> List<S> findAll(Example<S> example) {
        return null;
    }

    @Override
    public <S extends Hotel> List<S> findAll(Example<S> example, Sort sort) {
        return null;
    }

    @Override
    public <S extends Hotel> Page<S> findAll(Example<S> example, Pageable pageable) {
        return null;
    }

    @Override
    public <S extends Hotel> long count(Example<S> example) {
        return 0;
    }

    @Override
    public <S extends Hotel> boolean exists(Example<S> example) {
        return false;
    }

    @Override
    public <S extends Hotel, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction) {
        return null;
    }
}
