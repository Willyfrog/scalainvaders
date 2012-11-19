package org.willyfrog.scalainvaders.screens

import com.badlogic.gdx.Screen
import org.wilyfrog.scalainvaders.cosas.Mundo

class GameLoop extends BaseScreen{
  val mundo:Mundo = new Mundo()
  var spriteBatch = null
  
  def show(){
  }
  
  def render(delta: Float){
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
    
  }
}
