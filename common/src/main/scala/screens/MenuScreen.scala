package org.willyfrog.scalainvaders.screens

import com.badlogic.gdx.Gdx
import com.badlogic.gdx.Screen
import com.badlogic.gdx.graphics.Color
import com.badlogic.gdx.graphics.Texture
import com.badlogic.gdx.graphics.Texture.TextureFilter
import com.badlogic.gdx.graphics.g2d.BitmapFont
import com.badlogic.gdx.graphics.g2d.SpriteBatch
import com.badlogic.gdx.graphics.GL10
import com.badlogic.gdx.math.Matrix4
import org.wilyfrog.scalainvaders.cosas.Mundo



class MenuScreen extends BaseScreen{
  val batch = new SpriteBatch()
  var bg = new Texture(Gdx.files.internal("data/planet.jpg"))
  bg.setFilter(TextureFilter.Linear, TextureFilter.Linear)
  var logo = new Texture(Gdx.files.internal("data/title.jpg"))
  logo.setFilter(TextureFilter.Linear, TextureFilter.Linear)

  lazy val font = new BitmapFont(Gdx.files.internal("data/font16.fnt"), Gdx.files.internal("data/font16.png"), false)
  var viewMatrix = new Matrix4()
  var transformMatrix = new Matrix4()

    def show(){
  }
  
  def render(delta: Float){
    if (Gdx.input.justTouched())
      nextScreen = new GameLoop()
    Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT)
    viewMatrix.setToOrtho2D(0, 0, 480, 320)

    batch.setProjectionMatrix(viewMatrix)
    batch.setTransformMatrix(transformMatrix)
    
    batch.begin()
    batch.disableBlending()
    batch.setColor(Color.WHITE)

    batch.draw(bg, 0, 0, 480, 320, 0, 0, 512,512, false, false)
    batch.enableBlending()
    batch.draw(logo, 0, 320 - 128, 480, 128, 0, 0, 512, 256, false, false)
    batch.setBlendFunction(GL10.GL_ONE, GL10.GL_ONE_MINUS_SRC_ALPHA)
    val starttext = "Touch screen to start"
    val width:Float = font.getBounds(starttext).width
    font.draw(batch, starttext, 240 - width/2, 128 - font.getLineHeight())
    batch.end()
    
  }

  def resize( width:Int, height: Int){
  }

  def hide(){
  }

  def pause(){
  }

  def resume(){
  }

  def dispose(){
    batch.dispose()
    bg.dispose()
    logo.dispose()
    font.dispose()
  }
}
