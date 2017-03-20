package ch.heigvd.res.stpatrick;

import java.io.FilterWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;


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
    return new IStreamDecoratorController() {
        @Override
        public Reader decorateReader(Reader inputReader) {
            return inputReader;
        }

        @Override
        public Writer decorateWriter(Writer outputWriter) {
            outputWriter = new FilterWriter(outputWriter) {
                @Override
                public void write(String str, int off, int len) throws IOException {
                    write(str.toCharArray(), off, len);
                }

                @Override
                public void write(char[] cbuf, int off, int len) throws IOException {
                    for (int i = off; i < off + len; ++i) {
                        write(cbuf[i]);
                    }

                }

                @Override
                public void write(int c) throws IOException {
                    if(c != 'A' && c != 'a')
                     out.write(Character.toUpperCase(c));
                }
            };
            return outputWriter;
        }
    };
  }
}
