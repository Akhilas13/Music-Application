package com.stackroute.unservice.repository;

import com.stackroute.unservice.domain.Music;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MusicRepository extends JpaRepository<Music,Integer> {

    @Query(value = "select * from music where name = ?1", nativeQuery = true)
    public List<Music> getMusicByName(String music);

}
