//package com.stackroute.unservice;
//
//import com.stackroute.unservice.domain.Music;
//import com.stackroute.unservice.service.MusicService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.context.ApplicationListener;
//import org.springframework.context.annotation.PropertySource;
//import org.springframework.context.event.ContextRefreshedEvent;
//import org.springframework.core.env.Environment;
//import org.springframework.stereotype.Component;
//
//@Component
//@PropertySource("classpath:application.properties")
//public class StartUpApplicationListener implements ApplicationListener<ContextRefreshedEvent> {
//    @Autowired
//    private MusicService musicService;
//
//    @Autowired
//    Environment environment;
//
//    Music music;
//
//
//    @Override
//    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
//
//        music=new Music(Integer.parseInt(environment.getProperty("id")),environment.getProperty("name"), environment.getProperty("comments"));
//        musicService.setData(music);
//    }
//
//}
