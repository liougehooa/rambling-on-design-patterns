package pattern.part3.chapter8.remote;

import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;
import java.util.Iterator;

/**
 * Date: Dec 7, 2010
 * Time: 8:39:26 PM
 * ||
 */
public class Service_Stub implements Service {

    @Override
    public String hello() {
        SocketChannel socketChannel = null;
        Selector sel = null;
        try {
            socketChannel = SocketChannel.open();
            InetSocketAddress inetSocketAddress = new InetSocketAddress(InetAddress.getLocalHost(), 3900);

            sel = Selector.open();
            socketChannel.connect(inetSocketAddress);
            socketChannel.configureBlocking(false);
            socketChannel.register(sel, SelectionKey.OP_WRITE);
            ByteBuffer byteBuffer = ByteBuffer.allocate(32);

            String encoding = System.getProperty("file.encoding");
            Charset cs = Charset.forName(encoding);
            while (true) {
                sel.select();
                Iterator it = sel.selectedKeys().iterator();
                while (it.hasNext()) {
                    SelectionKey key = (SelectionKey) it.next();
                    it.remove();
                    if (key.isReadable()) {//read the result of remote service's method hello
                        if (socketChannel.read((ByteBuffer) byteBuffer.clear()) > 0) {//read the result
                            byteBuffer.flip();
                            socketChannel.close();//close the channel and return
                            return cs.decode(byteBuffer).toString();//return result
                        }
                    } else {  //is writable, request remote service's hello method
                        //write "hello" to skeleton...
                        socketChannel.write(ByteBuffer.wrap("hello".getBytes()));
                        //register a read operatioin to wait for the response...
                        socketChannel.register(sel, SelectionKey.OP_READ);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (socketChannel != null) socketChannel.close();
                if (sel != null) sel.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}
