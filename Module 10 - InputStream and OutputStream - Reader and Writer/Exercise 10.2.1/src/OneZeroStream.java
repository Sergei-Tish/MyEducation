import java.io.InputStream;

public class OneZeroStream extends InputStream {
    private byte[] bytes = {'1', ' ', '0', ' '};
    int i = 0;
    public int read(){
        if (i >= bytes.length)
            i = 0;
        return bytes[i++];
    }
}