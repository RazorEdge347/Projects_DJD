package pt.ipb.esact.compgraf.tools;

import com.google.common.collect.Maps;
import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MediaPlayer {

    private static final Logger logger = LoggerFactory.getLogger(MediaPlayer.class);

    private static MediaPlayer INSTANCE;

    private final Map<String, byte[]> playerCache = Maps.newHashMap();

    private ExecutorService executorService;

    public MediaPlayer() {
        this.executorService = Executors.newFixedThreadPool(10);
    }

    public static MediaPlayer getInstance() {
        if (INSTANCE == null)
            INSTANCE = new MediaPlayer();
        return INSTANCE;
    }

    public Player play(final String path) {
        return play(path, 0, false);
    }

    public Player loop(final String path) {
        return play(path, 0, true);
    }

    public Player play(final String path, final long delay) {
        return play(path, delay, false);
    }

    public Player play(final String path, final long delay, final boolean loop) {
        if (!playerCache.containsKey(path))
            try {
                playerCache.put(path, Files.readAllBytes(Paths.get(path)));
            } catch (IOException e) {
                GlTools.exit(e.getMessage());
            }

        try (ByteArrayInputStream bis = new ByteArrayInputStream(playerCache.get(path))) {
            if (loop)
                return submitLoop(bis, delay);
            else
                return submit(bis, delay);
        } catch (JavaLayerException | IOException e) {
            GlTools.exit(e.getMessage());
            return null;
        }
    }

    private Player submit(ByteArrayInputStream bis, final long delay) throws JavaLayerException {
        final Player player = new Player(bis);
        executorService.submit(new Runnable() {
            @Override
            public void run() {
                if (player != null) {
                    try {
                        if (delay > 0)
                            Thread.sleep(delay);
                        player.play();
                    } catch (JavaLayerException | InterruptedException e) {
                        GlTools.exit(e.getMessage());
                    }
                }
            }
        });
        return player;

    }

    private Player submitLoop(ByteArrayInputStream bis, final long delay) throws JavaLayerException {
        final LoopPlayer player = new LoopPlayer(bis);
        executorService.submit(new Runnable() {
            @Override
            public void run() {
                if (player != null) {
                    try {
                        if (delay > 0)
                            Thread.sleep(delay);
                        player.play();
                    } catch (JavaLayerException | InterruptedException e) {
                        GlTools.exit(e.getMessage());
                    }
                }
            }
        });
        return player;
    }

}
