package pattern.part3.chapter8.remote;

import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;
import java.util.Iterator;

/**
 * Date: Dec 8, 2010
 * Time: 8:01:07 AM
 *|| */
public class Service_Skeleton extends Thread {
    private Service service;

    public Service_Skeleton(Service service) {
        this.service = service;
    }

    @Override
    public void run() {
        ServerSocketChannel serverSocketChannel = null;
        Selector sel = null;
        SocketChannel ch = null;
        boolean finished=false;
        try {
            ByteBuffer buffer = ByteBuffer.allocate(32);
            serverSocketChannel = ServerSocketChannel.open();
            sel = Selector.open();

            serverSocketChannel.socket().bind(new InetSocketAddress(InetAddress.getLocalHost(), 3900));
            serverSocketChannel.configureBlocking(false);
            serverSocketChannel.register(sel, SelectionKey.OP_ACCEPT);

            String encoding = System.getProperty("file.encoding");
            Charset cs = Charset.forName(encoding);

            while (!finished) {
                sel.select();
                Iterator it = sel.selectedKeys().iterator();
                while (it.hasNext()) {
                    SelectionKey skey = (SelectionKey) it.next();
                    it.remove();
                    if (skey.isAcceptable()) {//select a channel to read and write
                        ch = serverSocketChannel.accept();
                        ch.configureBlocking(false);
                        //register a read operatioin
                        ch.register(sel, SelectionKey.OP_READ);
                    } else if (skey.isReadable()) {
                        ch = (SocketChannel) skey.channel();
                        //read info from this channel
                        if (ch.read((ByteBuffer) buffer.clear()) > 0) {
                            buffer.flip();
                            String method = cs.decode(buffer).toString();
                            //if it says "hello", register a write operation
                            if ("hello".equals(method)) {
                                ch.register(sel, SelectionKey.OP_WRITE);
                            }
                        }
                    } else { // is writable
                        ch = (SocketChannel) skey.channel();
                        // invoke the service.hello method and write the result into the channel
                        ch.write(ByteBuffer.wrap(service.hello().getBytes()));
                        ch.close();//close the channel
                        finished=true;//quit server
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (ch != null) ch.close();
                if (serverSocketChannel != null) serverSocketChannel.close();
                if (sel != null) sel.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        Service_Skeleton Service_Skeleton = new Service_Skeleton(new ServiceImpl());
        Service_Skeleton.start();
    }
}