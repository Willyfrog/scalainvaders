package org.wilyfrog.scalainvaders.cosas

import com.badlogic.gdx.math.Vector3

class Invader (var position: Vector3) {

  val INVADER_RADIUS = 0.75f
  val INVADER_VELOCITY = 1f
  val INVADER_POINTS = 40
  val STATE_MOVE_LEFT = -1
  val STATE_MOVE_DOWN = 0
  val STATE_MOVE_RIGHT = 1

  val STATE_SEQ = Array(-1,0,1,0)

  var stateIndex:Int = 0

  val SCREEN_X = 50

 // val movement = Simulation.PLAYFIELD_MAX / 2
  var movement:Float = SCREEN_X / 2

  def update ( delta: Float, speedMultiplier: Float) {
    movement += delta * INVADER_VELOCITY * speedMultiplier

    var nextState = false

    if (STATE_SEQ(stateIndex) != STATE_MOVE_DOWN) {
      position.x += delta * INVADER_VELOCITY * speedMultiplier * STATE_SEQ(stateIndex)
      if (movement > SCREEN_X)
          nextState = true
       }
     else{
       position.z += delta * INVADER_VELOCITY * speedMultiplier
       if (movement > 1)
         nextState = true
     }

    if (nextState){
      stateIndex = (stateIndex + 1) % 4
      movement = 0
    }
    
  }
}
