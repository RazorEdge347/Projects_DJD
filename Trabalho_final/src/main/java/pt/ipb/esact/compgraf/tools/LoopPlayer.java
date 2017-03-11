package pt.ipb.esact.compgraf.tools;

import com.sun.xml.internal.messaging.saaj.util.ByteInputStream;
import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.AudioDevice;
import javazoom.jl.player.Player;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;

public class LoopPlayer extends Player {

    private static final Logger logger = LoggerFactory.getLogger(LoopPlayer.class);

    private Player wrapperPlayer;

    private boolean loop;

    private InputStream stream;

    private boolean complete;

    public LoopPlayer(InputStream stream, AudioDevice device) throws JavaLayerException {
        super(new ByteInputStream(), device); // f you!
        this.stream = stream;
        complete = false;
    }

    public LoopPlayer(InputStream stream) throws JavaLayerException {
        this(stream, (AudioDevice) null);
    }

    @Override
    public synchronized boolean isComplete() {
        return complete || (wrapperPlayer != null && wrapperPlayer.isComplete());
    }

    @Override
    public int getPosition() {
        return wrapperPlayer == null ? 0 : wrapperPlayer.getPosition();
    }

    @Override
    public void play() throws JavaLayerException {
        play(2147483647);
    }

    @Override
    public boolean play(int frames) throws JavaLayerException {
        loop = true;
        do {
            try {
                stream.reset();
                wrapperPlayer = new Player(stream);
                wrapperPlayer.play(frames);
            } catch (IOException e) {
                logger.error(e.getMessage(), e);
                return false;
            }
        } while (loop);
        return true;
    }

    @Override
    public synchronized void close() {
        loop = false;
        if (wrapperPlayer != null)
            wrapperPlayer.close();
        complete = true;
    }

}
