package polymorphism;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class TVUser {
  AbstractApplicationContext factory = new GenericXmlApplicationContext("applicationContext.xml");
}
