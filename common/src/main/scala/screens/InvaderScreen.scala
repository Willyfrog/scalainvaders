package org.willyfrog.scalainvaders.screens

import com.badlogic.gdx.Screen

trait ScreenTransition {
  var nextScreen:Screen = null
  def isDone():Screen = nextScreen
}
