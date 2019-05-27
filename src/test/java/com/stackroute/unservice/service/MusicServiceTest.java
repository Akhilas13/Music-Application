package com.stackroute.unservice.service;

import com.stackroute.unservice.domain.Music;
import com.stackroute.unservice.exceptions.MusicAlreadyExistsException;
import com.stackroute.unservice.exceptions.MusicNotFoundException;
import com.stackroute.unservice.repository.MusicRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.when;



public class MusicServiceTest {
    private Music music;

    //Create a mock for UserRepository
    @Mock
    private MusicRepository musicRepository;

    //Inject the mocks as dependencies into UserServiceImpl
    @InjectMocks
    private MusicServiceImpl musicService;
    List<Music> list= null;


    @Before
    public void setUp(){
        //Initialising the mock object
        MockitoAnnotations.initMocks(this);
        music = new Music();
        music.setId(101);
        music.setName("Jenny");
        music.setComments("qwe");
        list = new ArrayList<>();
        list.add(music);


    }

    @Test
    public void saveMusicTestSuccess() throws MusicAlreadyExistsException {

        when(musicRepository.save((Music) any())).thenReturn(music);
            Music savedUser = musicService.saveMusic(music);
        Assert.assertEquals(music,savedUser);

        //verify here verifies that userRepository save method is only called once
        verify(musicRepository,times(1)).save(music);

    }

    @Test(expected = MusicAlreadyExistsException.class)
    public void saveMusicTestFailure() throws MusicAlreadyExistsException {
        when(musicRepository.save((Music)any())).thenReturn(null);
        Music saveMusic = musicService.saveMusic(music);
        System.out.println("saveUser" + saveMusic);
        Assert.assertEquals(music,saveMusic);

       /*doThrow(new UserAlreadyExistException()).when(userRepository).findById(eq(101));
       userService.saveUser(user);*/


    }

    @Test
    public void getAllMusic(){

        musicRepository.save(music);
        //stubbing the mock to return specific data
        when(musicRepository.findAll()).thenReturn(list);
        List<Music> userlist = musicService.getAllMusic();
        Assert.assertEquals(list,userlist);
    }


    @Test
    public void updateMusic(){

        when(musicRepository.save((Music) any())).thenReturn(music);
        try {
            Music updateMusic = musicService.updateMusic(music);
        } catch (MusicNotFoundException e) {
            e.printStackTrace();
        }
        // Assert.assertEquals(music,updateMusic);

        //verify here verifies that userRepository save method is only called once
        verify(musicRepository,times(1)).save(music);

    }






}
