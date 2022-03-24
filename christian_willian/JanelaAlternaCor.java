package christian_willian;

import com.jogamp.opengl.*;
import com.jogamp.newt.opengl.GLWindow;
import com.jogamp.opengl.util.*;

public final class JanelaAlternaCor implements GLEventListener {
	private GL4 gl;

	private static int width = 600;
	private static int height = 600;

	private static float incremento = 0.005f;
	private float r = 1.0f;
	private float g = 0.0f;
	private float b = 0.0f;
	private float incremento_red = 0.0f;
	private float incremento_green = incremento;
	private float incremento_blue = incremento;

	public static void main(String[] s) {
		System.out.println("main");

		GLCapabilities caps = new GLCapabilities(GLProfile.get(GLProfile.GL4));
		GLWindow glWindow = GLWindow.create(caps);

		// Setup the GLWindow
		glWindow.setTitle("Alternando cores da Janela - JOGL");
		glWindow.setSize(width,height);
		glWindow.setUndecorated(false);
		glWindow.setPointerVisible(true);
		glWindow.setVisible(true);

		// Finally we connect the GLEventListener application code to the GLWindow.

		glWindow.addGLEventListener(new JanelaAlternaCor());
		Animator animator = new Animator();
		animator.add(glWindow);
		animator.start();
	}

	public void init(GLAutoDrawable drawable) {
		System.out.println("init");

		gl = drawable.getGL().getGL4();
	}

	public void display(GLAutoDrawable drawable) {
		float[] color = {r, g, b, 1.0f};

		gl.glClearBufferfv(GL4.GL_COLOR, 0, color, 0);
		r += incremento_red;
		g += incremento_green;
		b += incremento_blue;

		if( g >= 1.0 && incremento_red == 0.0f) {
			System.out.println("Primeiro if");
			r = 0.0f;
			g = 1.0f;
			b = 0.0f;
			incremento_green = 0.0f;
			incremento_red = incremento;
		} else if (b >= 1.0f && incremento_green == 0.0f) {
			System.out.println("Segundo if");
			r = 0.0f;
			g = 0.0f;
			b = 1.0f;
			incremento_green = incremento;
			incremento_blue = 0.0f;
		}
	}

	public void reshape(GLAutoDrawable drawable, int x, int y, int z, int h) {
		System.out.println("reshape");
	}

	public void dispose(GLAutoDrawable drawable){
		System.out.println("dispose");
	}
}
