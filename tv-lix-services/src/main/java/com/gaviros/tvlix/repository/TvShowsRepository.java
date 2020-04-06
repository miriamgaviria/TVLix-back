package com.gaviros.tvlix.repository;

import org.springframework.data.repository.CrudRepository;

import com.gaviros.tvlix.entity.TvShow;

public interface TvShowsRepository extends CrudRepository<TvShow, Long> {

}
