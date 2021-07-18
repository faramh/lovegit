package view;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;

public class Sound_Effect {
    // Singleton Design
    // Only one State Instance should exist
    private static Sound_Effect Sound_Effect_state;
    public static Sound_Effect get_Sound_Effect_Instatnce(){
        if (Sound_Effect_state==null){
            Sound_Effect_state = new Sound_Effect();
        }
        return Sound_Effect_state;
    }

    public void button_sound_effect(){
        Clip clip;
        try {
            AudioInputStream input= AudioSystem.getAudioInputStream(new File("Button.wav"));
            clip=AudioSystem.getClip();
            clip.open(input);
            clip.start();
            //clip.loop(5);

        } catch (UnsupportedAudioFileException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (LineUnavailableException e) {
            e.printStackTrace();
        }
    }

    public void notif(){
        Clip clip;
        try {
            AudioInputStream input= AudioSystem.getAudioInputStream(new File("notif.wav"));
            clip=AudioSystem.getClip();
            clip.open(input);
            clip.start();

        } catch (UnsupportedAudioFileException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (LineUnavailableException e) {
            e.printStackTrace();
        }
    }

    public void error(){
        Clip clip;
        try {
            AudioInputStream input= AudioSystem.getAudioInputStream(new File("Error.wav"));
            clip=AudioSystem.getClip();
            clip.open(input);
            clip.start();

        } catch (UnsupportedAudioFileException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (LineUnavailableException e) {
            e.printStackTrace();
        }
    }

    public void exit(){
        Clip clip;
        try {
            AudioInputStream input= AudioSystem.getAudioInputStream(new File("Exit_sound.wav"));
            clip=AudioSystem.getClip();
            clip.open(input);
            clip.start();

        } catch (UnsupportedAudioFileException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (LineUnavailableException e) {
            e.printStackTrace();
        }
    }

}
// File file = new File("Downtempo-music-loop-102-bpm.wav");
//        AudioInputStream audioStream = AudioSystem.getAudioInputStream(file);
//        Clip clip = AudioSystem.getClip();
//        clip.open(audioStream);
//        switch (a){
//            case (0):clip.start();
//                System.out.println("Start");
//                break;
//            case(1):clip.stop();
//                System.out.println("Stop");
//                break;
//            case(2):clip.close();
//                System.out.println("close");
//            break;
//            case (3):clip.setMicrosecondPosition(0);
//                System.out.println("reset");
//            break;
//        }