package pro.nanosystems.jumpman;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class JumpMan extends ApplicationAdapter {
    SpriteBatch batch;
    Texture background;
    Texture[] man;
    int manState = 0;
    // TODO (1) Declare pause to slow down walk speed: int pause = 0;
    int pause = 0;

    @Override
    public void create() {
        batch = new SpriteBatch();
        background = new Texture("bg.png");
        man = new Texture[4];
        man[0] = new Texture("frame-1.png");
        man[1] = new Texture("frame-2.png");
        man[2] = new Texture("frame-3.png");
        man[3] = new Texture("frame-4.png");
    }

    @Override
    public void render() {

        batch.begin();
        // draw scene
        batch.draw(background, 0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        // TODO (2) Slow down walk speed by 8 cycle
        if (pause < 8) {// To delay move.
            pause++;
        } else {
            pause = 0;
            if (manState < 3) {
                manState++;
            } else manState = 0;
        }
        
        batch.draw(man[manState], Gdx.graphics.getWidth() / 2 - man[manState].getWidth() / 2, Gdx.graphics.getHeight() / 2 - man[manState].getHeight() / 2);


        batch.end();
    }

    @Override
    public void dispose() {
        batch.dispose();
        background.dispose();
        for (int i = 0; i < 4; i++) {
            man[i].dispose();
        }
    }
}
