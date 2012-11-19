package org.willyfrog.scalainvaders

import com.badlogic.gdx.Game
import com.badlogic.gdx.Gdx
import com.badlogic.gdx.InputAdapter
import com.badlogic.gdx.audio.Music
import com.badlogic.gdx.graphics.FPSLogger
import com.badlogic.gdx.Input.Keys
import org.willyfrog.scalainvaders.screens.MenuScreen
import org.willyfrog.scalainvaders.screens.BaseScreen

class MyGame extends Game {
  var music: Music = null
  var fps: FPSLogger = null
 
  override def create() {
    setScreen(new MenuScreen())

    Gdx.input.setInputProcessor(new InputAdapter(){
      override def keyUp (keycode:Int):Boolean = {
        if (keycode == Keys.ENTER){
          if (!Gdx.graphics.isFullscreen())
            Gdx.graphics.setDisplayMode(Gdx.graphics.getDisplayModes()(0))
        }
        return true
      }
    })

    fps = new FPSLogger()
  }
  override def render() {
    
    var currentScreen:BaseScreen = getScreen()
    var nextScreen = currentScreen.isDone()
    if ( nextScreen != null){
      currentScreen.dispose()
      setScreen(nextScreen)
    }

    fps.log()
  }
  override def dispose() {}
  override def pause() {}
  override def resume() {}
  override def resize(x: Int, y: Int) {}

  override def getScreen():BaseScreen = super.getScreen().asInstanceOf[BaseScreen]
}
