package polymorphism;

public class SonySpeaker implements Speaker {
  public SonySpeaker() {
    System.out.println("SonySpeaker");
  }
  public void volumeUp() {
    System.out.println("SonySpeaker");
  }
  public void volumeDown() {
    System.out.println("SonySpeaker");
  }
}
