package polymorphism;

public class SamsungTV implements TV {
  
  private SonySpeaker speaker;
    
  public SonySpeaker getSpeaker() {
    return speaker;
  }

  public void setSpeaker(SonySpeaker speaker) {
    this.speaker = speaker;
  }

  @Override
  public void powerOn() {
    System.out.println("SamsungTV");
  }

  @Override
  public void powerOff() {
    System.out.println("SamsungTV");
  }

  @Override
  public void volumeUp() {
    speaker.volumeDown();
    System.out.println("SamsungTV");
  }

  @Override
  public void volumeDown() {
    System.out.println("SamsungTV");
  }
  
}
