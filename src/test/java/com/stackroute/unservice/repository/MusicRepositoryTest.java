package com.stackroute.unservice.repository;

import com.stackroute.unservice.domain.Music;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;


@RunWith(SpringRunner.class)
@DataJpaTest



public class MusicRepositoryTest {
    @Autowired
    private MusicRepository musicRepository;
    private Music music;

    @Before
    public void setUp()
    {
        music = new Music();
        music.setId(10);
        music.setName("John");
        music.setComments("Jenny");

    }

    @After
    public void tearDown(){

        musicRepository.deleteAll();
    }


    @Test
    public void testSaveMusic(){
        musicRepository.save(music);
        Music fetchMusic = musicRepository.findById(music.getId()).get();
        Assert.assertEquals(10,fetchMusic.getId());

    }

    @Test
    public void testSaveMusicFailure(){
        Music testMusic = new Music(23,"john","marry");
        musicRepository.save(music);
        Music fetchMusic = musicRepository.findById(music.getId()).get();
        Assert.assertNotSame(testMusic,music);
    }

    @Test
    public void testGetAllMusic(){
        Music u = new Music(67,"welcome","jerry");
        Music u1 = new Music(87,"Jenny","trew");
        musicRepository.save(u);
        musicRepository.save(u1);

        List<Music> list = musicRepository.findAll();
        Assert.assertEquals("welcome",list.get(0).getName());


    }



    @Test
    public void updateMusic(){
        Music m1=new Music(26,"rAJ","MALYA");
        musicRepository.save(m1);

    }


}
