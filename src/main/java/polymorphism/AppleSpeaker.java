package polymorphism;

public class AppleSpeaker implements Speaker {

  @Override
  public void volumeUp() {
    System.out.println("apple");
  }

  @Override
  public void volumeDown() {
    System.out.println("apple");
  }
}
