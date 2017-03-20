package ch.heigvd.res.stpatrick;


/**
 * 
 * @author Olivier Liechti
 * @author David Truan
 */
public class Application {

  IStreamProcessorsFactory processorsFactory = new StreamProcessorsFactory();
  
  public IStreamProcessorsFactory getStreamProcessorsFactory() {
    return processorsFactory;
  }

  IStreamDecoratorController getStreamDecoratorController() {
    return null;
  }
}
