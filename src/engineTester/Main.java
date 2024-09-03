package engineTester;

import org.lwjgl.glfw.GLFW;

import engine.io.Input;
import engine.io.Window;

public class Main implements Runnable{
    private Thread game;
    private Window window;
    private final int WIDTH = 1280, HEIGHT = 720;
    
    public void start() {
        game = new Thread(this, "game");
        game.start();
    }
    
    public void run() {
        init();
        while(!window.shouldClose() && !Input.isKeyDown(GLFW.GLFW_KEY_ESCAPE)) {
            loop();
        }
        close();
    }

    private void init() {
        window = new Window(WIDTH, HEIGHT, "triworld");
        window.setBackgroundColor(173/255f, 216/255f, 230/255f);
        window.create();
    }
    
    private void loop() {
        if (Input.isKeyDown(GLFW.GLFW_KEY_F11)) {
            window.setFullscreen(!window.isFullscreen());
        }
        window.update();
        window.swapBuffers();
    }
    
    private void close() {
        window.destroy();
    }

    public static void main(String[] args) {
        new Main().start();
    }
}